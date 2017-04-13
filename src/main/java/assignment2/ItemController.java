package assignment2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
