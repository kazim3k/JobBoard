package com.github.kazim3k.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Set<Category> findAllBy();
    Category findOneByName(String name);
}
