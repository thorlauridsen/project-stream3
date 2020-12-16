package com.stream.exceptions;

import java.util.List;

public class SearchException extends Exception {

    private String searchQuery;
    private List<String> selectedCategoryList;

    public SearchException(String searchQuery, List<String> selectedCategoryList) {
        super();
        this.searchQuery = searchQuery;
        this.selectedCategoryList = selectedCategoryList;
    }

    @Override
    public String getMessage() {
        String message = "Your search for:";
        if (searchQuery != null && !searchQuery.isEmpty()) {
            message += "\n - " + searchQuery;
        }
        for (String category : selectedCategoryList) {
            message += "\n - " + category;
        }
        message += "\nReturned no results!";
        return message;
    }
}
