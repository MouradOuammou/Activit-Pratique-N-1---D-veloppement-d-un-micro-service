package tp.ouammou.bankbankaccountservice.entites;

import tp.ouammou.bankbankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {BankAccount.class} , name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getAccountType();
    public Double getBalance();
}
