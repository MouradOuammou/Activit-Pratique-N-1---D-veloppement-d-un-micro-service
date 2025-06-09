package Tp.ouammou.bank_account_service.web;

import Tp.ouammou.bank_account_service.entites.BankAccount;
import Tp.ouammou.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository repository;
    public AccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return repository.findAll();
    }
     public BankAccount bankAccounts(@PathVariable String Id) {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Bank account not found with ID: " + Id));
    }
    @PostMapping("/bankAccounts")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
        if (bankAccount.getId() == null) {
            bankAccount.setId(UUID.randomUUID().toString() + "-" + bankAccount.getId());
        }
        return repository.save(bankAccount);
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
