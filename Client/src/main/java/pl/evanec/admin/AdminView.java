package pl.evanec.admin;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import pl.evanec.Answer;
import pl.evanec.Question;
import pl.evanec.QuestionsService;

import java.util.List;

@StyleSheet("style.css")
@Route("Admin")
@PageTitle("Admin")
@JsModule("./src/views/admin-view.js")
@Tag("admin-view")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class AdminView extends PolymerTemplate<AdminView.AdminViewModel> {
    public interface AdminViewModel extends TemplateModel {
//         List<Question> getAllQuestions();
//          void addQuestion(Question question);
        void saveString(String test);
         bea
    }

    @Id("question")
    private Div question;

    @Id("saveAnswer")
    private Button saveAnswer;

    @Id("ignore")
    private Button ignore;

    @Id("report")
    private Button report;

    @Id("saveQuestion")
    private Button saveQuestion;

    @Id("addAnswerField")
    private TextField addAnswerField;

    AdminView(){
        saveAnswer.addClickListener(e -> {
            question.setText(addAnswerField.getValue());
            getModel().saveString(addAnswerField.getValue());
        });

//        questionSucksButton.addClickListener(e -> {
//            questionToAnswer.getAnswers().add(new Answer(true, address, questionToAnswer));
//            getPresenter().addQuestion(questionToAnswer);
//            questionToAnswer = setQuestionToAnswer(buttons);
//        });
//
//        passQuestionButton.addClickListener(e -> {
//            questionToAnswer.getAnswers().add(new Answer("", address, questionToAnswer));
//            getPresenter().addQuestion(questionToAnswer);
//            questionToAnswer = setQuestionToAnswer(buttons);
//        });
//
//        addQuestionButton.addClickListener(e -> {
//            getPresenter().addQuestion(new Question(addQuestionField.getValue(), address));
//            questionToAnswer = setQuestionToAnswer(buttons);
//        });
    }


}
