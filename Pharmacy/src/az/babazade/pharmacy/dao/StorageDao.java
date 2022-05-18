package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.Storage;
import java.util.List;

public interface StorageDao {
    
    List<Storage> getStorageList() throws Exception;

    void addStorage(Storage storage) throws Exception;

    void updateStorage(Storage storage) throws Exception;

    void deleteStock(Long storageId) throws Exception;

    List<Storage> searchStorage(String keyword) throws Exception;
}
