package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;
import com.stream.models.User;
import com.stream.models.UserManager;

import java.util.ArrayList;
import java.util.List;


public class CatalogViewModel extends BaseViewModel {

    private FileReader fr;
    private List<Media> mediaList;
    private List<String> categories;

    public CatalogViewModel() {
        fr = new FileReader();
        categories = new ArrayList<>();
        mediaList = fr.readAllMedia();
        getAllCategories();
    }

    public List<Media> getMediaList() {

        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();

        if (user != null) {
            if (user.isMyListToggled()) {
                return user.getWatchList();
            }
            if (user.isChild()) {
                List<Media> familyList = new ArrayList<>();
                for (Media m : mediaList) {
                    if (m.getCategories().contains("Family")) {
                        familyList.add(m);
                    }
                }
                return familyList;
            }
        }
        return mediaList;
    }

    public void getAllCategories() {
        for(Media m : mediaList) {
            for (String s : m.getCategories()) {
                if (!categories.contains(s)) {
                    categories.add(s);
                }
            }
        }
    }

    public List<String> getUniqueCategories() {
        return categories;
    }
}
