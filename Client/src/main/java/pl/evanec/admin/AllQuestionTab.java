package pl.evanec.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.MultiSelect;
import org.springframework.beans.factory.annotation.Autowired;
import pl.evanec.Question;
import pl.evanec.QuestionsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AllQuestionTab extends VerticalLayout {

    @Autowired
    public QuestionsService service;

    public AllQuestionTab(Collection<Question> questions) {
        Set<Question> selectedQuestions = new HashSet<>();
        Button hide = new Button("Hide question");
        hide.addClickListener(e ->{

        });
        add(hide);



        Grid<Question> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        MultiSelect<Grid<Question>, Question> multiSelect =
                grid.asMultiSelect();
        multiSelect.addValueChangeListener(e -> {
            selectedQuestions.clear();
            selectedQuestions.addAll(e.getValue());
        });

        grid.setItems(questions);
        grid.addColumn(Question::getId).setHeader("id").setWidth("50px");
        grid.addColumn(Question::getQuestion).setHeader("question");
        grid.addColumn(Question::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
    }
}
