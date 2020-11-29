package pl.evanec.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.MultiSelect;
import org.springframework.beans.factory.annotation.Autowired;
import pl.evanec.Question;
import pl.evanec.QuestionsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AllQuestionTab extends VerticalLayout {

    public AllQuestionTab(Collection<Question> questions, AdminPresenter presenter) {
        Set<Question> selectedQuestions = new HashSet<>();

        Button hide = new Button("Hide question");
       // Button showHidden = new Button("Show hidden");
      //  Button hideHidden = new Button("hide hidden");

        //HorizontalLayout buttons = new HorizontalLayout(hide, showHidden, hideHidden);
        add(hide);
        Grid<Question> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        MultiSelect<Grid<Question>, Question> multiSelect =
                grid.asMultiSelect();
        multiSelect.addValueChangeListener(e -> {
            selectedQuestions.clear();
            selectedQuestions.addAll(e.getValue());
        });
        hide.addClickListener(e -> {
            presenter.deleteQuestions(selectedQuestions);
            grid.setItems(presenter.getAllQuestions());
        });

//        showHidden.addClickListener(e -> {
//            grid.setItems(questions);
//        });
//        hideHidden.addClickListener(e -> {
//            grid.setItems(questions.stream().filter(q -> !q.isRemoved()).collect(Collectors.toList()));
//        });
        grid.setItems(questions.stream().filter(q -> !q.isRemoved()).collect(Collectors.toList()));
        grid.addColumn(Question::getId).setHeader("id").setWidth("50px");
        grid.addColumn(Question::getQuestion).setHeader("question");
        grid.addColumn(Question::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
    }
}
