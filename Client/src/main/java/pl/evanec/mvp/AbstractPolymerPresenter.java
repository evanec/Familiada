package pl.evanec.mvp;

public abstract class AbstractPolymerPresenter<T extends AbstractPolymerView>{

    public T view;

    public T getView() {
        return view;
    }

    void setView(T view) {
        this.view = view;
    }
}
