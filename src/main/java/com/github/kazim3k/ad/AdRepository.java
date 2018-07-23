package com.github.kazim3k.ad;

import com.github.kazim3k.ad.Ad;
import com.github.kazim3k.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {


    Set<Ad> findAllBy();
    Set<Ad> findAllByCategoryId(Long categoryId);


}
