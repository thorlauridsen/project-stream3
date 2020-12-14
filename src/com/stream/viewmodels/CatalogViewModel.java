package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.controllers.FilterController;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;
import java.util.ArrayList;
import java.util.List;


public class CatalogViewModel {

    private FileReader fileReader;
    private List<Media> mediaList;
    private List<String> categories;

    public CatalogViewModel() {
        fileReader = new FileReader();
        categories = new ArrayList<>();
        mediaList = fileReader.readAllMedia();
        getAllCategories();
    }

    /**
     * Returns a list of media
     * If the user is a child it will only media with the Family category
     * If the user has toggled their watchlist it will return that list
     * @return list of media
     */
    public List<Media> getMediaList() {

        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.isMyListToggled()) {
                return user.getWatchList();
            }
            if (user.isChild()) {
                List<Media> familyList = new ArrayList<>();
                for (Media media : mediaList) {
                    if (media.getCategories().contains("Family")) {
                        familyList.add(media);
                    }
                }
                return familyList;
            }
        }
        return mediaList;
    }

    /**
     * Fills categories with every category from the list of all media
     * Fills categories with default media types
     * So users can select media types in the categoryPanel
     */
    public void getAllCategories() {
        FilterController filterController = FilterController.getInstance();
        for (String mediaType : filterController.getMediaTypes()) {
            categories.add(mediaType);
        }
        for (Media media : mediaList) {
            for (String category : media.getCategories()) {
                if (!categories.contains(category)) {
                    categories.add(category);
                }
            }
        }
    }

    public List<String> getCategories() {
        return categories;
    }
}
