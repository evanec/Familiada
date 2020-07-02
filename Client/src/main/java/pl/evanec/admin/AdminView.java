package pl.evanec.admin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractView;

import java.util.List;


@Route("Admin")
@PageTitle("Admin")

@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class AdminView extends AbstractView<AdminPresenter> {

    public AdminView(AdminPresenter presenter) {
        super(presenter);
    }

    @Override
    public void init() {
        List<Question> questions = getPresenter().getAllQuestions();
        Grid<Question> grid = new Grid<>();
        grid.setItems(questions);
        grid.addColumn(Question::getId).setHeader("id").setWidth("50px");
        grid.addColumn(Question::getQuestion).setHeader("question");
        grid.addColumn(Question::getIpOfResponder).setHeader("ip").setWidth("150px");
        add(grid);
    }
}
