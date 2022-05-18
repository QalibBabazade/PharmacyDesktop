/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.DrugAddInfoDao;
import az.babazade.pharmacy.model.DrugAddInfo;
import az.babazade.pharmacy.service.DrugAddInfoService;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class DrugAddInfoServiceImpl implements  DrugAddInfoService{
    
    private DrugAddInfoDao addInfoDao;

    public DrugAddInfoServiceImpl(DrugAddInfoDao addInfoDao) {
        this.addInfoDao = addInfoDao;
    }
    
    

    @Override
    public List<DrugAddInfo> getDrugAddList() throws Exception {
         return addInfoDao.getDrugAddList();
    }

    @Override
    public void addDrugAdd(DrugAddInfo drugAddInfo) throws Exception {
        addInfoDao.addDrugAdd(drugAddInfo);
    }

    @Override
    public void updateDrugAdd(DrugAddInfo drugAddInfo) throws Exception {
       addInfoDao.updateDrugAdd(drugAddInfo);
    }

    @Override
    public void deleteDrugAdd(Long drugAddId) throws Exception {
        addInfoDao.deleteDrugAdd(drugAddId);
    }

    @Override
    public List<DrugAddInfo> searchDrugAdd(String keyword) throws Exception {
      return addInfoDao.searchDrugAdd(keyword);
    }
    
    
}
