package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.DrugCategory;

import java.util.List;

public interface CategoryService {

    List<DrugCategory> getDrugCategoryList() throws Exception;

    void addDrugCategory(DrugCategory drugCategory) throws Exception;

    void updateDrugCategory(DrugCategory drugCategory) throws Exception;

    void deleteDrugCategory(Long drugCategoryId) throws Exception;

    List<DrugCategory> searchDrugCategory(String keyword) throws Exception;
}
