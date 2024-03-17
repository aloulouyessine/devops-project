package tn.esprit.devops_project.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProductServiceImplTestMockito {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        Stock stock = new Stock();
        stock.setIdStock(1L);

        when(stockRepository.findById(1L)).thenReturn(java.util.Optional.of(stock));
        when(productRepository.save(product)).thenReturn(product);

        productService.addProduct(product, 1L);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteProduct() {
        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    
}
