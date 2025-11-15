package io.github.pangju666.test.repository;

import io.github.pangju666.framework.boot.data.dynamic.mongo.DynamicMongo;
import io.github.pangju666.framework.data.mongodb.repository.BaseMongoRepository;
import io.github.pangju666.test.model.dto.TestDTO;
import org.springframework.stereotype.Repository;

@DynamicMongo("test2")
@Repository
public interface MongoRepository2 extends BaseMongoRepository<TestDTO, String> {
}
