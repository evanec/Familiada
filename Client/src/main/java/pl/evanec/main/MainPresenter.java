package pl.evanec.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.evanec.QuestionRepo;
import pl.evanec.mvp.AbstractPresenter;

@Controller
public class MainPresenter extends AbstractPresenter<MainView> {
    @Autowired
    public QuestionRepo repo;
}
