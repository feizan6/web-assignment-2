package assignment2.controllers;

//import assignment2.search.ItemSearch;

import assignment2.ItemService;
import assignment2.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

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
        model.addAttribute("item", itemService.getItemById(id));
        return "layout/itemshow";
    }

    @RequestMapping("item/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "layout/newedititem";
    }

    @RequestMapping("items/new")
    public String newProduct(@Valid Model model) {

        model.addAttribute("item", new Item());
        return "layout/newedititem";
    }


    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String saveProduct(@Valid Item item, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "layout/newedititem";
        }

        itemService.saveItem(item);
        return "redirect:/item/" + item.getId();
    }


    @RequestMapping("item/delete/{id}")
    public String delete(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, HttpServletRequest request) {
        model.addAttribute("item", new Item());
        return "layout/search";
    }

    @RequestMapping(value = "/contacts/list", method = RequestMethod.GET)
    public String processFindForm(Item item, BindingResult result, Model model, HttpSession session) {
        Collection<Item> results = null;

        if (StringUtils.isEmpty(item.getItemName())) {
            // allow parameterless GET request to return all contacts
            return "redirect:/items/";
        } else {
            results = this.itemService.findByItemName(item.getItemName());
        }

        if (results.size() < 1) {
            // no contacts found
            result.rejectValue("itemName", "itemName.search.notfound", new Object[] { item.getItemName() },
                    "not found");
            return "layout/search";
        }

        session.setAttribute("searchItemName", item.getItemName());

        if (results.size() > 1) {
            // multiple contacts found
            model.addAttribute("items", results);
            return "layout/search";
        } else {
            // 1 contact found
            item = results.iterator().next();
            return "redirect:/item/" + item.getId();
        }
    }


}