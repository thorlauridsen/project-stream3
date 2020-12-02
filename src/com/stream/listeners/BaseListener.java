package com.stream.listeners;

import com.stream.views.BaseView;
import java.awt.event.ActionListener;


public abstract class BaseListener implements ActionListener {

    protected BaseView view;

    public BaseListener(BaseView view) {
        this.view = view;
    }
}
