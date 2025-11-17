package io.github.pangju666.test.service;

import io.github.pangju666.test.documentt.Test1Document;
import io.github.pangju666.test.documentt.Test2Document;
import io.github.pangju666.test.repository.Test1Repository;
import io.github.pangju666.test.repository.Test2Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
	public MongoService(Test2Repository repository2, Test1Repository repository1) {
		List<Test1Document> document1List = repository1.findAll();
		List<Test2Document> document2List = repository2.findAll();
	}
}
