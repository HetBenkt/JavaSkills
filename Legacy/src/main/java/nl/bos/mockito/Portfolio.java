package nl.bos.mockito;

import lombok.Data;

import java.util.List;

@Data
public class Portfolio {
    private IStockService stockService;
    private List<Stock> stocks;

    public double getMarketValue() {
        double marketValue = 0.0;
        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
