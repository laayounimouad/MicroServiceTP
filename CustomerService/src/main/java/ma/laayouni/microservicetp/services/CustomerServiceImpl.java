package ma.laayouni.microservicetp.services;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.entites.Customer;
import ma.laayouni.microservicetp.mappers.CustomerMapper;
import ma.laayouni.microservicetp.repositories.CustomerRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customer.setId(UUID.randomUUID().toString());
        Customer saveCustomer= customerRepository.save(customer);

        /**
         * Mapping object
         */
        //CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        //customerResponseDTO.setId(saveCustomer.getId());
        //customerResponseDTO.setEmail(saveCustomer.getEmail());
        //customerResponseDTO.setName(saveCustomer.getName());

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer= customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer=customerRepository.save(customer);

        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=
                customers.stream()
                        .map(customer -> customerMapper.customerToCustomerResponseDTO(customer)
                        ).collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
