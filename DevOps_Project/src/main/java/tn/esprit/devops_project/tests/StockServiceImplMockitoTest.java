package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockServiceMockitoTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    public StockServiceMockitoTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddStock() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("Test Stock");

        when(stockRepository.save(any())).thenReturn(stock);

        Stock savedStock = stockService.addStock(stock);

        assertEquals(stock, savedStock);
        verify(stockRepository, times(1)).save(any());
    }

    @Test
    void testRetrieveStock() {
        Long id = 1L;
        Stock stock = new Stock();
        stock.setId(id);
        stock.setName("Test Stock");

        when(stockRepository.findById(id)).thenReturn(java.util.Optional.of(stock));

        Stock retrievedStock = stockService.retrieveStock(id);

        assertEquals(stock, retrievedStock);
        verify(stockRepository, times(1)).findById(id);
    }

    @Test
    void testRetrieveAllStock() {
        Stock stock1 = new Stock();
        stock1.setId(1L);
        stock1.setName("Stock 1");

        Stock stock2 = new Stock();
        stock2.setId(2L);
        stock2.setName("Stock 2");

        List<Stock> stockList = Arrays.asList(stock1, stock2);

        when(stockRepository.findAll()).thenReturn(stockList);

        List<Stock> retrievedStocks = stockService.retrieveAllStock();

        assertEquals(stockList, retrievedStocks);
        verify(stockRepository, times(1)).findAll();
    }
}
