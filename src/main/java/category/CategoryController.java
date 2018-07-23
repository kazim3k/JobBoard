package category;


import com.sun.xml.internal.fastinfoset.stax.events.CharactersEvent;
import com.sun.xml.internal.fastinfoset.util.CharArrayIntMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Set<Category> findAllBy() {
        return categoryService.findAll();
    }

    @PostMapping
    public void create(String name) {
        Category category = new Category();
        category.setName(name);
        categoryService.create(category);

    }

}
