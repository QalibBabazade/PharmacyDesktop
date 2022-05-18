/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.Position;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public interface PositionService {
     List<Position> getPositionList() throws Exception;

    void addPosition(Position position) throws Exception;

    void updatePosition(Position position) throws Exception;

    void deleteposition(Long positionId) throws Exception;

    List<Position> searchPosition(String keyword) throws Exception;
    
}
