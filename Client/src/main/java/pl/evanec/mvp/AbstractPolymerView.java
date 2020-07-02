package pl.evanec.mvp;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@StyleSheet("style.css")
public abstract class AbstractPolymerView<T extends AbstractPolymerPresenter> extends PolymerTemplate<TemplateModel> {
    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public abstract void init();

    public AbstractPolymerView(T presenter) {
        this.presenter = presenter;
        init();
    }
}
