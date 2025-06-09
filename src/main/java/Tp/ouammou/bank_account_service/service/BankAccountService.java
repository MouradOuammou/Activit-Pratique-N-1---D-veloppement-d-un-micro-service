package Tp.ouammou.bank_account_service.service;

import Tp.ouammou.bank_account_service.dto.*;
import Tp.ouammou.bank_account_service.entites.BankAccount;

public interface BankAccountService {
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);

}
