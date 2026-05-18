package com.zepto.sdui.repository;

import com.zepto.sdui.model.HomeScreenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HomeScreenRepository extends MongoRepository<HomeScreenDocument, String> {
    Optional<HomeScreenDocument> findByScreen(String screen);
}