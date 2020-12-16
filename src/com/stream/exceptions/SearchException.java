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
        String message = "Your filter search for:";
        if (searchQuery != null && !searchQuery.isEmpty()) {
            message += "\n - " + searchQuery;
        }
        if (myListToggled) {
            message += "\n - My List";
        }
        if (selectedCategoryList != null) {
            for (String category : selectedCategoryList) {
                message += "\n - " + category;
            }
        }
        message += "\nReturned no results!";
        return message;
    }
}
