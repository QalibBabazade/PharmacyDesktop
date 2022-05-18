package az.babazade.pharmacy.dao.imp;

import az.babazade.pharmacy.model.EmployeeAddInfo;
import az.babazade.pharmacy.model.Employee;
import az.babazade.pharmacy.model.Gender;
import az.babazade.pharmacy.dao.DbHelper;
import az.babazade.pharmacy.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> getEmployeList() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql ="SELECT W.ID,W.NAME,W.SURNAME,W.DOB,W.ADDRESS,W.PHONE,\n" +
"W_A.UNIVERSITY UNI,W_A.FACULTY FAC,W_A.WORK_EXPERIENCE WORE, W_A.SALARY SALARY,\n" +
"GR.VALUE GENDER FROM WORKER W\n" +
"INNER JOIN WORKER_ADD_INFO W_A\n" +
"ON W.WORKER_ADD_ID = W_A.ID\n" +
"INNER JOIN GENDER GR\n" +
"ON W.GENDER_ID = GR.ID\n" +
"WHERE W.ACTIVE = 1";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Employee employee = new Employee();
                EmployeeAddInfo employeeAddInfo = new EmployeeAddInfo();
                Gender gender = new Gender();
                employee.setId(rs.getLong("ID"));
                employee.setName(rs.getString("NAME"));
                employee.setSurname(rs.getString("SURNAME"));
                employee.setDob(rs.getDate("DOB"));
                employee.setAddress(rs.getString("ADDRESS"));
                employee.setPhone(rs.getString("PHONE"));
                employeeAddInfo.setUniversity(rs.getString("UNI"));
                employeeAddInfo.setFaculty(rs.getString("FAC"));
                employeeAddInfo.setWork_experience(rs.getInt("WORE"));
                employeeAddInfo.setSalary(rs.getInt("SALARY"));
                employee.setEmployeeAddInfo(employeeAddInfo);
                gender.setValue(rs.getString("GENDER"));
                employee.setGender(gender);
                employeeList.add(employee);

            }
        }

        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        String sql = "INSERT INTO WORKER(ID,NAME,SURNAME,DOB,ADDRESS,PHONE," +
                     "WORKER_ADD_ID,GENDER_ID)\n" +
                     "VALUES(WORKER_SEQ.NEXTVAL,?,?,?,?,?,?,?)" ;
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,employee.getName());
            ps.setString(2,employee.getSurname());
            ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
            ps.setString(4,employee.getAddress());
            ps.setString(5,employee.getPhone());
            ps.setLong(6,employee.getEmployeeAddInfo().getId());
            ps.setLong(7,employee.getGender().getId());
            ps.execute();
            c.commit();


        }
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
         String sql = "UPDATE WORKER SET NAME = ?,SURNAME = ?,DOB = ?,ADDRESS = ?,PHONE = ?,WORKER_ADD_ID = ?,GENDER_ID = ?\n" +
                 "WHERE ID = ?";
         try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

             ps.setString(1,employee.getName());
             ps.setString(2,employee.getSurname());
             ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
             ps.setString(4,employee.getAddress());
             ps.setString(5,employee.getPhone());
             ps.setLong(6,employee.getEmployeeAddInfo().getId());
             ps.setLong(7,employee.getGender().getId());
             ps.setLong(8,employee.getId());
             ps.execute();
             c.commit();
         }
    }

    @Override
    public void deleteEmploye(Long id) throws Exception {

        String sql = "UPDATE WORKER SET ACTIVE = 0\n" +
                "WHERE ID = ?";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setLong(1,id);
            ps.execute();
            c.commit();
        }

    }

    @Override
    public List<Employee> searchEmployeList(String keyword) throws Exception {
         List<Employee> employeeList = new ArrayList<>();
        String sql ="SELECT W.ID,W.NAME,W.SURNAME,W.DOB,W.ADDRESS,W.PHONE,\n" +
        "W_A.UNIVERSITY UNI,W_A.FACULTY FAC,W_A.WORK_EXPERIENCE WORE, W_A.SALARY SALARY,\n" +
        "GR.VALUE GENDER FROM WORKER W\n" +
        "INNER JOIN WORKER_ADD_INFO W_A\n" +
        "ON W.WORKER_ADD_ID = W_A.ID\n" +
        "INNER JOIN GENDER GR\n" +
        "ON W.GENDER_ID = GR.ID\n" +
        "WHERE W.ACTIVE = 1 AND\n" +
        "LOWER(W.NAME) LIKE LOWER(?) OR LOWER(W.SURNAME) LIKE LOWER(?) OR LOWER(W.DOB) LIKE LOWER(?) OR LOWER(W.ADDRESS) LIKE LOWER(?)\n" +
        " OR LOWER(W_A.UNIVERSITY) LIKE LOWER(?)";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)
            ){
            ps.setString(1, "%"+keyword+"%");
            ps.setString(2, "%"+keyword+"%");
            ps.setString(3, "%"+keyword+"%");
            ps.setString(4, "%"+keyword+"%");
            ps.setString(5, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                EmployeeAddInfo employeeAddInfo = new EmployeeAddInfo();
                Gender gender = new Gender();
                employee.setId(rs.getLong("ID"));
                employee.setName(rs.getString("NAME"));
                employee.setSurname(rs.getString("SURNAME"));
                employee.setDob(rs.getDate("DOB"));
                employee.setAddress(rs.getString("ADDRESS"));
                employee.setPhone(rs.getString("PHONE"));
                employeeAddInfo.setUniversity(rs.getString("UNI"));
                employeeAddInfo.setFaculty(rs.getString("FAC"));
                employeeAddInfo.setWork_experience(rs.getInt("WORE"));
                employeeAddInfo.setSalary(rs.getInt("SALARY"));
                employee.setEmployeeAddInfo(employeeAddInfo);
                gender.setValue(rs.getString("GENDER"));
                employee.setGender(gender);
                employeeList.add(employee);

            }
        }

        return employeeList;
    }
}
