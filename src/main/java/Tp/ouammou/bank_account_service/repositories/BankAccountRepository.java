package Tp.ouammou.bank_account_service.repositories;

import Tp.ouammou.bank_account_service.entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
