package pl.evanec.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.selection.MultiSelect;
import org.springframework.beans.factory.annotation.Autowired;
import pl.evanec.AnswerTO;
import pl.evanec.QuestionTO;
import pl.evanec.QuestionsService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsnwersTab extends VerticalLayout {

    @Autowired
    public QuestionsService service;
    Select<QuestionTO> labelSelect = new Select<>();

    public AsnwersTab(List<QuestionTO> questions, AdminPresenter presenter) {
        Set<QuestionTO> selectedQuestions = new HashSet<>();
        Button hide = new Button("Hide question");
        Button standarized = new Button("Set as standarized");
        Button merge = new Button("Merge answers");
        hide.addClickListener(e -> {

        });

        Grid<AnswerTO> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);


        MultiSelect<Grid<AnswerTO>, AnswerTO> multiSelect =
                grid.asMultiSelect();
        multiSelect.addValueChangeListener(e -> {
//            selectedQuestions.clear();
//            selectedQuestions.addAll(e.);
        });
        labelSelect.setItems(questions);
        labelSelect.setLabel("Select question");
        labelSelect.addValueChangeListener((value) -> {
            grid.setItems(value.getValue().getAnswers());
        });
        labelSelect.setValue(questions.get(0));
        HorizontalLayout toolbar = new HorizontalLayout(labelSelect, hide, standarized, merge);
        toolbar.setAlignItems(Alignment.END);
        add(toolbar);
        grid.addColumn(AnswerTO::getAnswerRaw).setHeader("raw").setWidth("100px");
        grid.addColumn(AnswerTO::getAnswerStandardized).setHeader("standardized");
        grid.addColumn(AnswerTO::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
    }
}
