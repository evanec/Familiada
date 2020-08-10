package pl.evanec;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FamiliadaAplication {

    public static void main(String[] args) {
        SpringApplication.run(FamiliadaAplication.class, args);
    }

    @Autowired
    private AppFacade app;

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            Question test1 = new Question("pytanie1", "1");
            Question test2 = new Question("pytanie2", "2");
            Question test3 = new Question("pytanie3", "3");
            List<Answer> answers = new ArrayList<>();
            answers.add(new Answer("odp1", "1", test1));
            answers.add(new Answer("odp2", "2", test1));
            answers.add(new Answer("odp1", "3", test1));
            answers.add(new Answer("odp3", "4", test1));
            answers.add(new Answer("odp1", "5", test1));
            answers.add(new Answer("odp3", "6", test1));

            answers.add(new Answer(true, "7", test1));
            answers.add(new Answer(true, "8", test1));
            answers.add(new Answer(true, "9", test1));

            test1.setAnswers(answers);


            app.AddQuestion(test1);
            app.AddQuestion(test2);
            app.AddQuestion(test3);
        };
    }
}
