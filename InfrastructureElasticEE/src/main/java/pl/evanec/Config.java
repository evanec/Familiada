package pl.evanec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.evanec.questions.JPAQuestionRepository;

@Configuration
@EnableTransactionManagement
//@ComponentScan({"pl.evanec.questions"})
class Config {

    @Bean
    AppFacade appFacade(QuestionsRepository repo) {
        return new AppFacade(repo);
    }

//    @Bean
//    QuestionsRepository questionsRepository() {
//        return new JPAQuestionRepository();
//    }

}
