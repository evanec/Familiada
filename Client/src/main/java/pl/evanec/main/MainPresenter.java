package pl.evanec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.AppFacade;
import pl.evanec.Question;
import pl.evanec.QuestionsRepository;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPresenter;

import java.util.List;

@Controller
public class MainPresenter extends AbstractPresenter<MainView> {

    @Autowired
    public QuestionsService service;

    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    public  void addQuestion(Question question){
        service.AddQuestion(question);
    }
}
