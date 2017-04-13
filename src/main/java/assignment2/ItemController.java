package assignment2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fayzan on 13/04/2017.
 */

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/cheapest/{price}", method = RequestMethod.GET)
    public List<Item> getItemsBelow(@PathVariable double price) {
        return itemRepository.findByItemLessThan(price);

    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public List<Item> create(@RequestBody Item item) {
        itemRepository.save(item);

        return itemRepository.findAll();
    }
}
