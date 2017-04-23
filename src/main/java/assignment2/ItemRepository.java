package assignment2;

import assignment2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Component
public interface ItemRepository extends JpaRepository<Item, Long> {

}
