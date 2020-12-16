package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.controllers.FilterController;
import com.stream.exceptions.LoginException;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.viewmodels.LoginViewModel;
import com.stream.views.CatalogView;
import com.stream.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginListener implements ActionListener {

    private LoginView view;
    private LoginViewModel viewModel;

    public LoginListener(LoginView view, LoginViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.getUsername();
        String pass = view.getPassword();

        if (name != null && pass != null) {
            if (!name.isEmpty() && !pass.isEmpty()) {

                UserManager userManager = UserManager.getInstance();
                try {
                    if (userManager.attemptLogin(name, pass)) {

                        CatalogViewModel viewModel = new CatalogViewModel();
                        CatalogView view = new CatalogView();
                        CatalogController controller = new CatalogController(viewModel, view);
                        FilterController filterController = FilterController.getInstance();
                        filterController.setCatalog(viewModel, view);
                        filterController.resetFilter();
                        controller.updateView();
                    }
                } catch (LoginException ex) {
                    view.showAlert(ex.getMessage());
                }
            }
        }
    }
}
