package category;


import java.util.Set;

public interface CategoryService {

    Set<Category> findAll();
    void create(Category category);
}
