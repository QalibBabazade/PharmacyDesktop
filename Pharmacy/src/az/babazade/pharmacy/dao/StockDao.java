package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.Stock;

import java.util.List;

public interface StockDao {

    List<Stock> getStockList() throws Exception;

    void addStock(Stock stock) throws Exception;

    void updateStock(Stock stock) throws Exception;

    void deleteStock(Long stockId) throws Exception;

    List<Stock> searchStock(String keyword) throws Exception;

}
