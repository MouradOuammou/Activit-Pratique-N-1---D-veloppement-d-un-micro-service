package Tp.ouammou.bank_account_service;

import Tp.ouammou.bank_account_service.entites.BankAccount;
import Tp.ouammou.bank_account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository) {
		return args -> {
			for(int i=0;i<10;i++) {
				bankAccountRepository.save(
						BankAccount.builder()
								.Id("BA" + i)
								.creationDate(new Date())
								.balance((double) (1000 + i * 100))
								.accountType(i % 2 == 0 ? "CURRENT_ACCOUNT" : "SAVINGS_ACCOUNT")
								.currency("MAD")
								.build()
				);
			}
		};
	}
}
