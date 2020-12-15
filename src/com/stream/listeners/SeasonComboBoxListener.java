package com.stream.listeners;

import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeasonComboBoxListener implements ActionListener {

    private MediaDetailsView view;
    private MediaDetailsViewModel viewModel;

    public SeasonComboBoxListener(MediaDetailsView view, MediaDetailsViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JComboBox seasonComboBox = (JComboBox) e.getSource();
        int selectedSeason = (int) seasonComboBox.getSelectedItem();
        viewModel.setSelectedSeason(selectedSeason);

    }
}
