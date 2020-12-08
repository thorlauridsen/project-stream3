package com.stream.listeners;

import com.stream.controllers.PageController;
import com.stream.models.Media;
import com.stream.models.MediaPanel;
import com.stream.viewmodels.Catalog;
import com.stream.views.CatalogView;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class CategoryButtonListener extends BaseListener{

    private CatalogView cv;
    private Catalog c;
    private ArrayList<String> selectedCategoryList = new ArrayList<>();
    private boolean somethingChecked;

    public CategoryButtonListener(CatalogView cv, Catalog c) {
        super(cv);
        this.cv = cv;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cv.clearMedia();
        selectedCategoryList.clear();

        List<Media> medialist = c.getMediaList();
        List<Media> filteredList = new ArrayList<>();

        somethingChecked = false;

        for(JCheckBox box : cv.getCategoryBoxList()) {
            if(box.isSelected()) {
                selectedCategoryList.add(box.getText());
                somethingChecked = true;
            }
        }



            if(selectedCategoryList.size() == 1) {
                for (Media m : medialist) {
                    for (String s : m.getCategories()) {
                        if (s.equals(selectedCategoryList.get(0))) {
                            filteredList.add(m);
                        }
                    }
                }
            }

            if(selectedCategoryList.size() == 2) {
                for (Media m : medialist) {
                   if (m.getCategories().contains(selectedCategoryList.get(0)) &&
                       m.getCategories().contains(selectedCategoryList.get(1))) {
                       filteredList.add(m);
                   }
                }
           }

            if(selectedCategoryList.size() == 3) {
                for (Media m : medialist) {
                    if (m.getCategories().equals(selectedCategoryList)) {
                        filteredList.add(m);
                    }
                }
            }

        if(somethingChecked) {
            for (Media media : filteredList) {
                MediaPanel mp = new MediaPanel(media, new ClickMediaListener(cv, media));
                cv.addMedia(mp.getPanel());
            }
            cv.updateView(filteredList.size());

            PageController pageController = PageController.getInstance();
            pageController.setView(cv.getPanel());
        } else if (!somethingChecked){
            for (Media media : medialist) {
                MediaPanel mp = new MediaPanel(media, new ClickMediaListener(cv, media));
                cv.addMedia(mp.getPanel());
            }
            cv.updateView(medialist.size());

            PageController pageController = PageController.getInstance();
            pageController.setView(cv.getPanel());
        }
    }


}