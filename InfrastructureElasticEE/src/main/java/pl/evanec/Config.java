package pl.evanec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
class Config {

    @Bean
    AppFacade appFacade(QuestionsRepository repo) {
        return new AppFacade(repo);
    }

}
