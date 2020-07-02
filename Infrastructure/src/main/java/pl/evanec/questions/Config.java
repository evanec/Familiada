package pl.evanec.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.evanec.AppFacade;
import pl.evanec.QuestionsRepository;

@Configuration
class Config {

   @Bean
   AppFacade appFacade(QuestionsRepository repo) {
        return new AppFacade(repo);
   }

}
