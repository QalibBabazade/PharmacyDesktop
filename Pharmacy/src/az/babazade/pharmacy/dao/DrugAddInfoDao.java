/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.DrugAddInfo;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public interface DrugAddInfoDao {

    List<DrugAddInfo> getDrugAddList() throws Exception;

    void addDrugAdd(DrugAddInfo drugAddInfo) throws Exception;

    void updateDrugAdd(DrugAddInfo drugAddInfo) throws Exception;

    void deleteDrugAdd(Long drugAddId) throws Exception;

    List<DrugAddInfo> searchDrugAdd(String keyword) throws Exception;

}
