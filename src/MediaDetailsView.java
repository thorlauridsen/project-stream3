import models.BaseView;
import models.Media;
import models.Movie;
import sun.misc.JavaLangAccess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class MediaDetailsView extends BaseView {

    private Media media;
    private MediaDetails md;

    public MediaDetailsView(MediaDetails md) {
        super();

        this.md = md;
    }



    public void addStuff (Media m, String sampleText){
        try {
            mainPanel.setLayout(new GridLayout(2, 2, 30, 30));



            frame.add(mainPanel);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);
            int resizedHeight = 2*pic.getHeight();
            int resizedWidth = 2*pic.getWidth();

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



            JLabel descriptionLabel = new JLabel("<html><p style='font-size:15px; font-family:Verdana'>" + sampleText + "</p></html>");


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

            String s = "";
            if(m instanceof Movie){
                Movie i = (Movie) m;
                s += "" + i.getYear();
            } else {
                s += "?";
            }

            JLabel yearLabel = new JLabel(s);
            yearLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(30,0,0,0);
            factPanel.add(yearLabel, c);

            String categories = "";
            int i = 1;
            for(String l : m.getCategories()){

                if(i == m.getCategories().size()){
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

            JPanel panel4 = new JPanel();
            panel4.setBackground(Color.yellow);

            mainPanel.add(imagePanel);
            mainPanel.add(descriptionLabel);
            mainPanel.add(factPanel);
            mainPanel.add(panel4);

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
}
