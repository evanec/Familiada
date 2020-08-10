package pl.evanec.admin;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import pl.evanec.Question;
import pl.evanec.mvp.AbstractView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Route("Admin")
@PageTitle("Admin")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class AdminView extends AbstractView<AdminPresenter> {

    Component selectedPage = null;
    List<Question> questions = null;

    public AdminView(AdminPresenter presenter) {
        super(presenter);
    }

    @Override
    public void init() {
        questions = getPresenter().getAllQuestions();
        Tab tab1 = new Tab("Questions");
        Tab tab2 = new Tab("Question charts");
        Tab tab3 = new Tab("Answers");
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        add(tabs);

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, new AllQuestionTab(questions));
        tabsToPages.put(tab2, new AnswerCharts(questions));
        tabsToPages.put(tab3,  new AsnwersTab(questions));
        tabs.addSelectedChangeListener(event -> {
            if(selectedPage != null){
                remove(selectedPage);
            }
            Tab test = tabs.getSelectedTab();
            selectedPage = tabsToPages.get(tabs.getSelectedTab());
            add(selectedPage);
        });
  //      tabs.setSelectedTab(tab2);
    }
}
