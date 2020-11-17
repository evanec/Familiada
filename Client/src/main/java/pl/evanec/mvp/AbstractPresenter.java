package pl.evanec.mvp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

public abstract class AbstractPresenter<T extends AbstractView> {

    public T view;

    public T getView() {
        return view;
    }

    void setView(T view) {
        this.view = view;
    }
}
