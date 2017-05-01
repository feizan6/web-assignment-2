package assignment2.controllers;

import assignment2.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Controller
public class ViewController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.listAllItems());
        return "index";
    }
}
