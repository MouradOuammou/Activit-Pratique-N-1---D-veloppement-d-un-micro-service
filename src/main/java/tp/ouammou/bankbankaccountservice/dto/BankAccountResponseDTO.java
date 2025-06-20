package tp.ouammou.bankbankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {

    private String Id ;
    private Date creationDate;
    private Double balance;
    private String accountType;
    private String currency;
}
