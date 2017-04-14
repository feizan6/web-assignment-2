package assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fayzan on 14/04/2017.
 */
@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getProductById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveItem(Item product) {
        return itemRepository.save(product);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}

