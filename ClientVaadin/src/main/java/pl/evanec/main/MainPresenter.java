package pl.evanec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.QuestionTO;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPolymerPresenter;

import java.util.List;

@Controller
public class MainPresenter extends AbstractPolymerPresenter<MainView> {

    @Autowired
    public QuestionsService service;

    public List<QuestionTO> getAllQuestions() {
        return service.getAllQuestions();
    }

    public void addQuestion(QuestionTO question) {
        service.AddQuestion(question);
    }

}
