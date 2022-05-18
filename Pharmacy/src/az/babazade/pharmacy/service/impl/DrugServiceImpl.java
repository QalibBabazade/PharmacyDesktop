package az.babazade.pharmacy.service.impl;

import az.babazade.pharmacy.dao.DrugDao;
import az.babazade.pharmacy.model.Drug;
import az.babazade.pharmacy.service.DrugService;

import java.util.List;

public class DrugServiceImpl implements DrugService {

    private DrugDao drugDao;

    public DrugServiceImpl(DrugDao drugDao) {

        this.drugDao = drugDao;
    }

    @Override
    public List<Drug> getDrugList() throws Exception {
        return drugDao.getDrugList();
    }

    @Override
    public void addDrug(Drug drug) throws Exception {
        drugDao.addDrug(drug);

    }

    @Override
    public void updateDrug(Drug drug) throws Exception {

        drugDao.updateDrug(drug);

    }

    @Override
    public void deleteDrug(Long id) throws Exception {

        drugDao.deleteDrug(id);

    }

    @Override
    public List<Drug> searchDrugList(String keyword) throws Exception {
        return drugDao.searchDrugList(keyword);
    }
}
