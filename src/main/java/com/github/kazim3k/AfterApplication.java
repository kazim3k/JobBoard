package com.github.kazim3k;

import com.github.kazim3k.entity.Ad;
import com.github.kazim3k.repository.AdRepository;
import com.github.kazim3k.entity.Category;
import com.github.kazim3k.repository.CategoryRepository;
import com.github.kazim3k.entity.User;
import com.github.kazim3k.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AfterApplication implements CommandLineRunner {

    private AdRepository adRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public AfterApplication(AdRepository adRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.adRepository = adRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (adRepository.findAllBy().isEmpty() &&
                categoryRepository.findAllBy().isEmpty()) {
            Category categoryIT = createCategory("IT");
            Category categorymMrketing = createCategory("Makreting");
            Category categoryGastronomy = createCategory("Gastronomy");
            String content = "Lorem ipsum dolor sit amet, consectetur";
            Ad ad = createAd("JAVA JUNIOR DEVELOPER",content,categoryIT);
            User user = createUser("michal.kuzma1994@gmail.com","kazim3k","123");
        }
    }

    private Ad createAd(String header, String content, Category category) {
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

    private User createUser(String email, String login, String password) {
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        return userRepository.save(user);
    }

}
