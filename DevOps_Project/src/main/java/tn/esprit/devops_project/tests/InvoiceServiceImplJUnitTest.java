package tn.esprit.devops_project.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.InvoiceServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InvoiceServiceImplJUnitTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Test
    void retrieveAllInvoices() {
        // Assuming some test data is available in the repository
        List<Invoice> invoices = invoiceService.retrieveAllInvoices();
        assertEquals(3, invoices.size()); // Adjust the expected value based on your test data
    }

    @Test
    void cancelInvoice() {
        // Assuming an existing invoice in the repository
        Long invoiceId = 1L;
        invoiceService.cancelInvoice(invoiceId);

        // Retrieve the invoice and assert that it is archived
        Invoice canceledInvoice = invoiceRepository.findById(invoiceId).orElse(null);
        assertEquals(true, canceledInvoice.getArchived());
    }

    // Add more test methods for other functionalities

}
