package Tp.ouammou.bank_account_service.service;

import Tp.ouammou.bank_account_service.dto.BankAccountRequestDTO;
import Tp.ouammou.bank_account_service.dto.BankAccountResponseDTO;
import Tp.ouammou.bank_account_service.entites.BankAccount;
import Tp.ouammou.bank_account_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .Id(UUID.randomUUID().toString())
                .creationDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .accountType(bankAccountDTO.getAccountType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO BankAccountResponseDTO = BankAccountResponseDTO.builder()
                .Id(savedBankAccount.getId())
                .creationDate(savedBankAccount.getCreationDate())
                .balance(savedBankAccount.getBalance())
                .accountType(savedBankAccount.getAccountType())
                .currency(savedBankAccount.getCurrency())
                .build();
        return BankAccountResponseDTO;
    }
}
