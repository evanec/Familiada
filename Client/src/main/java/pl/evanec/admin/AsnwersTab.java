package pl.evanec.admin;

import com.github.appreciated.apexcharts.ApexCharts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.selection.MultiSelect;
import org.springframework.beans.factory.annotation.Autowired;
import pl.evanec.Answer;
import pl.evanec.Question;
import pl.evanec.QuestionsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsnwersTab extends VerticalLayout {

    @Autowired
    public QuestionsService service;
    Select<Question> labelSelect = new Select<>();

    public AsnwersTab(List<Question> questions, AdminPresenter presenter) {
        Set<Question> selectedQuestions = new HashSet<>();
        Button hide = new Button("Hide question");
        hide.addClickListener(e -> {

        });
        add(hide);
        Grid<Answer> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        MultiSelect<Grid<Answer>, Answer> multiSelect =
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
        add(labelSelect);

        grid.addColumn(Answer::getAnswerRaw).setHeader("raw").setWidth("100px");
        grid.addColumn(Answer::getAnswerStandardized).setHeader("standardized");
        grid.addColumn(Answer::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
    }
}
