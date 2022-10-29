package ma.laayouni.microservicetp;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.entites.Customer;
import ma.laayouni.microservicetp.repositories.CustomerRepository;
import ma.laayouni.microservicetp.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServiceTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceTpApplication.class, args);

    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer("C01","name1","mail@email.com"));
            customerRepository.save(new Customer("C02","name2","mail@email.com"));
            customerRepository.save(new Customer("C03","name3","mail@email.com"));
            customerRepository.save(new Customer("C03","name3","mail@email.com"));
         };
    }

}
