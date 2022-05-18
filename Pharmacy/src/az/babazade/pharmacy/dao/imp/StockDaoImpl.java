package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.StockDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {

    @Override
    public List<Stock> getStockList() throws Exception {

        List<Stock> stockList = new ArrayList<>();
        String sql = "SELECT S.ID,D.NAME DNAME,D.BARKOD DBARKOD, D.EXP_DATE DEXT , S.BOX_NUMBER ," +
                "S.PRICE FROM STOCK S\n" +
                "INNER JOIN DRUG D\n" +
                "ON S.DRUG_ID = D.ID\n" +
                "WHERE S.ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             while(rs.next()) {
                 Stock stock = new Stock();
                 Drug drug = new Drug();
                 DrugAddInfo drugAddInfo = new DrugAddInfo();
                 stock.setId(rs.getLong("ID"));
                 drug.setName(rs.getString("DNAME"));
                 drug.setBarkod(rs.getString("DBARKOD"));
                 drugAddInfo.setDrug(drug);
                 drugAddInfo.setExpDate(rs.getDate("DEXT"));
                 stock.setDrugAdd(drugAddInfo);
                 stock.setBoxNumber(rs.getInt("BOX_NUMBER"));
                 stock.setPrice(rs.getDouble("PRICE"));
                 stockList.add(stock);

             }


        }
        return stockList;
    }

    @Override
    public void addStock(Stock stock) throws Exception {

        String sql = "INSERT INTO STOCK(ID,DRUG_ADD_ID,PRICE,BOX_NUMBER)\n" +
                " VALUES (STOCK_SEQ.NEXTVAL,?,?,?)";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setLong(1,stock.getDrugAdd().getId());
            ps.setDouble(2,stock.getPrice());
            ps.setDouble(3,stock.getBoxNumber());
            ps.execute();
            c.commit();

        }

    }

    @Override
    public void updateStock(Stock stock) throws Exception {

        String sql = "UPDATE STOCK \n" +
                " SET DRUG_ID = ?, PRICE = ?, BOX_NUMBER = ?\n" +
                " WHERE ID = ?";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,stock.getDrugAdd().getId());
            ps.setDouble(2,stock.getPrice());
            ps.setDouble(3,stock.getBoxNumber());
            ps.setLong(4,stock.getId());
            ps.execute();
            c.commit();

        }

    }

    @Override
    public void deleteStock(Long stockId) throws Exception {

        String sql = "UPDATE STOCK SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, stockId);
            ps.execute();
            c.commit();

        }

    }

    @Override
    public List<Stock> searchStock(String keyword) throws Exception {
        return null;
    }

}
