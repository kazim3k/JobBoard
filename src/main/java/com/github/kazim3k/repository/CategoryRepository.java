package com.github.kazim3k.repository;

import com.github.kazim3k.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Set<Category> findAllBy();
    Category findOneByName(String name);
}
