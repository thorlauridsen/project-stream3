package com.stream.controllers;

import com.stream.listeners.ClickMediaListener;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterController extends BaseController {

    private static FilterController instance;

    private List<Media> filteredList;
    private List<Media> searchList;
    private List<Media> selectedCategoryList;
    private List<String> mediaTypes;

    private CatalogViewModel viewModel;
    private CatalogView view;

    public FilterController() {
        filteredList = new ArrayList<>();
        searchList = new ArrayList<>();
        selectedCategoryList = new ArrayList<>();
        mediaTypes = Arrays.asList("Movie", "Series");
    }

    public void setCatalog(CatalogViewModel viewModel, CatalogView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    public void resetFilter() {
        searchList.clear();
        selectedCategoryList.clear();

        searchList.addAll(viewModel.getMediaList());
        selectedCategoryList.addAll(viewModel.getMediaList());
    }

    public List<String> getMediaTypes() {
        return mediaTypes;
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

        if (filteredList.size() == 0) {
            view.showSearchAlert();
        }
    }

    public static FilterController getInstance() {
        if (instance == null) {
            instance = new FilterController();
        }
        return instance;
    }
}
