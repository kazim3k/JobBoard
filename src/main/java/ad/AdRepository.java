package ad;

import ad.Ad;
import category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {


    Set<Ad> findAllBy();
    Set<Ad> findAllByCategory(Category category);


}
