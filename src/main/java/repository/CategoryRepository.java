package repository;

import model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category,String> {

    Set<Category> findAllBy();
}
