package assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableOAuth2Sso
@SpringBootApplication
public class ShoppingListManagerApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListManagerApplication.class, args);
    }
}
