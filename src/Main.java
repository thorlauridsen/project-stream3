import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hej igen");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Streaming service");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //frame.setVisible(true);

        FileReader fr = new FileReader();
    }
}
