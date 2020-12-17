package com.stream.tests;

import com.stream.models.Media;
import com.stream.viewmodels.CatalogViewModel;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertThat;


public class CatalogViewModelTest {

    private CatalogViewModel viewModel;

    @Before
    public void before() {
        viewModel = new CatalogViewModel();
    }

    @After
    public void after() {
        viewModel = null;
    }

    @Test
    public void getCategories_correctSize() {
        List<String> categories = viewModel.getCategories();
        assertThat(categories.size(), CoreMatchers.is(25));
    }

    @Test
    public void getMediaList_correctSize() {
        List<Media> mediaList = viewModel.getMediaList();
        assertThat(mediaList.size(), CoreMatchers.is(200));
    }
}
