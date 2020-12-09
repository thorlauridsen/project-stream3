package com.stream.listeners;

import com.stream.controllers.FilterController;
import com.stream.models.Media;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class SearchListener implements ActionListener {

    private CatalogView view;
    private CatalogViewModel viewModel;

    public SearchListener(CatalogView view, CatalogViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = view.getSearchQuery().toLowerCase();
        List<Media> mediaList = viewModel.getMediaList();
        List<Media> newList = new ArrayList<>();

        for (Media media : mediaList) {
            String title = media.getTitle().toLowerCase();
            if (title.contains(query)){
                newList.add(media);
            }
        }
        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(viewModel, view);
        filterController.setSearchList(newList);
        filterController.updateFilterView();
    }
}
