package com.github.kazim3k;

import com.github.kazim3k.entity.Ad;
import com.github.kazim3k.repository.AdRepository;
import com.github.kazim3k.entity.Category;
import com.github.kazim3k.repository.CategoryRepository;
import com.github.kazim3k.entity.User;
import com.github.kazim3k.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AfterApplication implements CommandLineRunner {

    private AdRepository adRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AfterApplication(AdRepository adRepository, CategoryRepository categoryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.adRepository = adRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (adRepository.findAllBy().isEmpty() &&
                categoryRepository.findAllBy().isEmpty()) {
            Category categoryIT = createCategory("IT");
            Category categoryMarketing = createCategory("Makreting");
            Category categoryGastronomy = createCategory("Gastronomy");
            Category categoryHR = createCategory("HR");
            Category categoryDriver = createCategory("Driver");
            Category categorySecurity = createCategory("Security");
            Category categoryEducation = createCategory("Education");
            Category categoryTourism = createCategory("Tourism");
            String content = "Looking for Java developer no experience ASAP";
            User user = createUser("micha.kuzma1994@gmaiI.com","kazim3k","123");
            Ad ad = createAd("JAVA JUNIOR DEVELOPER",content,categoryIT,user);
        }
    }

    private Ad createAd(String header, String content, Category category,User user) {
        Ad ad = new Ad();
        ad.setHeader(header);
        ad.setContent(content);
        ad.setCategory(category);
        ad.setUser(user);
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
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

}
