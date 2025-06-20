package tp.ouammou.bankbankaccountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tp.ouammou.bankbankaccountservice.entites.Customer;

public interface CustomRepository extends JpaRepository<Customer, Long> {

}
