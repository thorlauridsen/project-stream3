package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;


public class MediaDetailsViewModel {

    private Media media;
    private FileReader fileReader;
    private String sampleText;
    private int selectedSeason;
    private int selectedEpisode;

    public MediaDetailsViewModel(Media media) {
        this.media = media;
        this.fileReader = new FileReader();
        this.sampleText = fileReader.readSampleText();
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }

    public String getSampleText(){
        return sampleText;
    }

    public void setSelectedSeason(int selectedSeason) {
        this.selectedSeason = selectedSeason;
    }

    public int getSelectedSeason() {
        return selectedSeason;
    }

    public void setSelectedEpisode(int selectedEpisode) {
        this.selectedEpisode = selectedEpisode;
    }

    public int getSelectedEpisode() {
        return selectedEpisode;
    }
}
