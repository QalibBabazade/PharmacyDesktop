package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.Drug;

import java.util.List;

public interface DrugService{

    List<Drug> getDrugList() throws Exception;

    void addDrug(Drug drug) throws Exception;

    void updateDrug(Drug drug) throws Exception;

    void deleteDrug(Long id) throws Exception;

    List<Drug> searchDrugList(String keyword) throws Exception;
}
