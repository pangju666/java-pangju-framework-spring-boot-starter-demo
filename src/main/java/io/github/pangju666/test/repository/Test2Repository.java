package io.github.pangju666.test.repository;

import io.github.pangju666.framework.boot.data.dynamic.mongo.DynamicMongo;
import io.github.pangju666.framework.data.mongodb.repository.BaseMongoRepository;
import io.github.pangju666.test.documentt.Test2Document;
import org.springframework.stereotype.Repository;

@DynamicMongo("test1")
@Repository
public interface Test2Repository extends BaseMongoRepository<Test2Document, String> {
}
