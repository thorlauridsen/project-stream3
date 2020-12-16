package com.stream.listeners;

import com.stream.models.Media;
import com.stream.viewmodels.MediaDetailsViewModel;
import com.stream.views.MediaDetailsView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SeasonComboBoxListener implements ActionListener {

    private Media media;
    private MediaDetailsView view;
    private MediaDetailsViewModel viewModel;

    public SeasonComboBoxListener(Media media, MediaDetailsView view, MediaDetailsViewModel viewModel) {
        this.media = media;
        this.view = view;
        this.viewModel = viewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox seasonComboBox = (JComboBox) e.getSource();
        int selectedSeason = (int) seasonComboBox.getSelectedItem();
        viewModel.setSelectedSeason(selectedSeason);
        view.updateEpisodeComboBox(media, new EpisodeComboBoxListener(view, viewModel), viewModel.getSelectedSeason());
    }
}
