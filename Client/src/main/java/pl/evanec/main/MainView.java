package pl.evanec.main;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import pl.evanec.Answer;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractPolymerView;

import java.util.List;
import java.util.Optional;

@StyleSheet("style.css")
@Route("")
@PageTitle("Fantastyczna familiada")
@JsModule("./src/views/main-view.js")
@Tag("main-view")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends AbstractPolymerView<MainPresenter> {

    @Id("question")
    private Div question;

    @Id("answerSection")
    private Div answerSection;

    @Id("questionTooltip")
    private Div questionTooltip;

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

    @Id("addQuestionField")
    private TextField addQuestionField;

    public MainView(MainPresenter presenter) {
        super(presenter);
    }

    private Question questionToAnswer;
    private String address;

    @Override
    public void init() {
        address = UI.getCurrent().getSession().getBrowser().getAddress();
        setQuestionToAnswer();
        saveAnswer.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(addAnswerField.getValue(), address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            setQuestionToAnswer();
        });

        report.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(true, address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            setQuestionToAnswer();
        });

        ignore.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer("", address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            setQuestionToAnswer();
        });

        saveQuestion.addClickListener(e -> {
            getPresenter().addQuestion(new Question(addQuestionField.getValue(), address));
            addQuestionField.clear();
            setQuestionToAnswer();
        });
    }

    private void setQuestionToAnswer() {
        List<Question> allQuestions = getPresenter().getAllQuestions();
        Optional<Question> result = allQuestions.stream().filter(q -> q.getAnswers().stream().noneMatch(a -> a.getIpOfResponder().equals(address))).findAny();

        result.ifPresentOrElse(q -> {
                    questionToAnswer = q;
                    question.setText(q.getQuestion());
                    questionTooltip.setText("Możesz też dodać własną propozycję pytania.");
                    answerSection.setVisible(true);
                }, () -> {
                    questionToAnswer = null;
                    answerSection.setVisible(false);
                    questionTooltip.setText("Wygląda na to, że odpowiedziałeś(aś) na wszystkie pytania, może chcesz teraz dodać jakieś nowe? Nie zapomnij by wrócić za jakiś czas i odpowiedzieć na nowe pytania :) ");
                }
        );
    }
}
