package com.github.kazim3k.repository;

import com.github.kazim3k.entity.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {


    Set<Ad> findAllBy();
    Set<Ad> findAllByCategoryId(Long categoryId);
    Set<Ad> findAllByUserId(Long userId);
    Set<Ad> findAllByUserLogin(String login);
    Set<Ad> findAllByCategoryName(String name);


}
