package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.CategoryDao;
import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.model.Category;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.model.DrugCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<DrugCategory> getDrugCategoryList() throws Exception {
        List<DrugCategory> drugCategoryList = new ArrayList<>();
        String sql = "SELECT DG.ID,D.NAME DNAME, D.BARKOD DBARKOD,C.NAME CNAME, DAI.PRODUCING_COUNTRY,DAI.EXP_DATE  FROM DRUG_CATG DG\n" +
"INNER JOIN DRUG_ADD_INFO DAI\n" +
"ON DG.DRUG_ADD_ID = DAI.ID\n" +
"INNER JOIN CATEGORY C\n" +
"ON DG.CATEGORY_ID = C.ID\n" +
"INNER JOIN DRUG D\n" +
"ON DAI.DRUG_ID = D.ID\n" +
"WHERE DG.ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DrugCategory drugCategory = new DrugCategory();
                Drug drug = new Drug();
                Category category = new Category();
                DrugAddInfo  drugAddInfo = new DrugAddInfo();
                drugCategory.setId(rs.getLong("ID"));
                drug.setName(rs.getString("DNAME"));
                drug.setBarkod(rs.getString("DBARKOD"));
                category.setName(rs.getString("CNAME"));
                drugAddInfo.setDrug(drug);
                drugAddInfo.setProductCountry(rs.getString("PRODUCING_COUNTRY")); 
                drugAddInfo.setExpDate(rs.getDate("EXP_DATE"));
                drugCategory.setCategory(category);
                drugCategoryList.add(drugCategory);

            }
        }
        return drugCategoryList;
    }

    @Override
    public void addDrugCategory(DrugCategory drugCategory) throws Exception {

        String sql = "INSERT INTO DRUG_CATG(ID,DRUG_ADD_ID,CATEGORY_ID)\n" +
         "VALUES(DRUG_CATG.NEXTVAL,?,?)";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setLong(1, drugCategory.getDrugAdd().getId());
            ps.setLong(2,drugCategory.getCategory().getId());
            ps.execute();
            c.commit();

        }

    }

    @Override
    public void updateDrugCategory(DrugCategory drugCategory) throws Exception {

        String sql = "UPDATE DRUG_CATG \n" +
                " SET DRUG_ADD_ID = ?, CATEGORY_ID = ?\n" +
                " WHERE ID = ?";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,drugCategory.getDrugAdd().getId());
            ps.setLong(2,drugCategory.getCategory().getId());
            ps.setLong(3,drugCategory.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteDrugCategory(Long drugCategoryId) throws Exception {

        String sql = "UPDATE DRUG_CATG SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, drugCategoryId
            );
            ps.execute();
            c.commit();

        }

    }

    @Override
    public List<DrugCategory> searchDrugCategory(String keyword) throws Exception {
        List<DrugCategory> drugCategoryList = new ArrayList<>();
        String sql = "SELECT DG.ID,D.NAME DNAME, D.BARKOD DBARKOD,C.NAME CNAME, DAI.PRODUCING_COUNTRY DAIP, DAI.EXP_DATE FROM DRUG_CATG DG\n" +
"INNER JOIN DRUG_ADD_INFO DAI\n" +
"ON DG.DRUG_ADD_ID = DAI.ID\n" +
"INNER JOIN CATEGORY C\n" +
"ON DG.CATEGORY_ID = C.ID\n" +
"INNER JOIN DRUG D\n" +
"ON DAI.DRUG_ID = D.ID\n" +
"WHERE DG.ACTIVE = 1\n" +
"AND (LOWER(D.NAME) LIKE LOWER(?) OR LOWER(D.BARKOD) LIKE LOWER(?)\n" +
"OR LOWER(C.NAME) LIKE LOWER(?)OR LOWER(DAI.PRODUCING_COUNTRY) LIKE LOWER(?)OR LOWER(DAI.EXP_DATE) LIKE LOWER(?))";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, "%"+keyword+"%");
            ps.setString(2, "%"+keyword+"%");
            ps.setString(3, "%"+keyword+"%");
            ps.setString(4, "%"+keyword+"%");
            ps.setString(5, "%"+keyword+"%"); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 DrugCategory drugCategory = new DrugCategory();
                Drug drug = new Drug();
                Category category = new Category();
                DrugAddInfo  drugAddInfo = new DrugAddInfo();
                drugCategory.setId(rs.getLong("ID"));
                drug.setName(rs.getString("DNAME"));
                drug.setBarkod(rs.getString("DBARKOD"));
                category.setName(rs.getString("CNAME"));
                drugAddInfo.setDrug(drug);
                drugAddInfo.setProductCountry(rs.getString("DAIP")); 
                drugAddInfo.setExpDate(rs.getDate("EXP_DATE"));
                drugCategory.setCategory(category);
                drugCategoryList.add(drugCategory);

            }
        }
        return drugCategoryList;
    }
}
