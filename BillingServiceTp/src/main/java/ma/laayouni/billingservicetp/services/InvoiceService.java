package ma.laayouni.billingservicetp.services;

import ma.laayouni.billingservicetp.dto.InvoiceRequestDTO;
import ma.laayouni.billingservicetp.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
}
