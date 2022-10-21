package ma.laayouni.microservicetp.services;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.entites.Customer;
import ma.laayouni.microservicetp.mappers.CustomerMapper;
import ma.laayouni.microservicetp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        //Customer customer=new Customer();
        //customer.setId(customerRequestDTO.getId());
        //customer.setEmail(customerRequestDTO.getEmail());
        //customer.setName(customerRequestDTO.getName());

        Customer saveCustomer= customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        customerResponseDTO.setId(saveCustomer.getId());
        customerResponseDTO.setEmail(saveCustomer.getEmail());
        customerResponseDTO.setName(saveCustomer.getName());

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        return null;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        return null;
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        return null;
    }
}
