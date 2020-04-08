package pl.evanec.main;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.evanec.Answer;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractView;

import java.util.List;
import java.util.Optional;

//Gównokod, pozniej sie nim zajmę
@Route
public class MainView extends AbstractView<MainPresenter> {

    final Label logo;
    final TextField addQuestionField;
    final TextField addAnswerField;
    final Label questionToAnswerLabel;
    private final Button addQuestionButton;
    private final Button questionSucksButton;
    private final Button passQuestionButton;
    private final Button addAnswerButton;
    Label faq;
    Question questionToAnswer;

    public MainView(MainPresenter presenter) {
        super(presenter);
        setHorizontalComponentAlignment(Alignment.CENTER, this);
        setWidth("50%");
        setClassName("window");
        this.logo = new Label("FANTASTYCZNA FAMILIADA");
        logo.setClassName("logo");
        this.addAnswerField = new TextField();
        addAnswerField.setClassName("textInput");
        addAnswerField.setPlaceholder("Wprowadź tutaj odpowiedź do pytania");
        this.addQuestionField = new TextField();

        addQuestionField.setClassName("textInput");
        addQuestionField.setPlaceholder("Wprowadź tutaj nowe pytanie");
        this.addAnswerButton = new Button("Dodaj odpowiedź", VaadinIcon.PLUS.create());
        addAnswerButton.setClassName("button");
        addAnswerButton.addThemeName("size-l");
        passQuestionButton = new Button("Pomiń", VaadinIcon.CLOSE_BIG.create());
        passQuestionButton.setClassName("button");
        this.questionSucksButton = new Button("Odrzuć", VaadinIcon.THUMBS_DOWN_O.create());
        questionSucksButton.setClassName("button");
        questionSucksButton.addThemeName("error");
        this.addQuestionButton = new Button("Dodaj pytanie", VaadinIcon.PLUS.create());
        addQuestionButton.setClassName("button");
        this.questionToAnswerLabel = new Label("Nie ma więcej pytań, może dodaj nowe?");
        questionToAnswerLabel.setClassName("question");
        // build layout
        HorizontalLayout buttons = new HorizontalLayout(addAnswerButton, passQuestionButton, questionSucksButton);
        addAnswerButton.setSizeFull();
        passQuestionButton.setSizeFull();
        questionSucksButton.setSizeFull();
        buttons.setSizeFull();
        buttons.setClassName("buttons");
        faq = new Label("Zostań jednym z naszych Ankietowanych dodając odpowiedzi na pytania z zakresu szerokopojętej fantastyki, Sciece fiction, filmów, książek, gier, papierowych rpg i tym podobnych. Możesz też dodać własną propozycję pytania.");
        faq.setClassName("faq");
        VerticalLayout addQuestionLayout = new VerticalLayout(addQuestionField, addQuestionButton);
        addQuestionButton.setSizeFull();
        addQuestionLayout.setClassName("containers");
        VerticalLayout addQuestionAnswerLayout = new VerticalLayout(questionToAnswerLabel, addAnswerField, buttons);
        addQuestionAnswerLayout.setClassName("containers");
        add(logo, new Hr(), faq, new Hr(), addQuestionAnswerLayout, new Hr(), addQuestionLayout);
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        List<Question> allQuestions = getPresenter().getAllQuestions();
        questionToAnswer = setQuestionToAnswer(buttons);

        addAnswerButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(addAnswerField.getValue(), address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            questionToAnswer = setQuestionToAnswer(buttons);
        });

        questionSucksButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer(true, address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            questionToAnswer = setQuestionToAnswer(buttons);
        });

        passQuestionButton.addClickListener(e -> {
            questionToAnswer.getAnswers().add(new Answer("", address, questionToAnswer));
            getPresenter().addQuestion(questionToAnswer);
            questionToAnswer = setQuestionToAnswer(buttons);
        });

        addQuestionButton.addClickListener(e -> {
            getPresenter().addQuestion(new Question(addQuestionField.getValue(), address));
            questionToAnswer = setQuestionToAnswer(buttons);
        });
    }

    private Question setQuestionToAnswer(HorizontalLayout buttons) {
        List<Question> allQuestions = getPresenter().getAllQuestions();
        final String address = UI.getCurrent().getSession().getBrowser().getAddress();
        Optional<Question> result = allQuestions.stream().filter(q -> q.getAnswers().stream().noneMatch(a -> a.getIpOfResponder().equals(address))).findAny();
        result.ifPresent(q -> questionToAnswerLabel.setText(q.getQuestion()));
            buttons.setVisible(result.isPresent());
            addAnswerField.setVisible(result.isPresent());
        return result.orElse(null);
    }
}
