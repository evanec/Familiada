package pl.evanec.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.MultiSelect;
import pl.evanec.QuestionTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AllQuestionTab extends VerticalLayout {

    public AllQuestionTab(Collection<QuestionTO> questions, AdminPresenter presenter) {
        Set<QuestionTO> selectedQuestions = new HashSet<>();

        Button hide = new Button("Hide question");
       // Button showHidden = new Button("Show hidden");
      //  Button hideHidden = new Button("hide hidden");

        //HorizontalLayout buttons = new HorizontalLayout(hide, showHidden, hideHidden);
        add(hide);
        Grid<QuestionTO> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        MultiSelect<Grid<QuestionTO>, QuestionTO> multiSelect =
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
        grid.addColumn(QuestionTO::getId).setHeader("id").setWidth("50px");
        grid.addColumn(QuestionTO::getQuestion).setHeader("question");
        grid.addColumn(QuestionTO::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
        setHeightFull();
    }
}
