package com.github.kazim3k;

import com.github.kazim3k.ad.Ad;
import com.github.kazim3k.ad.AdRepository;
import com.github.kazim3k.category.Category;
import com.github.kazim3k.category.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AfterApplication implements CommandLineRunner {

    private AdRepository adRepository;
    private CategoryRepository categoryRepository;

    public AfterApplication(AdRepository adRepository, CategoryRepository categoryRepository) {
        this.adRepository = adRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (adRepository.findAllBy().isEmpty() &&
                categoryRepository.findAllBy().isEmpty()) {
            Category categoryIT = createCategory("IT");
            Category categorymMrketing = createCategory("Makreting");
            Category categoryGastronomy = createCategory("Gastronomy");
            StringBuilder sb = new StringBuilder();
            sb.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                    "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
                    "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " +
                    "sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                    "mollit anim id est laborum.");
            Ad ad = createAd("JAVA JUNIOR DEVELOPER",sb,categoryIT);
        }
    }

    private Ad createAd(String header, StringBuilder content, Category category) {
        Ad ad = new Ad();
        ad.setHeader(header);
        ad.setContent(content);
        ad.setCategory(category);
        return adRepository.save(ad);
    }

    private Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

}
