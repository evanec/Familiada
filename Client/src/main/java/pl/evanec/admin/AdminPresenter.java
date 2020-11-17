package pl.evanec.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.Question;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPresenter;

import java.util.Collection;
import java.util.List;

@Controller
public class AdminPresenter extends AbstractPresenter<AdminView> {

    @Autowired
    public QuestionsService service;

    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    public void addQuestion(Question question) {
        service.AddQuestion(question);
    }

    public void deleteQuestions(Collection<Question> questions) {
        service.deleteQuestions(questions);
    }

}
