package com.stream.controllers;

import com.stream.listeners.ClickMediaListener;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.util.ArrayList;
import java.util.List;


public class FilterController extends BaseController {

    private static FilterController instance;

    private List<Media> searchList;
    private List<Media> selectedCategoryList;
    private List<Media> filteredList;

    private CatalogViewModel viewModel;
    private CatalogView view;

    public FilterController() {
        searchList = new ArrayList<>();
        selectedCategoryList = new ArrayList<>();
        filteredList = new ArrayList<>();
    }

    public void setCatalog(CatalogViewModel viewModel, CatalogView view) {
        this.viewModel = viewModel;
        this.view = view;

        searchList.clear();
        selectedCategoryList.clear();
        searchList.addAll(viewModel.getMediaList());
        selectedCategoryList.addAll(viewModel.getMediaList());
    }

    public void setSearchList(List<Media> list) {
        searchList.clear();
        searchList.addAll(list);
    }

    public void setSelectedCategoryList(List<Media> list) {
        selectedCategoryList.clear();
        selectedCategoryList.addAll(list);
    }

    public void updateFilterView() {
        filteredList.clear();
        filteredList.addAll(searchList);
        filteredList.retainAll(selectedCategoryList);

        view.clearMedia();

        for (Media media : filteredList) {
            MediaPanel mediaPanel = new MediaPanel(media, new ClickMediaListener(media));
            view.addMedia(mediaPanel.getPanel());
        }
        view.updateView(filteredList.size());

        pageController.setView(view.getPanel());
    }

    public static FilterController getInstance() {
        if (instance == null) {
            instance = new FilterController();
        }
        return instance;
    }
}
