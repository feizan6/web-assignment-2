package assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    // Generates initial d
    @Override
    public void run(String... strings) throws Exception {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Apples : Pack of 6", 2.50, 3));
        items.add(new Item("Chicken Wings", 3.99, 4));
        items.add(new Item("Fiji Water", 1.74, 1));

        itemRepository.save(items);


    }
}
