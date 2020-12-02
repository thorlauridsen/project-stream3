package com.stream.views;

import com.stream.models.BaseView;
import com.stream.models.Media;
import com.stream.viewmodels.MediaDetails;
import com.stream.models.Series;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class MediaDetailsView extends BaseView {

    private Media media;
    private MediaDetails md;

    public MediaDetailsView(MediaDetails md) {
        super();

        this.md = md;
    }

    public void updateToolBar() {
        toolBar.add(new JButton("Button 1"));
        toolBar.add(new JButton("Button 2"));
        toolBar.add(new JButton("Button 3"));
    }

    public void addStuff (Media m, String sampleText){
        try {
            contentPanel.setLayout(new GridLayout(2, 2, 30, 30));

            updateToolBar();

            mainPanel.add(contentPanel, BorderLayout.CENTER);

            frame.add(mainPanel);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);
            int resizedHeight = (int) (1.5 * pic.getHeight());
            int resizedWidth = (int) (1.5 * pic.getWidth());

            BufferedImage outputImage = new BufferedImage(resizedWidth, resizedHeight, pic.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(pic, 0, 0, resizedWidth, resizedHeight, null);
            g2d.dispose();

            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new BorderLayout());

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(resizedWidth, resizedHeight));

            imageLabel.setIcon(new ImageIcon(outputImage));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);

            JTextArea descriptionTextArea = new JTextArea(sampleText);
            descriptionTextArea.setLineWrap(true);
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setFont(new Font("Verdana", Font.PLAIN, 15));
            descriptionTextArea.setMargin(new Insets(20, 10, 10, 10));
            descriptionTextArea.setOpaque(false);

            JPanel factPanel = new JPanel();
            factPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel titleLabel = new JLabel(m.getTitle());
            titleLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.NORTHWEST;
            factPanel.add(titleLabel, c);

            JLabel ratingLabel = new JLabel("(" + m.getRating() + ")");
            ratingLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(0,20,0,0);
            factPanel.add(ratingLabel, c);

            JLabel yearLabel = new JLabel(m.yearToString());
            yearLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(30,0,0,0);
            factPanel.add(yearLabel, c);

            String categories = "";
            int i = 1;
            for (String l : m.getCategories()) {

                if (i == m.getCategories().size()) {
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

            if (m instanceof Series) {
                Series a = (Series) m;
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
            JButton playButton = new JButton("Play");
            JButton watchListButton = new JButton("<3");
            buttonPanel.add(playButton);
            buttonPanel.add(watchListButton);

            playPanel.add(episodeTextArea);
            playPanel.add(buttonPanel);

            contentPanel.add(imagePanel);
            contentPanel.add(descriptionTextArea);
            contentPanel.add(factPanel);
            contentPanel.add(playPanel);

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public void updateView() {

    }

    public void addBackButton(ActionListener al){
        JButton backButton = new JButton("<-");
        backButton.addActionListener(al);
    }
}
