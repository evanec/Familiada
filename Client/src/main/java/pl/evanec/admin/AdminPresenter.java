package pl.evanec.admin;

import com.vaadin.flow.component.polymertemplate.ModelItem;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.AppFacade;
import pl.evanec.Question;
import pl.evanec.QuestionsRepository;
import pl.evanec.QuestionsService;
import pl.evanec.mvp.AbstractPresenter;

import java.util.List;
import java.util.logging.Logger;

@ModelItem
public class AdminPresenter implements AdminView.AdminViewModel {

    public QuestionsService service;

    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    public  void addQuestion(Question question){
        service.AddQuestion(question);
    }

    @Override
    public void saveString(String test) {
        System.out.println(test);
    }
}
