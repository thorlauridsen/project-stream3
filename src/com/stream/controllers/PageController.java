package com.stream.controllers;

import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;


public class PageController {

    private static PageController instance;

    private JFrame frame;
    private Component previousComponent;

    public PageController() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stream Lime");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("res/images/logoLime.png");
            Image pic = ImageIO.read(is);
            frame.setIconImage(pic);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Saves current component of getContentPane from frame as previousComponent
     * Can be used to return to the page later
     * Removes all components from getContentPane
     * Adds component to frame and updates the view
     * @param component added to the frame view
     */
    public void setView(Component component) {
        if (frame.getContentPane().getComponents().length > 0) {
            previousComponent = frame.getContentPane().getComponent(0);
        }
        frame.getContentPane().removeAll();
        frame.add(component);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setPreferredSize(new Dimension(1920, 1000));
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Sets view to the previously saved component if it exists
     */
    public void goBack() {
        if (previousComponent != null) {
            setView(previousComponent);
        }
    }

    /**
     * Create new instance of Catalog and reset the filter of filterController
     * Then update the view using setView
     */
    public void clearCatalog() {
        CatalogViewModel viewModel = new CatalogViewModel();
        CatalogView view = new CatalogView();
        CatalogController controller = new CatalogController(viewModel, view);
        controller.updateView();

        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(viewModel, view);
        filterController.resetFilter();

        setView(view.getPanel());
    }

    /**
     * Creates an instance of PageController if it does not exist yet
     * @return singleton instance of PageController
     */
    public static PageController getInstance() {
        if (instance == null) {
            instance = new PageController();
        }
        return instance;
    }
}
