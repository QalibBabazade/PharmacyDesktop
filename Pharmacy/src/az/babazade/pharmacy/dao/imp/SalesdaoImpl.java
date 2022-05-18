package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.SalesDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.model.Employee;
import az.babazade.pharmacy.model.Sales;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalesdaoImpl  implements SalesDao {


    @Override
    public List<Sales> getSalesList() throws Exception {
        List<Sales>  salesList = new ArrayList<>();
        String sql = "SELECT S.ID,S.AMOUNT ,S.TYPE , S.DATA_DATE, S.BOX_NUMBER ,D.NAME DNAME,D.BARKOD DBARKOD,\n" +
"W.NAME WNAME,W.SURNAME WSURNAME FROM SALES S\n" +
"INNER JOIN DRUG_ADD_INFO DAI\n" +
"ON S.DRUG_ADD_ID = DAI.ID\n" +
"INNER JOIN DRUG D\n" +
"ON DAI.DRUG_ID = D.ID\n" +
"INNER JOIN WORKER W\n" +
"ON S.WORKER_ID = W.ID\n" +
"WHERE S.ACTIVE = 1";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Sales sales = new Sales();
                Drug drug = new Drug();
                DrugAddInfo drugAddInfo = new DrugAddInfo();
                Employee employee = new Employee();
                sales.setId(rs.getLong("ID"));
                sales.setAmount(rs.getDouble("AMOUNT"));
                sales.setDataDate(rs.getDate("DATA_DATE"));
                sales.setBoxNumber(rs.getInt("BOX_NUMBER"));
                sales.setType(rs.getString("TYPE"));
                drug.setName(rs.getString("DNAME"));
                drug.setBarkod(rs.getString("DBARKOD"));
                drugAddInfo.setDrug(drug);
                employee.setName(rs.getString("WNAME"));
                employee.setSurname(rs.getString("WSURNAME"));
                sales.setDrugAdd(drugAddInfo);
                sales.setEmployee(employee);
                salesList.add(sales);

            }

        }


        return salesList;
    }

    @Override
    public void addSales(Sales sales) throws Exception {

        String sql = "INSERT INTO SALES(ID,DRUG_ADD_ID,WORKER_ID,AMOUNT,BOX_NUMBER)\n" +
                "VALUES(SALES_SEQ.NEXTVAL,?,?,?,?)";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){


            ps.setLong(1,sales.getDrugAdd().getId());
            ps.setLong(2,sales.getEmployee().getId());
            ps.setDouble(3,sales.getAmount());
            ps.setInt(4, sales.getBoxNumber());
            ps.execute();
            c.commit();

        }

    }

    @Override
    public void updateSales(Sales sales) throws Exception {

        String sql = "UPDATE SALES S \n" +
                "SET S.DRUG_ADD_ID = ? , S.WORKER_ID = ?, AMOUNT = ?,BOX_NUMBER = ?\n" +
                "WHERE S.ID = ?";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setLong(1,sales.getDrugAdd().getId());
            ps.setLong(2,sales.getEmployee().getId());
            ps.setDouble(3,sales.getAmount());
            ps.setDouble(4,sales.getBoxNumber());
            ps.setLong(5,sales.getId());
            ps.execute();
            c.commit();


        }

    }

    @Override
    public void deleteSales(Long id) throws Exception {

        String sql = "UPDATE SALES SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,id);
            ps.execute();
            c.commit();

        }

    }

    @Override
    public List<Sales> searchSales(String keyword) throws Exception {
        return null;
    }
}
