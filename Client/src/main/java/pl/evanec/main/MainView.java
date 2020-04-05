package pl.evanec.main;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    Label faq;
    final TextField addQuestionField;
    private final Button addQuestionButton;
    private final Button questionSucksButton;
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
        addQuestionField.setThemeName("size-xl");
        addQuestionField.setClassName("textInput");
        this.addAnswerButton = new Button("Dodaj odpowiedź do pytania", VaadinIcon.PLUS.create());
        addAnswerButton.setClassName("button");
        addAnswerButton.addThemeName("size-l");

        this.questionSucksButton = new Button("Pytanie jest słabe", VaadinIcon.THUMBS_DOWN_O.create());
        questionSucksButton.setClassName("button");
        questionSucksButton.addThemeName("error");
        this.addQuestionButton = new Button("Dodaj pytanie", VaadinIcon.PLUS.create());
        addQuestionButton.setClassName("button");
        this.questionToAnswerLabel = new Label("Nie ma więcej pytań, może dodaj nowe?");
        questionToAnswerLabel.setClassName("question");
        // build layout
        HorizontalLayout buttons = new HorizontalLayout(addAnswerButton,questionSucksButton);
        buttons.setClassName("button");
        faq = new Label("Zostań jednym z naszych Ankietowanych dodając odpowiedzi na pytania z zakresu szerokopojętej fantastyki, Sciece fiction, filmów, książek, gier, papierowych rpg i tym podobnych. Możesz też dodać własną propozycję pytania.");
        faq.setClassName("faq");
        VerticalLayout addQuestionLayout = new VerticalLayout( addQuestionField, addQuestionButton);
        addQuestionLayout.setClassName("containers");
        VerticalLayout addQuestionAnswerLayout = new VerticalLayout(questionToAnswerLabel, addAnswerField, buttons);
        addQuestionAnswerLayout.setClassName("containers");
        add(logo, new Hr(), faq, new Hr(), addQuestionAnswerLayout, new Hr(), addQuestionLayout);
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        List<Question> allQuestions = getPresenter().getAllQuestions();
        questionToAnswer = setQuestionToAnswer();
        addAnswerButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(addAnswerField.getValue(), address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            questionToAnswer = setQuestionToAnswer();
        });

        addQuestionButton.addClickListener(e -> {
            getPresenter().addQuestion(new Question(addQuestionField.getValue(), address));
        });
    }

    private Question setQuestionToAnswer() {
        List<Question> allQuestions = getPresenter().getAllQuestions();
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        Optional<Question> result = allQuestions.stream().filter(q -> q.getAnswers().stream().noneMatch(a -> a.getIpOfResponder().equals(address))).findAny();
        result.ifPresent(q -> questionToAnswerLabel.setText(q.getQuestion()));
        return result.orElse(null);
    }
}
