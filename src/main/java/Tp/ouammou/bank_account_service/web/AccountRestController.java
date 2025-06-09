package Tp.ouammou.bank_account_service.web;

import Tp.ouammou.bank_account_service.dto.BankAccountRequestDTO;
import Tp.ouammou.bank_account_service.dto.BankAccountResponseDTO;
import Tp.ouammou.bank_account_service.entites.BankAccount;
import Tp.ouammou.bank_account_service.mappers.AccountMapper;
import Tp.ouammou.bank_account_service.repositories.BankAccountRepository;
import Tp.ouammou.bank_account_service.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository repository;
    private BankAccountService service;
    private AccountMapper accountMapper ;
    public AccountRestController(BankAccountRepository repository,BankAccountService service , AccountMapper accountMapper) {
        this.repository = repository;
        this.service = service;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return repository.findAll();
    }
     public BankAccount bankAccounts(@PathVariable String Id) {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + Id));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return service.addBankAccount(bankAccount);
    }
    @PutMapping("/bankAccounts/{Id}")
    public BankAccount update( @PathVariable String Id ,@RequestBody BankAccount bankAccount) {
        BankAccount account = repository.findById(Id).orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + Id));
        if(bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getAccountType() != null) account.setAccountType(bankAccount.getAccountType());
        if(bankAccount.getCurrency() != null)  account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreationDate() != null)  account.setCreationDate(bankAccount.getCreationDate());
        return repository.save(account);
    }
    @DeleteMapping("/bankAccounts/{Id}")
    public void delete(@PathVariable String Id) {
        BankAccount account = repository.findById(Id).orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + Id));
        repository.delete(account);
    }
}
