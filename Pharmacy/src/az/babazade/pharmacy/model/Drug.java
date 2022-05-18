package az.babazade.pharmacy.model;


public class Drug extends PharmacyModel{

    private String name;
    private String barkod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }


}
