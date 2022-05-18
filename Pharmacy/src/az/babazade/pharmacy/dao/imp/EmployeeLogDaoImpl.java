/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.EmployeeLogDao;
import az.babazade.pharmacy.model.Employee;
import az.babazade.pharmacy.model.EmployeeLog;
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
public class EmployeeLogDaoImpl implements EmployeeLogDao {

    @Override
    public List<EmployeeLog> getEmployeeLogList() throws Exception {
        List<EmployeeLog> employeeLogList = new ArrayList<>();
        String sql = "SELECT LPW.ID,LPW.LOGIN,LPW.PASSWORD,W.NAME WNAME,W.SURNAME WSURNAME,P.NAME PNAME FROM LOG_PAS_WORK LPW\n"
                + "INNER JOIN WORKER W\n"
                + "ON LPW.WORKER_ID = W.ID\n"
                + "INNER JOIN POSITION P\n"
                + "ON LPW.STATUS = P.ID\n"
                + "WHERE LPW.ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {

                EmployeeLog employeeLog = new EmployeeLog();
                Employee employee = new Employee();
                Position position = new Position();
                employeeLog.setId(rs.getLong("ID"));
                employeeLog.setLogin(rs.getString("LOGIN"));
                employeeLog.setPassword(rs.getString("PASSWORD"));
                employee.setName(rs.getString("WNAME"));
                employee.setSurname(rs.getString("WSURNAME"));
                employeeLog.setEmployee(employee);
                position.setName(rs.getString("PNAME"));
                employeeLog.setPosition(position);
                employeeLogList.add(employeeLog);

            }

        }
        return employeeLogList;
    }

    @Override
    public void addEmployeeLog(EmployeeLog employeeLog) throws Exception {
        String sql = "INSERT INTO LOG_PAS_WORK(ID,LOGIN,PASSWORD,WORKER_ID,STATUS)\n"
                + "VALUES(SEQ_LOG_WORK.NEXTVAL,?,?,?,?)";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, employeeLog.getLogin());
            ps.setString(2, employeeLog.getPassword());
            ps.setLong(3, employeeLog.getEmployee().getId());
            ps.setLong(4, employeeLog.getPosition().getId());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void updateEmployeeLog(EmployeeLog employeeLog) throws Exception {
        String sql = "UPDATE LOG_PAS_WORK SET LOGIN = ? , PASSWORD = ? , WORKER_ID = ?, STATUS = ?\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, employeeLog.getLogin());
            ps.setString(2, employeeLog.getPassword());
            ps.setLong(3, employeeLog.getEmployee().getId());
            ps.setLong(4, employeeLog.getPosition().getId());
            ps.setLong(5, employeeLog.getId());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void deleteEmployeeLog(Long employeLogId) throws Exception {
          String sql = "UPDATE LOG_PAS_WORK SET ACTIVE = 0\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

           
            ps.setLong(1, employeLogId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public List<EmployeeLog> searchEmployeeLog(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
