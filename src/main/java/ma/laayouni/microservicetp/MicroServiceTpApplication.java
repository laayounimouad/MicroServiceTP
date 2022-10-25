package ma.laayouni.microservicetp;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
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
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","name1","mail@email.com"));
            customerService.save(new CustomerRequestDTO("C02","name2","mail@email.com"));
            customerService.save(new CustomerRequestDTO("C03","name3","mail@email.com"));
            customerService.save(new CustomerRequestDTO("C03","name3","mail@email.com"));
         };
    }

}
