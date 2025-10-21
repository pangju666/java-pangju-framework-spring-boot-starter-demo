package io.github.pangju666.test.repository;

import io.github.pangju666.framework.autoconfigure.data.dynamic.mongo.annotation.DynamicMongo;
import io.github.pangju666.framework.data.mongodb.repository.BaseRepository;
import io.github.pangju666.test.model.dto.TestDTO;
import org.springframework.stereotype.Repository;

@DynamicMongo("test2")
@Repository
public class MongoRepository2 extends BaseRepository<String, TestDTO> {
}
