package io.github.pangju666.test.repository;

import io.github.pangju666.framework.autoconfigure.data.dynamic.mongo.annotation.DynamicMongo;
import io.github.pangju666.framework.data.mongodb.repository.BaseRepository;
import io.github.pangju666.test.model.dto.TestDTO;
import org.springframework.stereotype.Repository;

@DynamicMongo("test1")
@Repository
public class MongoRepository1 extends BaseRepository<String, TestDTO> {
}
