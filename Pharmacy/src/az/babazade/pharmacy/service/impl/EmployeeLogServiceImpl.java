/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.EmployeeLogDao;
import az.babazade.pharmacy.model.EmployeeLog;
import az.babazade.pharmacy.service.EmployeeLogService;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class EmployeeLogServiceImpl implements EmployeeLogService {
    
    private EmployeeLogDao employeeLogDao;

    public EmployeeLogServiceImpl(EmployeeLogDao employeeLogDao) {
        this.employeeLogDao = employeeLogDao;
    }
    
    

    @Override
    public List<EmployeeLog> getEmployeeLogList() throws Exception {
        return employeeLogDao.getEmployeeLogList();
    }

    @Override
    public void addEmployeeLog(EmployeeLog employeeLog) throws Exception {
        employeeLogDao.addEmployeeLog(employeeLog);
    }

    @Override
    public void updateEmployeeLog(EmployeeLog employeeLog) throws Exception {
       employeeLogDao.updateEmployeeLog(employeeLog);
    }

    @Override
    public void deleteEmployeeLog(Long employeLogId) throws Exception {
      employeeLogDao.deleteEmployeeLog(employeLogId);
    }

    @Override
    public List<EmployeeLog> searchEmployeeLog(String keyword) throws Exception {
         return employeeLogDao.searchEmployeeLog(keyword);
    }
    
    
    
}
