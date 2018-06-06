package nl.bos.mockito;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTest {
    private IStockService stockService;
    private Portfolio portfolio;

    @Before
    public void setUp() throws Exception {
        stockService = mock(IStockService.class);
        portfolio = new Portfolio();
        portfolio.setStockService(stockService);
    }

    @Test
    public void getMarketValue() {
        List stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 1);
        Stock microsoftStock = new Stock("2", "Microsoft", 1);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        assertEquals(1050.0, marketValue);
    }
}
