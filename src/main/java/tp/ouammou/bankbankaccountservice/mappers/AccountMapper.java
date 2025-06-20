package tp.ouammou.bankbankaccountservice.mappers;

import tp.ouammou.bankbankaccountservice.dto.BankAccountResponseDTO;
import tp.ouammou.bankbankaccountservice.entites.BankAccount;
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
