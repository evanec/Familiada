package pl.evanec.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.Question;
import pl.evanec.QuestionRepo;
import pl.evanec.mvp.AbstractPresenter;

import java.util.List;

@Controller
public class AdminPresenter extends AbstractPresenter<AdminView> {

    @Autowired
    private QuestionRepo repo;

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }
}
