/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.EmployeeLog;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public interface EmployeeLogDao {

    List<EmployeeLog> getEmployeeLogList() throws Exception;

    void addEmployeeLog(EmployeeLog employeeLog) throws Exception;

    void updateEmployeeLog(EmployeeLog employeeLog) throws Exception;

    void deleteEmployeeLog(Long employeLogId) throws Exception;

    List<EmployeeLog> searchEmployeeLog(String keyword) throws Exception;
}
