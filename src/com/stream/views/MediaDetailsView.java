package com.stream.views;

import com.stream.controllers.FilterController;
import com.stream.models.ImageButton;
import com.stream.models.Media;
import com.stream.models.Series;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class MediaDetailsView extends BaseView {

    private JPanel buttonPanel;
    private JPanel playPanel;
    private ImageButton playButton;
    private ImageButton watchListButton;
    private JPanel factPanel;
    private GridBagConstraints constraints;

    public MediaDetailsView() {
        constraints = new GridBagConstraints();
        buttonPanel = new JPanel();
        playPanel = new JPanel();
        factPanel = new JPanel();
    }

    //TODO: Cleanup this method by splitting it into smaller methods
    public void updateView() {
        contentPanel.setLayout(new GridLayout(2, 2, 30, 30));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        playPanel.setLayout(new GridLayout(2,1,10,10));
    }

    public void addImagePanel(Media media) {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        InputStream is = getClass().getClassLoader().getResourceAsStream(media.getImagePath());

        try {
            BufferedImage img = ImageIO.read(is);

            int resizedHeight = (int) (1.5 * img.getHeight());
            int resizedWidth = (int) (1.5 * img.getWidth());

            BufferedImage outputImage = new BufferedImage(resizedWidth, resizedHeight, img.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(img, 0, 0, resizedWidth, resizedHeight, null);
            g2d.dispose();

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(resizedWidth, resizedHeight));

            imageLabel.setIcon(new ImageIcon(outputImage));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }
        contentPanel.add(imagePanel);
    }

    public void addDescriptionTextArea(String sampleText) {
        JTextArea descriptionTextArea = new JTextArea(sampleText);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setFont(largeFont);
        descriptionTextArea.setMargin(new Insets(20, 10, 10, 10));
        descriptionTextArea.setOpaque(false);

        contentPanel.add(descriptionTextArea);
    }

    public void addFactPanel(Media media) {
        JPanel factPanel = new JPanel();
        factPanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        factPanel.add(titleLabel, constraints);

        JLabel ratingLabel = new JLabel("(" + media.getRating() + ")");
        ratingLabel.setFont(titleFont);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 20, 0, 0);
        factPanel.add(ratingLabel, constraints);

        JLabel yearLabel = new JLabel(media.yearToString());
        yearLabel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(30, 0, 0, 0);
        factPanel.add(yearLabel, constraints);

        FilterController filterController = FilterController.getInstance();

        String categories = "";
        int i = 1;
        for (String category : media.getCategories()) {

            if (!filterController.getMediaTypes().contains(category)) {

                if (i == (media.getCategories().size() - 1)) {
                    categories += category + "";
                } else {
                    categories += category + ", ";
                }
                i++;
            }
        }

        JLabel categoriesLabel = new JLabel(categories);
        categoriesLabel.setFont(titleFont);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(30, 0, 0, 0);
        factPanel.add(categoriesLabel, constraints);

        contentPanel.add(factPanel);

    }

    public void addEpisodeTextArea(Media media, String sampleText) {
        if (media instanceof Series) {
            JTextArea episodeTextArea = new JTextArea(sampleText);

            episodeTextArea.setLineWrap(true);
            episodeTextArea.setWrapStyleWord(true);
            episodeTextArea.setFont(standardFont);
            episodeTextArea.setMargin(new Insets(20, 10, 10, 10));
            episodeTextArea.setOpaque(false);

            playPanel.add(episodeTextArea);
        }
    }

    public void addButtonPanel() {
        buttonPanel.setBorder(new EmptyBorder(10,100,10,100));
        buttonPanel.add(playButton);
        buttonPanel.add(watchListButton);

        playPanel.add(buttonPanel);
        contentPanel.add(playPanel);
    }

    public void addSeasonComboBox(Media media, ActionListener al) {
        if (media instanceof Series) {
            Series series = (Series) media;
            JComboBox seasonComboBox = new JComboBox();
            for (Integer seasonNumber : series.getSeasonMap().keySet()) {
                seasonComboBox.addItem(seasonNumber);
            }
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(30, 0, 0, 0);

            seasonComboBox.addActionListener(al);

            factPanel.add(seasonComboBox, constraints);
        }
    }

    public void addEpisodeComboBox (Media media, ActionListener al,int seasonNumber){
        if (media instanceof Series) {
            Series series = (Series) media;
            JComboBox episodeComboBox = new JComboBox();
            for (int j = 1; j <= series.getSeasonMap().get(seasonNumber); j++) {
                episodeComboBox.addItem(j);
            }
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(30, 80, 0, 0);

            episodeComboBox.addActionListener(al);
            factPanel.add(episodeComboBox, constraints);
        }
    }

    /**
     * Initializes playButton
     * @param al ActionListener for the button
     * @param imagePath String path for image
     */
    public void updatePlayButton (ActionListener al, String imagePath){
        playButton = new ImageButton(al, imagePath);
    }

    /**
     * Initializes watchListButton
     * @param al ActionListener for the button
     * @param imagePath String path for image
     */
    public void addWatchListButton (ActionListener al, String imagePath){
        watchListButton = new ImageButton(al, imagePath);
    }

    /**
     * Updates the image of watchListButton
     * @param imagePath String path for image
     */
    public void updateWatchListButton (String imagePath){
        watchListButton.draw(imagePath);
    }

    /**
     * Adds backButton to toolBar
     * @param al ActionListener for the button
     * @param imagePath String path for image
     */
    public void addBackButton (ActionListener al, String imagePath){
        ImageButton backButton = new ImageButton(al, imagePath);
        toolBar.add(backButton);
    }
}

