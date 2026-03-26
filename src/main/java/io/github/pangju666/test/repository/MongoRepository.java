package io.github.pangju666.test.repository;

import io.github.pangju666.framework.data.mongodb.repository.BaseMongoRepository;
import io.github.pangju666.test.document.TestDocument;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepository extends BaseMongoRepository<TestDocument, String> {
}
