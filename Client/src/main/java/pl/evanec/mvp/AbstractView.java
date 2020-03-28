package pl.evanec.mvp;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@StyleSheet("style.css")
public abstract class AbstractView<T extends AbstractPresenter> extends VerticalLayout {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public AbstractView(T presenter) {
        this.presenter = presenter;
    }
}
