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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceImplTestJUnit {

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
    public void testRetrieveProduct() {
        Product expectedProduct = new Product();
        expectedProduct.setId(1L);
        expectedProduct.setName("Test Product");

        when(productRepository.findById(1L)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.retrieveProduct(1L);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testRetrieveAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");

        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.retreiveAllProduct();

        assertEquals(expectedProducts.size(), actualProducts.size());
        assertEquals(expectedProducts.get(0), actualProducts.get(0));
        assertEquals(expectedProducts.get(1), actualProducts.get(1));
    }


}
