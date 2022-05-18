package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.Sales;

import java.util.List;

public interface SalesDao {

    List<Sales> getSalesList() throws Exception;

    void addSales(Sales sales) throws Exception;

    void updateSales(Sales sales) throws Exception;

    void deleteSales(Long id) throws Exception;

    List<Sales> searchSales(String keyword) throws Exception;

}
