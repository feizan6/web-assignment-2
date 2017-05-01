package assignment2;

import assignment2.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fayzan on 14/04/2017.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private List<Item> items;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String itemName) {

        List<Item> result = items.stream().filter(x -> x.getItemName().equalsIgnoreCase(itemName)).collect(Collectors.toList());

        return result;

    }

    @Override
    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}

