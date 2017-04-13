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

    private List<Item> items;

    public ItemController() {

        items = new ArrayList<>();

        items.add(new Item("Coffee", 1, 1.99));
        items.add(new Item("Cookies", 2, 0.99));

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Item> getAll() {

        return items;
    }

    @RequestMapping(value = "/cheapest/{price}", method = RequestMethod.GET)
    public List<Item> getItemsBelow(@PathVariable double price) {
        return items.stream().filter(x -> x.getItemPrice() <= price)
                .collect(Collectors.toList());

    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public List<Item> create(@RequestBody Item item) {
        items.add(item);

        return items;
    }
}
