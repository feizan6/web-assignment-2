package assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fayzan on 13/04/2017.
 */


@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", itemService.listAllItems());
        return "layout/items";
    }

    @RequestMapping("item/{id}")
    public String showItem(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getProductById(id));
        return "itemshow";
    }

    @RequestMapping("item/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getProductById(id));
        return "itemform";
    }

    @RequestMapping("item/new")
    public String newProduct(Model model) {
        model.addAttribute("item", new Item());
        return "itemform";
    }

    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String saveProduct(Item item) {
        itemService.saveItem(item);
        return "redirect:/item/" + item.getId();
    }

    @RequestMapping("item/delete/{id}")
    public String delete(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}