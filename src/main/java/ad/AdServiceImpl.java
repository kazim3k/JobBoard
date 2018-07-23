package ad;

import category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdServiceImpl implements AdService {

    private AdRepository adRepository;

    @Autowired
    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public Set<Ad> findAll() {
        return null;
    }

    @Override
    public Set<Ad> findAllByCategory() {
        return null;
    }

    @Override
    public void create(String header, StringBuilder content, Category category) {

    }
}
