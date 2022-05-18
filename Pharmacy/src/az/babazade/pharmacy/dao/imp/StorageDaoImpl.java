package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.StorageDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.model.Storage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao{

    @Override
    public List<Storage> getStorageList() throws Exception {
         List<Storage> storageList = new ArrayList<>();
         String sql = "SELECT S.ID,D.NAME DNAME,D.BARKOD DBARKOD, DAI.EXP_DATE DEXT , S.BOX_NUMBER ,\n" +
"S.PRICE FROM STORAGE S\n" +
"INNER JOIN DRUG_ADD_INFO DAI\n" +
"ON S.DRUG_ADD_ID = DAI.ID\n" +
"INNER JOIN DRUG D\n" +
"ON DAI.DRUG_ID = D.ID\n" +
"WHERE S.ACTIVE = 1";
         try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()){
             while(rs.next()){
                 Storage storage = new Storage();
                 Drug drug = new Drug();
                 DrugAddInfo drugAddInfo = new DrugAddInfo();
                 storage.setId(rs.getLong("ID"));
                 drug.setName(rs.getString("DNAME"));
                 drug.setBarkod(rs.getString("DBARKOD"));
                 drugAddInfo.setDrug(drug);
                 drugAddInfo.setExpDate(rs.getDate("DEXT"));
                 storage.setDrugAdd(drugAddInfo);
                 storage.setBoxNumber(rs.getInt("BOX_NUMBER"));
                 storage.setPrice(rs.getDouble("PRICE"));
                 storageList.add(storage);
                 
             }
             
         }
         return storageList;
    }

    @Override
    public void addStorage(Storage storage) throws Exception {
        String sql = "INSERT INTO STORAGE(ID,DRUG_ADD_ID,PRICE,BOX_NUMBER)\n" +
                " VALUES (STORAGE_SEQ.NEXTVAL,?,?,?)";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setLong(1,storage.getDrugAdd().getId());
            ps.setDouble(2,storage.getPrice());
            ps.setDouble(3,storage.getBoxNumber());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void updateStorage(Storage storage) throws Exception {
         String sql = "UPDATE STORAGE \n" +
                " SET DRUG_ADD_ID = ?, PRICE = ?, BOX_NUMBER = ?\n" +
                " WHERE ID = ?";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,storage.getDrugAdd().getId());
            ps.setDouble(2,storage.getPrice());
            ps.setDouble(3,storage.getBoxNumber());
            ps.setLong(4,storage.getId());
            ps.execute();
            c.commit();

        }   
    }

    @Override
    public void deleteStock(Long storageId) throws Exception {
         String sql = "UPDATE STORAGE SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, storageId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public List<Storage> searchStorage(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
