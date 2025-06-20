package tp.ouammou.bankbankaccountservice;

import tp.ouammou.bankbankaccountservice.entites.BankAccount;
import tp.ouammou.bankbankaccountservice.entites.Customer;
import tp.ouammou.bankbankaccountservice.enums.AccountType;
import tp.ouammou.bankbankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tp.ouammou.bankbankaccountservice.repositories.CustomRepository;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository , CustomRepository customerRepository) {
		return args -> {
			Stream.of("Mourad","Yassine,","Oussama","Hicham","Youssef")
					.forEach(name -> {
						Customer customer = Customer.builder()
								.name(name)
								.build();
						customerRepository.save(customer);
					});
			customerRepository.findAll().forEach(customer -> {
				for(int i=0;i<10;i++) {
					bankAccountRepository.save(
							BankAccount.builder()
									.id("BA" + i)
									.creationDate(new Date())
									.balance((double) (1000 + i * 100))
									.accountType(i % 2 == 0 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
									.currency("MAD")
									.customer(customer)
									.build()
					);
				}
			});
		};
	}
}
