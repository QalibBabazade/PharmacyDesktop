package az.babazade.pharmacy.model;

public class EmployeeAddInfo extends PharmacyModel{

     private String university;
     private String faculty;
     private Integer work_experience;
     private Integer salary;


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(Integer work_experience) {
        this.work_experience = work_experience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
