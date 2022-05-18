package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.CategoryDao;
import az.babazade.pharmacy.model.DrugCategory;
import az.babazade.pharmacy.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<DrugCategory> getDrugCategoryList() throws Exception {
        return categoryDao.getDrugCategoryList();
    }

    @Override
    public void addDrugCategory(DrugCategory drugCategory) throws Exception {
       categoryDao.addDrugCategory(drugCategory);
    }

    @Override
    public void updateDrugCategory(DrugCategory drugCategory) throws Exception {
        categoryDao.updateDrugCategory(drugCategory);
    }

    @Override
    public void deleteDrugCategory(Long drugCategoryId) throws Exception {
        categoryDao.deleteDrugCategory(drugCategoryId);
    }

    @Override
    public List<DrugCategory> searchDrugCategory(String keyword) throws Exception {
        return categoryDao.searchDrugCategory(keyword);
    }
}
