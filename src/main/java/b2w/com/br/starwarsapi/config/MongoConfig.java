package b2w.com.br.starwarsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
	
	@Bean
	public MongoClient mongoClient() {
        return MongoClients
                .create("mongodb+srv://sa:sa@mongodb.in9wv.mongodb.net/test?retryWrites=true&w=majority");
    }
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), "test");
	}
}

