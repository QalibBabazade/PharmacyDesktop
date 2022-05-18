/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.StorageDao;
import az.babazade.pharmacy.model.Storage;
import az.babazade.pharmacy.service.StorageService;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class StorageServiceImpl implements StorageService{
    
    
    private StorageDao storageDao;

    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }
    
    

    @Override
    public List<Storage> getStorageList() throws Exception {
         return storageDao.getStorageList();
    }

    @Override
    public void addStorage(Storage storage) throws Exception {
         storageDao.addStorage(storage);
    }

    @Override
    public void updateStorage(Storage storage) throws Exception {
         storageDao.updateStorage(storage);
    }

    @Override
    public void deleteStock(Long storageId) throws Exception {
        storageDao.deleteStock(storageId);
    }

    @Override
    public List<Storage> searchStorage(String keyword) throws Exception {
         return storageDao.searchStorage(keyword);
    }
    
}
