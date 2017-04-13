package assignment2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
