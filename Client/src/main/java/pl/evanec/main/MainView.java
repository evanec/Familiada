package pl.evanec.main;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.evanec.Answer;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractView;

import java.util.List;
import java.util.Optional;

@Route
public class MainView extends AbstractView<MainPresenter> {

    final Label logo;
    final TextField addQuestionField;
    private final Button addQuestionButton;
    final TextField addAnswerField;
    private final Button addAnswerButton;
    final Label questionToAnswerLabel;
    Question questionToAnswer;

    public MainView(MainPresenter presenter) {
        super(presenter);
        setHorizontalComponentAlignment(Alignment.CENTER, this);
        setWidth("66%");
        setClassName("window");
        this.logo = new Label("FANTASTYCZNA FAMILIADA");
        logo.setClassName("logo");
        this.addAnswerField = new TextField();
        addAnswerField.setClassName("textInput");
        this.addQuestionField = new TextField();
        addQuestionField.setClassName("textInput");
        this.addAnswerButton = new Button("Dodaj odpowiedź do pytania", VaadinIcon.PLUS.create());
        addAnswerButton.setClassName("button");
        this.addQuestionButton = new Button("Dodaj pytanie do bazy", VaadinIcon.PLUS.create());
        addQuestionButton.setClassName("button");
        this.questionToAnswerLabel = new Label("Ni ma wincyj pytan");
        questionToAnswerLabel.setClassName("question");
        // build layout
        VerticalLayout addQuestionLayout = new VerticalLayout(addQuestionField, addQuestionButton);
        VerticalLayout addQuestionAnswerLayout = new VerticalLayout(questionToAnswerLabel, addAnswerField, addAnswerButton);

        add(logo, new Hr(), addQuestionAnswerLayout, new Hr(), addQuestionLayout);
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        List<Question> allQuestions = getPresenter().repo.findAll();
        questionToAnswer = setQuestionToAnswer();
        addAnswerButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(addAnswerField.getValue(), address, questionToAnswer));
            getPresenter().repo.save(questionToAnswer);
            questionToAnswer = setQuestionToAnswer();
        });

        addQuestionButton.addClickListener(e -> {
            getPresenter().repo.save(new Question(addQuestionField.getValue(), address));
        });
    }

    private Question setQuestionToAnswer() {
        List<Question> allQuestions = getPresenter().repo.findAll();
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        Optional<Question> result = allQuestions.stream().filter(q -> q.getAnswers().stream().noneMatch(a -> a.getIpOfResponder().equals(address))).findAny();
        result.ifPresent(q -> questionToAnswerLabel.setText(q.getQuestion()));
        return result.orElse(null);
    }
}
