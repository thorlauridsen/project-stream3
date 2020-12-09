package com.stream;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.stream.controllers.CatalogController;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.setupTheme();
        m.createGUI();
    }

    public void setupTheme() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (Exception ex) {
            System.out.println("Failed to initialize theme");
        }
    }

    public void createGUI() {
        CatalogViewModel c = new CatalogViewModel();
        CatalogView cv = new CatalogView();

        CatalogController cc = new CatalogController(c, cv);
        cc.updateView();
    }
}
