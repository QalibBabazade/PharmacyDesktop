package az.babazade.pharmacy.dao;

import az.babazade.pharmacy.model.Shelf;
import java.util.List;

public interface ShelfDao {

    List<Shelf> getShelfList() throws Exception;

    void addShelf(Shelf shelf) throws Exception;

    void updateShelf(Shelf shelf) throws Exception;

    void deleteShelf(Long shelfId) throws Exception;

    List<Shelf> searchShelfList(String keyword) throws Exception;

}
