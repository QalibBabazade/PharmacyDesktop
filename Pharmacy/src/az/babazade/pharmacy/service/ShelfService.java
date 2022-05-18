package az.babazade.pharmacy.service;

import az.babazade.pharmacy.model.Shelf;
import java.util.List;

public interface ShelfService {
    
    List<Shelf> getShelfList() throws Exception;

    void addShelf(Shelf shelf) throws Exception;

    void updateShelf(Shelf shelf) throws Exception;

    void deleteShelf(Long shelfId) throws Exception;

    List<Shelf> searchShelfList(String keyword) throws Exception;
}
