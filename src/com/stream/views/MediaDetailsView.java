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
    private JPanel seasonPanel;
    private GridBagConstraints constraints;
    private JComboBox seasonComboBox;
    private JComboBox episodeComboBox;
    private JTextArea episodeTextArea;
    private boolean playButtonPressed = false;

    public MediaDetailsView() {
        constraints = new GridBagConstraints();
        buttonPanel = new JPanel();
        playPanel = new JPanel();
        factPanel = new JPanel();
        seasonPanel = new JPanel();
        seasonComboBox = new JComboBox();
        episodeComboBox = new JComboBox();
        episodeTextArea = new JTextArea();
    }

    public void updateView() {
        contentPanel.setLayout(new GridLayout(2, 2, 30, 30));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        factPanel.setLayout(new GridLayout(4, 1));
        seasonPanel.setLayout(new GridLayout(2, 2, 20, 20));
        playPanel.setLayout(new GridLayout(2,1,10,10));

        factPanel.setBorder(BorderFactory.createEmptyBorder(0,40,10,40));
    }

    /**
     * Adds imagePanel to contentPanel
     * @param media Specific media
     */
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

    /**
     * Adds descriptionTextArea to contentPanel
     * @param media Specific media
     * @param sampleText Text to display
     */
    public void addDescriptionTextArea(Media media, String sampleText) {
        JTextArea descriptionTextArea = new JTextArea(sampleText);

        if (media instanceof Series) {
            descriptionTextArea.setText("Series Description: \n" + sampleText);
        } else {
            descriptionTextArea.setText("Movie Description: \n" + sampleText);
        }
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setFont(mediumFont);
        descriptionTextArea.setMargin(new Insets(20, 10, 10, 10));
        descriptionTextArea.setOpaque(false);
        descriptionTextArea.setEditable(false);

        contentPanel.add(descriptionTextArea);
    }

    /**
     * Adds factPanel to contentPanel
     * If media is a series, a seasonPanel is added as well
     * @param media Specific media
     */
    public void addFactPanel(Media media) {
        JLabel titleLabel = new JLabel(media.getTitle() + "   (" + media.getRating() + ")");
        titleLabel.setFont(mediumFont);
        factPanel.add(titleLabel);

        JLabel yearLabel = new JLabel(media.yearToString());
        yearLabel.setFont(mediumFont);
        factPanel.add(yearLabel);

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
        categoriesLabel.setFont(mediumFont);
        factPanel.add(categoriesLabel);

        if (media instanceof Series) {
            JLabel seasonLabel = new JLabel("Season");
            seasonLabel.setFont(mediumFont);
            seasonLabel.setForeground(Color.decode("#8bc10b"));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(10, 0, 0, 0);
            seasonPanel.add(seasonLabel);

            JLabel episodeLabel = new JLabel("Episode");
            episodeLabel.setFont(mediumFont);
            episodeLabel.setForeground(Color.decode("#8bc10b"));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.insets = new Insets(10, 120, 0, 0);
            seasonPanel.add(episodeLabel);
        }
        factPanel.add(seasonPanel);
        contentPanel.add(factPanel);
    }

    /**
     * Adds episodeTextArea to playPanel
     * @param media Specific media
     * @param sampleText Text to display
     * @param seasonNumber Season number
     * @param episodeNumber Episode number
     */
    public void addEpisodeTextArea(Media media, String sampleText, int seasonNumber, int episodeNumber) {
        if (media instanceof Series) {
            episodeTextArea.setText("Season: " + seasonNumber + " Episode: " + episodeNumber + "\n" + sampleText);

            episodeTextArea.setLineWrap(true);
            episodeTextArea.setWrapStyleWord(true);
            episodeTextArea.setFont(standardFont);
            episodeTextArea.setMargin(new Insets(20, 10, 10, 10));
            episodeTextArea.setOpaque(false);
            episodeTextArea.setEditable(false);

            playPanel.add(episodeTextArea);
        }
    }

    /**
     * Adds buttonPanel to playPanel which is added to contentPanel
     */
    public void addButtonPanel() {
        buttonPanel.setBorder(new EmptyBorder(10,100,10,100));
        buttonPanel.add(playButton);
        buttonPanel.add(watchListButton);

        playPanel.add(buttonPanel);
        contentPanel.add(playPanel);
    }

    /**
     * Adds the season JComboBox and the relevant listener
     * @param al ActionListener for the button
     * @param media Specific media
     */
    public void addSeasonComboBox(Media media, ActionListener al) {
        if (media instanceof Series) {
            Series series = (Series) media;
            for (Integer seasonNumber : series.getSeasonMap().keySet()) {
                seasonComboBox.addItem(seasonNumber);
            }
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(0, 5, 60, 0);

            seasonComboBox.addActionListener(al);

            seasonPanel.add(seasonComboBox);
        }
    }

    /**
     * Adds the episode JComboBox and the relevant listener
     * @param al ActionListener for the button
     * @param seasonNumber Season number
     * @param media Specific media
     */
    public void addEpisodeComboBox(Media media, ActionListener al, int seasonNumber) {
        if (media instanceof Series) {
            Series series = (Series) media;
            for (int j = 1; j <= series.getSeasonMap().get(seasonNumber); j++) {
                episodeComboBox.addItem(j);
            }
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 1;
            constraints.insets = new Insets(0, 125, 60, 0);

            episodeComboBox.addActionListener(al);

            seasonPanel.add(episodeComboBox);
        }
    }

    /**
     * Updates the episode JComboBox and the relevant listener
     * @param al ActionListener for the button
     * @param seasonNumber Season number
     * @param media Specific media
     */
    public void updateEpisodeComboBox(Media media, ActionListener al, int seasonNumber) {
        if (media instanceof Series) {
            Series series = (Series) media;
            episodeComboBox.removeAllItems();
            for (int j = 1; j <= series.getSeasonMap().get(seasonNumber); j++) {
                episodeComboBox.addItem(j);
            }
            episodeComboBox.addActionListener(al);
        }
    }

    /**
     * Updates the episode text area
     * @param sampleText Text to display
     * @param seasonNumber Season number
     * @param episodeNumber Episode number
     */
    public void updateEpisodeTextArea(String sampleText, int seasonNumber, int episodeNumber) {
        episodeTextArea.setText("Season: " + seasonNumber + " Episode: " + episodeNumber + "\n" + sampleText);
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
     * Updates the image of playButton
     * @param imagePath String path for image
     */
    public void updatePlayButton (String imagePath){
        playButton.draw(imagePath);
        playButtonPressed = !playButtonPressed;
    }

    public boolean getPlayButtonPressed() {
        return playButtonPressed;
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

