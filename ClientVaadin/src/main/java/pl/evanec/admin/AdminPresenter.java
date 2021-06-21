package pl.evanec.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.QuestionTO;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPresenter;

import java.util.Collection;
import java.util.List;

@Controller
public class AdminPresenter extends AbstractPresenter<AdminView> {

    @Autowired
    public QuestionsService service;

    public List<QuestionTO> getAllQuestions() {
        return null;
    }

    public void addQuestion(QuestionTO question) {

    }

    public void deleteQuestions(Collection<QuestionTO> questions) {

    }

}
