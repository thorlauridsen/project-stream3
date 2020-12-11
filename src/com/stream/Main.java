package com.stream;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.stream.controllers.CatalogController;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
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
     * Create Catalog frontpage
     */
    public void createGUI() {
        CatalogViewModel viewModel = new CatalogViewModel();
        CatalogView view = new CatalogView();

        CatalogController controller = new CatalogController(viewModel, view);
        controller.updateView();
    }
}
