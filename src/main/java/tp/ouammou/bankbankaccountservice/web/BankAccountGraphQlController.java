package tp.ouammou.bankbankaccountservice.web;

import org.springframework.graphql.data.method.annotation.Argument;
import tp.ouammou.bankbankaccountservice.entites.BankAccount;
import tp.ouammou.bankbankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {

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
}
