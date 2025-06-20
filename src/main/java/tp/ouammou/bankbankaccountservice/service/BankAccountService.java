package tp.ouammou.bankbankaccountservice.service;

import tp.ouammou.bankbankaccountservice.dto.BankAccountRequestDTO;
import tp.ouammou.bankbankaccountservice.dto.BankAccountResponseDTO;

public interface BankAccountService {
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
