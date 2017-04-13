package assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private ItemRepository itemRepository;

    @Autowired
    public DatabaseSeeder(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        List<Item> items = new ArrayList<>();

        items.add(new Item("Coffee", 1, 1.99));
        items.add(new Item("Cookies", 2, 0.99));

        itemRepository.save(items);

    }
}
