package assignment2.controllers;

//import assignment2.search.ItemSearch;

import assignment2.ItemService;
import assignment2.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

//    @Autowired
//    private ItemSearch itemSearch;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", itemService.listAllItems());
        return "layout/items";
    }

    @RequestMapping("item/{id}")
    public String showItem(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "layout/itemshow";
    }

    @RequestMapping("item/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "layout/newedititem";
    }

    @RequestMapping("items/new")
    public String newProduct(Model model) {
        model.addAttribute("item", new Item());
        return "layout/newedititem";
    }

    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String saveProduct(Item item) {
        itemService.saveItem(item);
        return "redirect:/item/" + item.getId();
    }


//    /**
//     * Show search results for the given query.
//     *
//     * @param The search query.
//     */
//    @RequestMapping("/search")
//    public String search(String q, Model model) {
//        List<Item> searchResults = null;
//        try {
//            searchResults = itemSearch.search(q);
//        }
//        catch (Exception ex) {
//            // here you should handle unexpected errors
//            // ...
//            // throw ex;
//        }
//        model.addAttribute("searchResults", searchResults);
//        return "layout/search";
//    }


    @RequestMapping("item/delete/{id}")
    public String delete(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}