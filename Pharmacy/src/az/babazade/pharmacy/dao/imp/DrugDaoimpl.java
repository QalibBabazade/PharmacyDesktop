package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.DrugDao;
import az.babazade.pharmacy.model.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DrugDaoimpl implements DrugDao {

    @Override
    public List<Drug> getDrugList() throws Exception {
        List<Drug> drugList = new ArrayList<>();
        String sql ="SELECT ID,NAME,BARKOD FROM DRUG\n" +
"WHERE ACTIVE = 1";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Drug drug = new Drug();
                drug.setId(rs.getLong("ID"));
                drug.setName(rs.getString("NAME"));
                drug.setBarkod(rs.getString("BARKOD"));
                drugList.add(drug);

            }
        }
        return drugList;
    }

    @Override
    public void addDrug(Drug drug) throws Exception {
        String sql = "INSERT INTO DRUG(ID,NAME,BARKOD)\n" +
"VALUES(DRUG_SEQ.NEXTVAL,?,?)";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
           ps.setString(1,drug.getName());
           ps.setString(2,drug.getBarkod());
           ps.execute();
           c.commit();

        }
    }

    @Override
    public void updateDrug(Drug drug) throws Exception {

        String sql = "UPDATE DRUG SET NAME = ?,BARKOD = ?\n" +
                "WHERE ID = ?";

        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,drug.getName());
            ps.setString(2,drug.getBarkod());
            ps.setLong(5,drug.getId());
            ps.execute();
            c.commit();

        }

    }

    @Override
    public void deleteDrug(Long id) throws Exception {

        String sql = "UPDATE DRUG SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,id);
            ps.execute();
            c.commit();

        }

    }

    @Override
    public List<Drug> searchDrugList(String keyword) throws Exception {
        List<Drug> drugList = new ArrayList<>();
        String sql ="SELECT D.ID,D.NAME,D.BARKOD FROM DRUG D\n" +
"WHERE ACTIVE = 1 AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(BARKOD) LIKE LOWER(?))";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, "%"+keyword+"%");
            ps.setString(2, "%"+keyword+"%");; 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Drug drug = new Drug();
                drug.setId(rs.getLong("ID"));
                drug.setName(rs.getString("NAME"));
                drug.setBarkod(rs.getString("BARKOD"));
                drugList.add(drug);

            }
        }
        return drugList;
    }
}
