package com.stream.tests;

import com.stream.controllers.FilterController;
import com.stream.exceptions.LoginException;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;


public class FilterControllerTest {

    private FilterController filterController;
    private CatalogViewModel viewModel;
    private CatalogView view;
    private UserManager userManager;

    @Before
    public void before() {
        filterController = FilterController.getInstance();
        viewModel = new CatalogViewModel();
        view = new CatalogView();

        filterController.setCatalog(viewModel, view);
        filterController.resetFilter();

        userManager = UserManager.getInstance();
    }

    @After
    public void after() {
        filterController = null;
        viewModel = null;
        view = null;
        userManager.logout();
    }

    @Test
    public void setSearchQuery_displayCorrectAmountOfMedia() {
        filterController.setSearchQuery("star wars");
        filterController.updateFilterList();

        List<Media> filteredList = filterController.getFilteredList();

        assertThat(filteredList.size(), CoreMatchers.is(1));
    }

    @Test
    public void setSelectedCategoryList_displayCorrectAmountOfMedia() {
        List<String> selectedCategoryList = new ArrayList<>();
        selectedCategoryList.add("War");

        filterController.setMediaCategoryList(selectedCategoryList);
        filterController.updateFilterList();

        List<Media> filteredList = filterController.getFilteredList();

        assertThat(filteredList.size(), CoreMatchers.is(14));
    }

    @Test
    public void addToWatchList_enableWatchList_displayCorrectAmountOfMedia() throws LoginException {
        userManager.attemptLogin("Cronval", "1234");
        User user = userManager.getCurrentUser();

        Media media = viewModel.getMediaList().get(0);

        user.addToWatchlist(media);
        user.setMyListToggled(true);

        filterController.resetFilter();
        filterController.updateFilterList();

        List<Media> filteredList = filterController.getFilteredList();

        assertThat(filteredList.size(), CoreMatchers.is(1));
    }

    @Test
    public void setSearchQueryAndSelectedCategoryList_displayCorrectAmountOfMedia() {
        List<String> selectedCategoryList = new ArrayList<>();
        selectedCategoryList.add("Thriller");

        filterController.setMediaCategoryList(selectedCategoryList);
        filterController.updateFilterList();

        List<Media> filteredList = filterController.getFilteredList();

        assertThat(filteredList.size(), CoreMatchers.is(21));

        filterController.setMediaCategoryList(selectedCategoryList);
        filterController.setSearchQuery("Jaws");
        filterController.updateFilterList();

        filteredList = filterController.getFilteredList();

        assertThat(filteredList.size(), CoreMatchers.is(1));
    }
}
