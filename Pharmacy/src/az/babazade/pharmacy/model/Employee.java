package az.babazade.pharmacy.model;

import java.util.Date;

public class Employee extends PharmacyModel {

    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String phone;
    private EmployeeAddInfo employeeAddInfo;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

  

    public EmployeeAddInfo getEmployeeAddInfo() {
        return employeeAddInfo;
    }

    public void setEmployeeAddInfo(EmployeeAddInfo employeeAddInfo) {
        this.employeeAddInfo = employeeAddInfo;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
