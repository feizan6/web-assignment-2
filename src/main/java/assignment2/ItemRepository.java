package assignment2;

import assignment2.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fayzan on 13/04/2017.
 */

@RestResource
public interface ItemRepository extends CrudRepository<Item, Integer> {


    Iterable<Item> findByItemName(String itemName);
}
