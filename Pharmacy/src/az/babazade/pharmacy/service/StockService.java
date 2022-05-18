package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getStockList() throws Exception;

    void addStock(Stock stock) throws Exception;

    void updateStock(Stock stock) throws Exception;

    void deleteStock(Long stockId) throws Exception;

    List<Stock> searchStock(String keyword) throws Exception;

}
