package assignment2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemPriceLessThan(double price);
}
