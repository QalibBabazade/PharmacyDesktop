/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.PositionDao;
import az.babazade.pharmacy.model.Position;
import az.babazade.pharmacy.service.PositionService;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class PositionServiceImpl implements PositionService{ 
    
    
    private PositionDao positionDao;

    public PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
    
    

    @Override
    public List<Position> getPositionList() throws Exception {
         return positionDao.getPositionList();
    }

    @Override
    public void addPosition(Position position) throws Exception {
         positionDao.addPosition(position);
    }

    @Override
    public void updatePosition(Position position) throws Exception {
         positionDao.updatePosition(position);
    }

    @Override
    public void deleteposition(Long positionId) throws Exception {
         positionDao.deleteposition(positionId);
    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        return positionDao.searchPosition(keyword);
        
    }
    
    
    
}
