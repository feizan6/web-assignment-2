package assignment2;

import assignment2.model.Item;

/**
 * Created by Fayzan on 14/04/2017.
 */

public interface ItemService {



    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Integer id);

}
