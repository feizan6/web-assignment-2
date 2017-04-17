package assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
