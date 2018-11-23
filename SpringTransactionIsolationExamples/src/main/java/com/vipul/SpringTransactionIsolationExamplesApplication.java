package com.vipul;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vipul.service.PersonService;

@EnableTransactionManagement
@SpringBootApplication
public class SpringTransactionIsolationExamplesApplication {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication
				.run(SpringTransactionIsolationExamplesApplication.class, args);
		PersonService personService = context.getBean(PersonService.class);
		personService.defaultIsolation();
		personService.readCommitted();
		personService.readUnCommitted();
		personService.repeatableRead();
		personService.serializable();
	}
}
