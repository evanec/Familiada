package pl.evanec;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Route
//@Theme("test")
@StyleSheet("style.css")
public class MainView extends VerticalLayout {

    private final QuestionRepo repo;
    final Grid<Question> grid;
    final Label logo;
    final TextField addQuestionField;
    private final Button addQuestionButton;
    final TextField addAnswerField;
    private final Button addAnswerButton;
    final Label questionToAnswerLabel;
    Question questionToAnswer;

    public MainView(QuestionRepo repo) {
        this.repo = repo;
        this.grid = new Grid<>(Question.class);
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
        // build layout
        VerticalLayout addQuestionLayout = new VerticalLayout(addQuestionField, addQuestionButton);
        VerticalLayout addQuestionAnswerLayout = new VerticalLayout(questionToAnswerLabel, addAnswerField, addAnswerButton);

        add(logo, new Hr(), addQuestionAnswerLayout, new Hr(), addQuestionLayout);
        add(new Hr(), grid);

        grid.setHeight("300px");
        grid.setColumns("question", "ipOfResponder", "answers");
        Logger logger = LoggerFactory.getLogger(MainView.class);
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        List<Question> allQuestions = repo.findAll();
        allQuestions.stream().forEach(q -> q.getAnswers().stream().forEach(a -> logger.info("klik" + a.ipOfResponder + a.answer)));
        grid.setItems(allQuestions);

        questionToAnswer = setQuestionToAnswer();
        addAnswerButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(addAnswerField.getValue(), address, questionToAnswer));
            repo.save(questionToAnswer);
            questionToAnswer = setQuestionToAnswer();
        });

        addQuestionButton.addClickListener(e -> {
            repo.save(new Question(addQuestionField.getValue(), address));
        });
    }

    private Question setQuestionToAnswer() {
        List<Question> allQuestions = repo.findAll();
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        Optional<Question> result = allQuestions.stream().filter(q -> q.getAnswers().stream().noneMatch(a -> a.ipOfResponder.equals(address))).findAny();
        result.ifPresent(q -> questionToAnswerLabel.setText(q.question));
        return result.orElse(null);
    }
}
