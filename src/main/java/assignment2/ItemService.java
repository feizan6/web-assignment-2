package assignment2;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Fayzan on 14/04/2017.
 */

public interface ItemService {



    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Integer id);

}
