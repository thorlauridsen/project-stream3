package com.stream.models;

public abstract class BaseController {

    protected BaseModel model;
    protected BaseView view;

    public BaseController(BaseModel model, BaseView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.updateView();
    }
}
