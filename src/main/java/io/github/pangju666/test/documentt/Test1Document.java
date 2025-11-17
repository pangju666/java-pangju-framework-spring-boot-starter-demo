package io.github.pangju666.test.documentt;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("test")
public class Test1Document {
	@MongoId
	private String id;
	private String name;
	private String value;
}
