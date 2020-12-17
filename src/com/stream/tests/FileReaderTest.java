package com.stream.tests;

import com.stream.FileReader;
import com.stream.models.Media;
import com.stream.models.MediaType;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertThat;


public class FileReaderTest {

    private FileReader fileReader;

    @Before
    public void before() {
        fileReader = new FileReader();
    }

    @After
    public void after() {
        fileReader = null;
    }

    @Test
    public void readALlMedia_correctSize() {
        List<Media> mediaList = fileReader.readAllMedia();
        assertThat(mediaList.size(), CoreMatchers.is(200));
    }

    @Test
    public void readALlMovies_correctSize() {
        List<Media> mediaList = fileReader.readMedia(MediaType.MOVIE);
        assertThat(mediaList.size(), CoreMatchers.is(100));
    }

    @Test
    public void readALlSeries_correctSize() {
        List<Media> mediaList = fileReader.readMedia(MediaType.SERIES);
        assertThat(mediaList.size(), CoreMatchers.is(100));
    }
}
