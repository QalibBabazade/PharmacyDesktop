package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    void updateEmployee(Employee employee) throws Exception;

    void deleteEmploye(Long id) throws Exception;

    List<Employee> searchEmployeList(String keyword) throws Exception;
}
