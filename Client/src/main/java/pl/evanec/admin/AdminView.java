package pl.evanec.admin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractView;

@Route("Admin")
public class AdminView extends AbstractView<AdminPresenter> {

    private Label logo;
    private Grid<Question> grid;
    public AdminView(AdminPresenter presenter) {
        super(presenter);
        this.logo = new Label("FANTASTYCZNA FAMILIADA");
        this.logo.setClassName("logo");
        this.grid = new Grid<>(Question.class);
        this.grid.setHeight("300px");
        this.grid.setColumns("question", "ipOfResponder", "answers");
        grid.setItems(getPresenter().getAllQuestions());
        add(logo, new Hr(), grid);
    }
}
