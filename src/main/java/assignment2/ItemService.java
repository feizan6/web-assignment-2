package assignment2;

import assignment2.model.Item;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fayzan on 14/04/2017.
 */

public interface ItemService {

    List<Item> findByItemName(String itemName);

    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Integer id);

}
