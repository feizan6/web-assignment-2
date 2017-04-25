package assignment2;

import assignment2.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Fayzan on 13/04/2017.
 */

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
