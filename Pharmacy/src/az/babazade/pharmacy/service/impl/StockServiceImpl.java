package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.StockDao;
import az.babazade.pharmacy.model.Stock;
import az.babazade.pharmacy.service.StockService;

import java.util.List;

public class StockServiceImpl implements StockService {

    private StockDao stockDao;

    public StockServiceImpl(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public List<Stock> getStockList() throws Exception {
        return stockDao.getStockList();
    }

    @Override
    public void addStock(Stock stock) throws Exception {
        stockDao.addStock(stock);
    }

    @Override
    public void updateStock(Stock stock) throws Exception {
        stockDao.updateStock(stock);
    }

    @Override
    public void deleteStock(Long stockId) throws Exception {
        stockDao.deleteStock(stockId);
    }

    @Override
    public List<Stock> searchStock(String keyword) throws Exception {
        return stockDao.searchStock(keyword);
    }
}
