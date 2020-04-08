package pl.evanec.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.AppFacade;
import pl.evanec.Question;
import pl.evanec.QuestionsRepository;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPresenter;

import java.util.List;

@Controller
public class AdminPresenter extends AbstractPresenter<AdminView> {

    @Autowired
    public QuestionsService service;

    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }
}
