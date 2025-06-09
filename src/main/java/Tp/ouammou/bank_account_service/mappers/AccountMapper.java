package Tp.ouammou.bank_account_service.mappers;

import Tp.ouammou.bank_account_service.dto.BankAccountResponseDTO;
import Tp.ouammou.bank_account_service.entites.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return  bankAccountResponseDTO;
    }
}
