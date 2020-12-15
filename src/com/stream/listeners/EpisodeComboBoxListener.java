package com.stream.listeners;

import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EpisodeComboBoxListener implements ActionListener {

    private MediaDetailsView view;
    private MediaDetailsViewModel viewModel;

    public EpisodeComboBoxListener(MediaDetailsView view, MediaDetailsViewModel viewModel) {
        this.view = view;
        this.viewModel = viewModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox episodeComboBox = (JComboBox) e.getSource();
        int selectedEpisode = (int) episodeComboBox.getSelectedItem();
        viewModel.setSelectedEpisode(selectedEpisode);

    }
}
