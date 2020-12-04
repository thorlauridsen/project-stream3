package com.stream.views;

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

    public void updateToolBar() {
        //toolBar.add(new JButton("Button 1"));
    }

    public void updateView(Media media, String sampleText) {

        contentPanel.setLayout(new GridLayout(2, 2, 30, 30));

        updateToolBar();

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        InputStream is = getClass().getClassLoader().getResourceAsStream(media.getImagePath());

        try {
            BufferedImage pic = ImageIO.read(is);

            int resizedHeight = (int) (1.5 * pic.getHeight());
            int resizedWidth = (int) (1.5 * pic.getWidth());

            BufferedImage outputImage = new BufferedImage(resizedWidth, resizedHeight, pic.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(pic, 0, 0, resizedWidth, resizedHeight, null);
            g2d.dispose();

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(resizedWidth, resizedHeight));

            imageLabel.setIcon(new ImageIcon(outputImage));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JTextArea descriptionTextArea = new JTextArea(sampleText);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setFont(new Font("Verdana", Font.PLAIN, 15));
        descriptionTextArea.setMargin(new Insets(20, 10, 10, 10));
        descriptionTextArea.setOpaque(false);

        JPanel factPanel = new JPanel();
        factPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        factPanel.add(titleLabel, c);

        JLabel ratingLabel = new JLabel("(" + media.getRating() + ")");
        ratingLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,20,0,0);
        factPanel.add(ratingLabel, c);

        JLabel yearLabel = new JLabel(media.yearToString());
        yearLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(30,0,0,0);
        factPanel.add(yearLabel, c);

        String categories = "";
        int i = 1;
        for (String l : media.getCategories()) {

            if (i == media.getCategories().size()) {
                categories += l + "";
                i++;
            } else {
                categories += l + ", ";
                i++;
            }
        }

        JLabel categoriesLabel = new JLabel(categories);
        categoriesLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(30,0,0,0);
        factPanel.add(categoriesLabel, c);

        if (media instanceof Series) {
            Series a = (Series) media;
            JComboBox seasonComboBox = new JComboBox();
            for (Integer seasonNumber : a.getSeasonMap().keySet()){
                seasonComboBox.addItem(seasonNumber);
            }
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 1;
            c.insets = new Insets(30,0,0,0);

            factPanel.add(seasonComboBox, c);

            JComboBox episodeComboBox = new JComboBox();
            int selectedSeason = ((Integer) seasonComboBox.getSelectedItem());
            for (int j = 1 ; j<= a.getSeasonMap().get(1) ; j++) {
                episodeComboBox.addItem(j);
            }
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 1;
            c.insets = new Insets(30,80,0,0);

            factPanel.add(episodeComboBox, c);

        }
        JPanel playPanel = new JPanel();
        playPanel.setLayout(new GridLayout(2,1,10,10));

        JTextArea episodeTextArea = new JTextArea(sampleText);
        episodeTextArea.setLineWrap(true);
        episodeTextArea.setWrapStyleWord(true);
        episodeTextArea.setFont(new Font("Verdana", Font.PLAIN, 12));
        episodeTextArea.setMargin(new Insets(20, 10, 10, 10));
        episodeTextArea.setOpaque(false);

        playPanel.add(episodeTextArea);

        JPanel buttonPanel = new JPanel();
        JButton playButton = new JButton();

        try {
            InputStream is2 = getClass().getClassLoader().getResourceAsStream("res/images/playButton.jpg");
            BufferedImage pic = ImageIO.read(is2);
            playButton.setIcon(new ImageIcon(pic));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton watchListButton = new JButton();
        try {
            InputStream is3 = getClass().getClassLoader().getResourceAsStream("res/images/watchListButton.png");
            BufferedImage pic2 = ImageIO.read(is3);
            watchListButton.setIcon(new ImageIcon(pic2));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        buttonPanel.add(playButton);
        buttonPanel.add(watchListButton);
        buttonPanel.setBorder(new EmptyBorder(10,100,10,100));
        playPanel.add(episodeTextArea);
        playPanel.add(buttonPanel);

        contentPanel.add(imagePanel);
        contentPanel.add(descriptionTextArea);
        contentPanel.add(factPanel);
        contentPanel.add(playPanel);
    }

    public void addBackButton(ActionListener al){
        JButton backButton = new JButton("<-");
        backButton.addActionListener(al);
        toolBar.add(backButton);
    }
}
