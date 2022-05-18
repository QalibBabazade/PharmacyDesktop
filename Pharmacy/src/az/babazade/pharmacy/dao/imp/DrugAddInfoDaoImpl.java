/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.dao.imp;


import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.DrugAddInfoDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class DrugAddInfoDaoImpl implements DrugAddInfoDao {

    @Override
    public List<DrugAddInfo> getDrugAddList() throws Exception {
        List<DrugAddInfo> drugAddInfoList = new ArrayList<>();
        String sql = "SELECT DAI.ID, DAI.PRODUCING_COUNTRY,DAI.EXP_DATE , DAI.COMPOSITION, D.NAME DNAME,D.BARKOD DBARKOD FROM DRUG_ADD_INFO DAI\n"
                + "INNER JOIN DRUG D\n"
                + "ON DAI.DRUG_ID = D.ID\n"
                + "WHERE DAI.ACTIVE = 1";
        
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            DrugAddInfo drugAddInfo = new DrugAddInfo();
            Drug drug = new Drug();
            drugAddInfo.setId(rs.getLong("ID"));
            drugAddInfo.setProductCountry(rs.getString("PRODUCING_COUNTRY"));
            drugAddInfo.setExpDate(rs.getDate("EXP_DATE"));
            drugAddInfo.setComposition(rs.getString("COMPOSITION"));
            drug.setName(rs.getString("DNAME"));
            drug.setBarkod(rs.getString("DBARKOD"));
            drugAddInfo.setDrug(drug);
            drugAddInfoList.add(drugAddInfo);
        }
       
        return drugAddInfoList;
    }

    @Override
    public void addDrugAdd(DrugAddInfo drugAddInfo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDrugAdd(DrugAddInfo drugAddInfo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDrugAdd(Long drugAddId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DrugAddInfo> searchDrugAdd(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
