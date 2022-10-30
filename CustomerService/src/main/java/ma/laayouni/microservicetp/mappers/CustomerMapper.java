package ma.laayouni.microservicetp.mappers;

import ma.laayouni.microservicetp.dtos.CustomerRequestDTO;
import ma.laayouni.microservicetp.dtos.CustomerResponseDTO;
import ma.laayouni.microservicetp.entites.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}