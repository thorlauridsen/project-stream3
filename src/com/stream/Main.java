package com.stream;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.stream.controllers.CatalogController;
import com.stream.controllers.LoginController;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.viewmodels.LoginViewModel;
import com.stream.views.CatalogView;
import com.stream.views.LoginView;

import javax.swing.*;


public class Main {

    /**
     * Main method that runs first when starting the program
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.setupTheme();
        main.createGUI();
    }

    /**
     * Setup dark mode theme
     */
    public void setupTheme() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (Exception ex) {
            System.out.println("Failed to initialize theme");
        }
    }

    /**
     * Create Login frontpage
     */
    public void createGUI() {
        LoginViewModel viewModel = new LoginViewModel();
        LoginView view = new LoginView();

        LoginController controller = new LoginController(viewModel, view);
        controller.updateView();
    }
}
