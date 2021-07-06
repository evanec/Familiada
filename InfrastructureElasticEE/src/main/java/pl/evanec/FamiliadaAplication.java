package pl.evanec;

import org.elasticsearch.action.index.IndexRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class FamiliadaAplication {
    public static void main(String[] args) {
        SpringApplication.run(FamiliadaAplication.class, args);
    }

//    @PostConstruct
//    public void postConstruct() {
//        System.out.println("Started after Spring boot application !");
//
//        IndexRequest indexRequest = new IndexRequest("posts")
//                .id("1")
//                .source("user", "kimchy",
//                        "postDate", new Date(),
//                        "message", "trying out Elasticsearch");
//    }
}
