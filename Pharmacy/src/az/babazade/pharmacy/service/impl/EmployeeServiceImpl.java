package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.EmployeeDao;
import az.babazade.pharmacy.model.Employee;
import az.babazade.pharmacy.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployeList() throws Exception {
        return employeeDao.getEmployeList();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
          employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
          employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmploye(Long id) throws Exception {
         employeeDao.deleteEmploye(id);
    }

    @Override
    public List<Employee> searchEmployeList(String keyword) throws Exception {
        return employeeDao.searchEmployeList(keyword);
    }
}
