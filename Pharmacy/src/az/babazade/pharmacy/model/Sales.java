package az.babazade.pharmacy.model;

public class Sales extends PharmacyModel{

    private DrugAddInfo drugAdd;
    private Employee employee;
    private Double amount;
    private Integer boxNumber;
    private String type;

    public DrugAddInfo getDrugAdd() {
        return drugAdd;
    }

    public void setDrugAdd(DrugAddInfo drugAdd) {
        this.drugAdd = drugAdd;
    }

  

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
