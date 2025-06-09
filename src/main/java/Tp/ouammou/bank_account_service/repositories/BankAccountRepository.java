package Tp.ouammou.bank_account_service.repositories;

import Tp.ouammou.bank_account_service.entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
