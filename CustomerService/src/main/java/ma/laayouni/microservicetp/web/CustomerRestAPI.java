package ma.laayouni.microservicetp.web;

import lombok.AllArgsConstructor;
import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerRestAPI {
    private CustomerService customerService;

    @GetMapping(path = "/customers")
     public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
     }

    @PostMapping(path = "/customers")
     public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
     }

    @GetMapping(path = "/customers/{id}")
     public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
     }

}
