package io.github.pangju666.test.repository;

import io.github.pangju666.framework.boot.data.dynamic.mongo.DynamicMongo;
import io.github.pangju666.framework.data.mongodb.repository.BaseMongoRepository;
import io.github.pangju666.test.model.dto.TestDTO;
import org.springframework.stereotype.Repository;

@DynamicMongo("test1")
@Repository
public interface MongoRepository1 extends BaseMongoRepository<TestDTO, String> {
}
