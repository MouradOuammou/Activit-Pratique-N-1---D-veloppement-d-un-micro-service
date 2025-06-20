    package tp.ouammou.bankbankaccountservice.entites;

    import jakarta.persistence.*;
    import tp.ouammou.bankbankaccountservice.enums.AccountType;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.Date;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class BankAccount {
        @Id
        private String id ;
        private Date creationDate;
        private Double balance;
        @Enumerated(EnumType.STRING)
        private AccountType accountType;
        private String currency;
        @ManyToOne
        private Customer customer;
    }
