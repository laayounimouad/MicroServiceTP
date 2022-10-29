package ma.laayouni.microservicetp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;
}
