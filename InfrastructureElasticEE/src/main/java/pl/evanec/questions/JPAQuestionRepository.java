package pl.evanec.questions;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.evanec.QuestionTO;
import pl.evanec.QuestionsRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class JPAQuestionRepository implements QuestionsRepository {

    @Override
    public QuestionTO save(QuestionTO questionTO) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1")
                .source("user", "kimchy",
                        "postDate", new Date(),
                        "message", "trying out Elasticsearch");

        try {
            client.index(indexRequest, RequestOptions.DEFAULT);


            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(QuestionTO questionTO) {

    }

    @Override
    public List<QuestionTO> findAllQuestions() {
        return null;
    }
}
