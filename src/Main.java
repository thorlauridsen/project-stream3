import models.Media;
import models.Movie;
import models.Series;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Main {

    private JFrame frame;
    private JPanel mainPanel;

    public static void main(String[] args) {
        Main m = new Main();
        m.updateGUI();
    }

    public void updateGUI() {

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Streaming service");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        mainPanel = new JPanel();

        mainPanel.setPreferredSize(new Dimension(800, 5000));

        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setSize(new Dimension(800, 600));

        mainPanel.setLayout(new GridLayout(25, 4));

        frame.add(scroll);

        FileReader fr = new FileReader();
        List<Movie> movieList = fr.readMovies();
        List<Series> seriesList = fr.readSeries();

        for (Movie m : movieList) {
            addMedia(m);
        }
        frame.pack();
        frame.setVisible(true);
    }

    public void addMedia(Media m) {
        JLabel mediaLabel = new JLabel(m.getTitle());
        mediaLabel.setSize(new Dimension(140, 209));

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);
            //mediaLabel.setIcon(new ImageIcon(pic));
            //mediaLabel.setSize(new Dimension(140, 209));

            int desiredWidth = 140;
            int desiredHeight = 209;

            BufferedImage newImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics g = newImage.getGraphics();

            g.drawImage(pic, 0, 0, desiredWidth, desiredHeight, null);
            g.dispose();

            Icon newIcon = new ImageIcon(newImage);
            mediaLabel.setIcon(newIcon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel.add(mediaLabel);
    }
}
