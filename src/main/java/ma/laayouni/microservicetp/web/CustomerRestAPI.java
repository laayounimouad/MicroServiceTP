package ma.laayouni.microservicetp.web;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path = "/customers")
     public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
     }

    @PostMapping(path = "/customers")
     public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
     }

    @GetMapping(path = "/customers/{id}")
     public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
     }
}
