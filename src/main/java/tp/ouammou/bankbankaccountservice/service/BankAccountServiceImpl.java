package tp.ouammou.bankbankaccountservice.service;

import tp.ouammou.bankbankaccountservice.dto.BankAccountRequestDTO;
import tp.ouammou.bankbankaccountservice.dto.BankAccountResponseDTO;
import tp.ouammou.bankbankaccountservice.entites.BankAccount;
import tp.ouammou.bankbankaccountservice.enums.AccountType;
import tp.ouammou.bankbankaccountservice.mappers.AccountMapper;
import tp.ouammou.bankbankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper ;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }
    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .accountType(AccountType.valueOf(bankAccountDTO.getAccountType()))
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .creationDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .accountType(AccountType.valueOf(bankAccountDTO.getAccountType()))
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
