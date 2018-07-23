package ad;

import category.Category;

import java.util.Set;

public interface AdService {

    Set<Ad> findAll();
    Set<Ad> findAllByCategory();
    void create(String header, StringBuilder content, Category category);
}
