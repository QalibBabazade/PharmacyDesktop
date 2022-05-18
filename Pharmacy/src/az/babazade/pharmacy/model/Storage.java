package az.babazade.pharmacy.model;

public class Storage extends PharmacyModel{

    private DrugAddInfo drugAdd;
    private Integer boxNumber;
    private Double price;

    public DrugAddInfo getDrugAdd() {
        return drugAdd;
    }

    public void setDrugAdd(DrugAddInfo drugAdd) {
        this.drugAdd = drugAdd;
    }

  

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
