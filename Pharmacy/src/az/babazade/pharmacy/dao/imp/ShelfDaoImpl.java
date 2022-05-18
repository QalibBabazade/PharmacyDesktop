package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.ShelfDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.model.Shelf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShelfDaoImpl implements ShelfDao{

    @Override
    public List<Shelf> getShelfList() throws Exception {
        List<Shelf> shelfList = new ArrayList<>();
        String sql = "SELECT S.ID,S.NAME,S.DATA_DATE,D.NAME DNAME,D.BARKOD DBARKOD,DAI.EXP_DATE DEXT FROM SHELF S\n" +
"INNER JOIN DRUG_ADD_INFO DAI\n" +
"ON S.DRUG_ADD_ID = DAI.ID\n" +
"INNER JOIN DRUG D\n" +
"ON DAI.DRUG_ID = D.ID\n" +
"WHERE S.ACTIVE = 1";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Shelf shelf = new Shelf();
                DrugAddInfo drugAddInfo = new DrugAddInfo();
                shelf.setId(rs.getLong("ID"));
                shelf.setName(rs.getString("NAME"));
                shelf.setDataDate(rs.getDate("DATA_DATE"));
                Drug drug = new Drug();
                drug.setName(rs.getString("DNAME"));
                drug.setBarkod(rs.getString("DBARKOD"));
                drugAddInfo.setDrug(drug);
                drugAddInfo.setExpDate(rs.getDate("DEXT"));
                shelf.setDrugAdd(drugAddInfo);
                shelfList.add(shelf);
                
            }   
        }
        return shelfList;
    }

    @Override
    public void addShelf(Shelf shelf) throws Exception {
         String sql = "INSERT INTO SHELF(ID,NAME,DRUG_ADD_ID)\n" +
         "VALUES(SHELF_SEQ.NEXTVAL,?,?)";
         try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
           ps.setString(1, shelf.getName());
           ps.setLong(2, shelf.getDrugAdd().getId());
           ps.execute();
           c.commit();
             
         }
    }

    @Override
    public void updateShelf(Shelf shelf) throws Exception {
        String sql = "UPDATE SHELF S SET NAME = ?,DRUG_ADD_ID = ?\n" +
        "WHERE S.ID = ?";
         try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, shelf.getName());
            ps.setLong(2, shelf.getDrugAdd().getId());
            ps.setLong(3, shelf.getId());
            ps.execute();
            c.commit(); 
             
         }
    }

    @Override
    public void deleteShelf(Long shelfId) throws Exception {
         String sql = "UPDATE SHELF S SET ACTIVE = 0\n" +
         "WHERE S.ID = ?";
         try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
             ps.setLong(1, shelfId);
             ps.execute();
             c.commit();
             
         }
    }

    @Override
    public List<Shelf> searchShelfList(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
