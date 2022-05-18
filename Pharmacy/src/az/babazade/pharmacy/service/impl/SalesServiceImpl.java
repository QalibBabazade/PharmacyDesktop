package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.SalesDao;
import az.babazade.pharmacy.model.Sales;
import az.babazade.pharmacy.service.SalesService;

import java.util.List;

public class SalesServiceImpl implements SalesService {

    private SalesDao salesDao;

    public SalesServiceImpl(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    @Override
    public List<Sales> getSalesList() throws Exception {
        return salesDao.getSalesList();
    }

    @Override
    public void addSales(Sales sales) throws Exception {
        salesDao.addSales(sales);
    }

    @Override
    public void updateSales(Sales sales) throws Exception {
         salesDao.updateSales(sales);
    }

    @Override
    public void deleteSales(Long id) throws Exception {
        salesDao.deleteSales(id);
    }

    @Override
    public List<Sales> searchSales(String keyword) throws Exception {
        return salesDao.searchSales(keyword);
    }
}
