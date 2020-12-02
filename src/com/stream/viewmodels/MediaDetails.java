package com.stream.viewmodels;

import com.stream.FileReader;
import com.stream.models.Media;


public class MediaDetails extends BaseViewModel {

    private Media media;
    private FileReader fr;
    private String sampleText;

    public MediaDetails(Media media) {
        this.media = media;
        fr = new FileReader();
        sampleText = fr.readSampleText();
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
