//package com.github.kazim3k.service.impl;
//
//import com.github.kazim3k.entity.Ad;
//import com.github.kazim3k.repository.AdRepository;
//import com.github.kazim3k.repository.CategoryRepository;
//import com.github.kazim3k.repository.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class AdServiceImplTest {
//
//    @Autowired
//    AdRepository adRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    public void WhenDeletingAd_AdDoesNotExist() {
//
//        AdServiceImpl adService = new AdServiceImpl(adRepository,categoryRepository,
//                                                    userRepository);
//
//        Long adId = adService.create("Ad to delete","content",
//                                    categoryRepository.findOneByName("IT").getId());
//
//        Assertions.assertThat(adRepository.findOne(adId))
//                .isNotNull()
//                .hasFieldOrPropertyWithValue("header", "Ad to delete")
//                .hasFieldOrPropertyWithValue("content", "content")
//                .hasFieldOrPropertyWithValue("category", categoryRepository.findOneByName("IT"));
//
//
//        adService.deleteById(adId);
//
//        Assertions.assertThat(adRepository.findOne(adId))
//                .isNull();
//
//
//
//
//    }
//}
