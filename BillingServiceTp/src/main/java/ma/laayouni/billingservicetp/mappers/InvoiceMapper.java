package ma.laayouni.billingservicetp.mappers;

import ma.laayouni.billingservicetp.dto.InvoiceRequestDTO;
import ma.laayouni.billingservicetp.dto.InvoiceResponseDTO;
import ma.laayouni.billingservicetp.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);

}
