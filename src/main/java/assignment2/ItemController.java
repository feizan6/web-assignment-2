package assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fayzan on 13/04/2017.
 */

//@RestController
//@RequestMapping(value = "/items")
//public class ItemController {
//
//    private ItemRepository itemRepository;
//
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public List<Item> getAll() {
//        return itemRepository.findAll();
//    }
//
//    @RequestMapping(value = "/cheapest/{price}", method = RequestMethod.GET)
//    public List<Item> getItemsBelow(@PathVariable double price) {
//        return itemRepository.findByItemPriceLessThan(price);
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public List<Item> create(@RequestBody Item item) {
//        itemRepository.save(item);
//        return itemRepository.findAll();
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    public List<Item> delete(@PathVariable long id) {
//        itemRepository.delete(id);
//        return itemRepository.findAll();
//
//    }
//}


@RestController
@RequestMapping(value = "/items")

public class ItemController {

    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/cheapest/{price}", method = RequestMethod.GET)
    public List<Item> getCheapest(@PathVariable double price){
        return itemRepository.findByItemPriceLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Item> create(@RequestBody Item item){
        itemRepository.save(item);

        return itemRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Item> remove(@PathVariable long id){
        itemRepository.delete(id);

        return itemRepository.findAll();
    }
}
