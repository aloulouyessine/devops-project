package tn.esprit.devops_project.tests;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.InvoiceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvoiceServiceImplMockitoTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Test
    void retrieveAllInvoices() {
        // Mocking data for the repository
        List<Invoice> mockInvoices = new ArrayList<>();
        mockInvoices.add(new Invoice());
        mockInvoices.add(new Invoice());

        // Mocking the repository behavior
        when(invoiceRepository.findAll()).thenReturn(mockInvoices);

        // Test the service method
        List<Invoice> invoices = invoiceService.retrieveAllInvoices();

        // Assertions
        assertEquals(2, invoices.size());
    }

    @Test
    void cancelInvoice() {
        // Assuming an existing invoice in the repository
        Long invoiceId = 1L;
        Invoice existingInvoice = new Invoice();
        existingInvoice.setIdInvoice(invoiceId);
        existingInvoice.setArchived(false);

        // Mocking the repository behavior
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(existingInvoice));

        // Test the service method
        invoiceService.cancelInvoice(invoiceId);

        // Assertions
        assertEquals(true, existingInvoice.getArchived());
    }

    @Test
    void retrieveInvoice() {
        // Assuming a mock invoice with ID 1L
        Invoice mockInvoice = new Invoice();
        mockInvoice.setId(1L);

        // Mocking the repository behavior
        when(invoiceRepository.findById(1L)).thenReturn(Optional.of(mockInvoice));

        // Test the service method
        Invoice retrievedInvoice = invoiceService.retrieveInvoice(1L);

        // Assertions
        assertEquals(1L, retrievedInvoice.getIdInvoice());
    }

    // Add more test methods for other functionalities using Mockito to mock dependencies

}
