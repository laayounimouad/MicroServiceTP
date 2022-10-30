package ma.laayouni.microservicetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data @NoArgsConstructor
@AllArgsConstructor

public class CustomerResponseDTO {
    private String id;
    private String name;
    private String email;
}
