package com.stream.controllers;

import com.stream.exceptions.SearchException;
import com.stream.listeners.ClickMediaListener;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterController extends BaseController {

    private static FilterController instance;

    private List<Media> filteredList;
    private List<Media> searchList;
    private List<Media> mediaCategoryList;
    private List<String> mediaTypes;
    private String searchQuery;
    private List<String> selectedCategoryList;

    private CatalogViewModel viewModel;
    private CatalogView view;

    public FilterController() {
        filteredList = new ArrayList<>();
        searchList = new ArrayList<>();
        mediaCategoryList = new ArrayList<>();
        mediaTypes = Arrays.asList("Movie", "Series");
    }

    public void setCatalog(CatalogViewModel viewModel, CatalogView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    /**
     * Resets searchList and mediaCategoryList
     * Then it populates the two list with the list of all media
     */
    public void resetFilter() {
        searchList.clear();
        mediaCategoryList.clear();

        searchList.addAll(viewModel.getMediaList());
        mediaCategoryList.addAll(viewModel.getMediaList());
    }

    public List<String> getMediaTypes() {
        return mediaTypes;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
        List<Media> mediaList = viewModel.getMediaList();
        List<Media> newList = new ArrayList<>();

        for (Media media : mediaList) {
            String title = media.getTitle().toLowerCase();
            if (title.contains(searchQuery)){
                newList.add(media);
            }
        }
        searchList.clear();
        searchList.addAll(newList);
    }

    public void setMediaCategoryList(List<String> selectedCategoryList) {
        this.selectedCategoryList = selectedCategoryList;
        ArrayList<Media> list = new ArrayList<>();
        List<Media> mediaList = viewModel.getMediaList();

        for (Media media : mediaList) {
            List<String> categories = media.getCategories();
            if (categories.containsAll(selectedCategoryList)) {
                list.add(media);
            }
        }
        if (selectedCategoryList.size() == 0) {
            list.clear();
            list.addAll(mediaList);
        }
        mediaCategoryList.clear();
        mediaCategoryList.addAll(list);
    }

    /**
     * Creates filterList from the search input and the selected categories
     * Contains all elements that searchList and mediaCategoryList have in common
     * Then the method populates the view using pageController
     */
    public void updateFilterView() throws SearchException {
        filteredList.clear();

        filteredList.addAll(searchList);
        filteredList.retainAll(mediaCategoryList);

        view.clearMedia();

        for (Media media : filteredList) {
            MediaPanel mediaPanel = new MediaPanel(media, new ClickMediaListener(media));
            view.addMedia(mediaPanel.getPanel());
        }
        view.updateView(filteredList.size());
        pageController.setView(view.getPanel());

        if (filteredList.size() == 0) {
            UserManager userManager = UserManager.getInstance();
            User user = userManager.getCurrentUser();
            boolean myListToggled = user.isMyListToggled();

            throw new SearchException(this.searchQuery, this.selectedCategoryList, myListToggled);
        }
    }

    /**
     * Creates an instance of FilterController if it does not exist yet
     * @return singleton instance of FilterController
     */
    public static FilterController getInstance() {
        if (instance == null) {
            instance = new FilterController();
        }
        return instance;
    }
}