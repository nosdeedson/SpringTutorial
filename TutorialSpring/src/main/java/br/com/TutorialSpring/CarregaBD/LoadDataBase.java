package br.com.TutorialSpring.CarregaBD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.TutorialSpring.Model.Employee;
import br.com.TutorialSpring.Repository.EmployeeRepository;

@Configuration
public class LoadDataBase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);
	
	@Bean
	CommandLineRunner initDataBase( EmployeeRepository repository) {
		return args -> {
			log.info("Preloading" + repository.save(new Employee("Bilbo Baggins", "burglar")));
		    log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}

}
