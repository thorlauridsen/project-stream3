package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.controllers.FilterController;
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
        String username = view.getUsername();
        String password = view.getPassword();

        if (username != null && password != null) {

            UserManager userManager = UserManager.getInstance();
            if (userManager.attemptLogin(username, password)) {

                CatalogViewModel viewModel = new CatalogViewModel();
                CatalogView view = new CatalogView();
                CatalogController controller = new CatalogController(viewModel, view);
                FilterController filterController = FilterController.getInstance();
                filterController.setCatalog(viewModel, view);
                controller.updateView();

            } else {
                view.showAlert();
            }
        }
    }
}
