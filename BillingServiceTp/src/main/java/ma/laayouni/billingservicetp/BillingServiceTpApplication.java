package ma.laayouni.billingservicetp;

import ma.laayouni.billingservicetp.dto.InvoiceRequestDTO;
import ma.laayouni.billingservicetp.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceTpApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService){
        return args -> {
          invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(7600),"C01"));
        };
    }
}
