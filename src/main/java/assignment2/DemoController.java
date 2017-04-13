package assignment2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fayzan on 13/04/2017.
 */

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
