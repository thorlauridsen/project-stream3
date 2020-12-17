package com.stream.exceptions;

import java.util.List;


public class SearchException extends Exception {

    private String searchQuery;
    private boolean myListToggled;
    private List<String> selectedCategoryList;

    public SearchException(String searchQuery, List<String> selectedCategoryList, boolean myListToggled) {
        super();
        this.searchQuery = searchQuery;
        this.myListToggled = myListToggled;
        this.selectedCategoryList = selectedCategoryList;
    }

    @Override
    public String getMessage() {
        String msg = "Your filter search for:";
        if (searchQuery != null && !searchQuery.isEmpty()) {
            msg += "\n - " + searchQuery;
        }
        if (myListToggled) {
            msg += "\n - My List";
        }
        if (selectedCategoryList != null) {
            for (String category : selectedCategoryList) {
                msg += "\n - " + category;
            }
        }
        msg += "\nReturned no results!";
        return msg;
    }
}
