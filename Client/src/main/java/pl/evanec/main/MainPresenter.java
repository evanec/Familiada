package pl.evanec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.Question;
import pl.evanec.QuestionRepo;
import pl.evanec.mvp.AbstractPresenter;

import java.util.List;

@Controller
public class MainPresenter extends AbstractPresenter<MainView> {
    @Autowired
    public QuestionRepo repo;

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    public  void addQuestion(Question question){
        repo.save(question);
    }
}
