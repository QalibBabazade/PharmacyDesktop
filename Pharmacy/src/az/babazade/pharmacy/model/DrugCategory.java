package az.babazade.pharmacy.model;

public class DrugCategory extends PharmacyModel{

    private DrugAddInfo drugAdd;
    private Category category;

    public DrugAddInfo getDrugAdd() {
        return drugAdd;
    }

    public void setDrugAdd(DrugAddInfo drugAdd) {
        this.drugAdd = drugAdd;
    }

 
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
