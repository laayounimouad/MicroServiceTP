package ma.laayouni.microservicetp.services;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.entites.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update( CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
