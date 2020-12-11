package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;


public class MediaDetailsViewModel {

    private Media media;
    private FileReader fileReader;
    private String sampleText;

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
}
