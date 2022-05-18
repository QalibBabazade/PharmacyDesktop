/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.ShelfDao;
import az.babazade.pharmacy.model.Shelf;
import az.babazade.pharmacy.service.ShelfService;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class ShelfServiceImpl implements ShelfService{
    
    private ShelfDao shelfDao;

    public ShelfServiceImpl(ShelfDao shelfDao) {
        this.shelfDao = shelfDao;
    }
    
    

    @Override
    public List<Shelf> getShelfList() throws Exception {
        return shelfDao.getShelfList();
    }

    @Override
    public void addShelf(Shelf shelf) throws Exception {
        shelfDao.addShelf(shelf);
    }

    @Override
    public void updateShelf(Shelf shelf) throws Exception {
        shelfDao.updateShelf(shelf);
    }

    @Override
    public void deleteShelf(Long shelfId) throws Exception {
        shelfDao.deleteShelf(shelfId);
    }

    @Override
    public List<Shelf> searchShelfList(String keyword) throws Exception {
        return shelfDao.searchShelfList(keyword);
    }
    
}
