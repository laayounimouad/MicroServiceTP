package ma.laayouni.billingservicetp.services;

import ma.laayouni.billingservicetp.dto.InvoiceRequestDTO;
import ma.laayouni.billingservicetp.dto.InvoiceResponseDTO;
import ma.laayouni.billingservicetp.entities.Customer;
import ma.laayouni.billingservicetp.entities.Invoice;
import ma.laayouni.billingservicetp.mappers.InvoiceMapper;
import ma.laayouni.billingservicetp.openfeign.CustomerRestClient;
import ma.laayouni.billingservicetp.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());


        Invoice saveInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
//                .orElse(null);
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);

        for (Invoice invoice : invoices) {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }

        return invoices
                .stream()
                .map(i -> invoiceMapper.fromInvoice(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for (Invoice invoice : invoices) {
             Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
                invoice.setCustomer(customer);
        }
        return invoices.stream().map(i->invoiceMapper.fromInvoice(i)).collect(Collectors.toList());
    }
}
