package tp.ouammou.bankbankaccountservice.web;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import tp.ouammou.bankbankaccountservice.dto.BankAccountRequestDTO;
import tp.ouammou.bankbankaccountservice.dto.BankAccountResponseDTO;
import tp.ouammou.bankbankaccountservice.entites.BankAccount;
import tp.ouammou.bankbankaccountservice.entites.Customer;
import tp.ouammou.bankbankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tp.ouammou.bankbankaccountservice.repositories.CustomRepository;
import tp.ouammou.bankbankaccountservice.service.BankAccountService;

import java.util.List;

@Controller
public class BankAccountGraphQlController {

    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountGraphQlController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument  String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount (@Argument BankAccountRequestDTO bankAccount) {
      return  bankAccountService.addBankAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO update ( @Argument String id ,@Argument BankAccountRequestDTO bankAccount) {
        return  bankAccountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public boolean delete ( @Argument String id ) {
        bankAccountRepository.deleteById(id);
        return  true ;
    }
    @QueryMapping
    public  List<Customer> customers(){
        return  customRepository.findAll();
    }


}
