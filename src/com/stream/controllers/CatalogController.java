package com.stream.controllers;

import com.stream.listeners.*;
import com.stream.models.MediaPanel;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.models.Media;
import com.stream.views.CatalogView;
import java.util.List;


public class CatalogController extends BaseController {

    private CatalogViewModel viewModel;
    private CatalogView view;

    public CatalogController(CatalogViewModel viewModel, CatalogView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    /**
     * Populates and displays the view using pageController
     */
    public void updateView() {
        List<Media> mediaList = viewModel.getMediaList();

        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        view.updateView(mediaList.size());
        view.addCategoryPanel(viewModel.getCategories().size());

        addCategories();
        view.addHomeButton(new ClearListener());
        view.addSearchField(new SearchListener(view, viewModel));
        view.addClearButton(new ClearListener());
        view.addSearchButton(new SearchListener(view, viewModel));
        view.addMyListButton(new ShowMyListListener(view, viewModel));
        view.addLogoutButton(new LogoutListener());
        view.addUserLabel(userManager.getCurrentUser().getName());

        for (Media media : mediaList) {
            MediaPanel mediaPanel = new MediaPanel(media, new ClickMediaListener(media));
            view.addMedia(mediaPanel.getPanel());
        }
        pageController.setView(view.getPanel());
    }

    /**
     * Adds all category buttons to the view with CategoryListener
     */
    public void addCategories() {
        for (String category : viewModel.getCategories()) {
            view.addCategoryButton(category, new CategoryListener(view, viewModel));
        }
    }
}