package nl.bos.mockito;

import java.util.List;

public class Portfolio {
    private IStockService stockService;
    private List<Stock> stocks;

    public Portfolio(IStockService stockService, List<Stock> stocks) {
        this.stockService = stockService;
        this.stocks = stocks;
    }

    public IStockService getStockService() {
        return stockService;
    }

    public void setStockService(IStockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue() {
        double marketValue = 0.0;
        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
