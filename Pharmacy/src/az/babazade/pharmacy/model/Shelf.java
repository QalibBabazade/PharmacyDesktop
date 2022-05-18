package az.babazade.pharmacy.model;

public class Shelf extends PharmacyModel{


    private String name;
    private DrugAddInfo drugAdd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrugAddInfo getDrugAdd() {
        return drugAdd;
    }

    public void setDrugAdd(DrugAddInfo drugAdd) {
        this.drugAdd = drugAdd;
    }

   
}
