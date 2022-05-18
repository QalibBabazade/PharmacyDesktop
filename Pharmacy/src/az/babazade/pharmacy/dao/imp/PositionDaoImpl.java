/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.PositionDao;
import az.babazade.pharmacy.model.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class PositionDaoImpl implements PositionDao {

    @Override
    public List<Position> getPositionList() throws Exception {
        List<Position> positionList = new ArrayList<>();
        String sql = "SELECT P.ID, P.NAME FROM POSITION P\n"
                + "WHERE ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Position position = new Position();
                position.setId(rs.getLong("ID"));
                position.setName(rs.getString("NAME"));
                positionList.add(position);
            }
        }

        return positionList;
    }

    @Override
    public void addPosition(Position position) throws Exception {
        String sql = "INSERT INTO POSITION(ID,NAME)\n"
                + "VALUES(POSITION_SEQ.NEXTVAL,?)";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, position.getName());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void updatePosition(Position position) throws Exception {
        String sql = "UPDATE POSITION SET NAME = ?\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, position.getName());
            ps.setLong(2, position.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteposition(Long positionId) throws Exception {
        String sql = "UPDATE POSITION SET ACTIVE = 0\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, positionId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
