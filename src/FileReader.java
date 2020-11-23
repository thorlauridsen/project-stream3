import models.Media;
import models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {

    public FileReader() throws IOException {

        String file = "src/film.txt";
        Scanner sc = new Scanner(new File(file));

        List<Movie> list = new ArrayList<>();

        sc.useDelimiter("\\s*;\\s*");
        sc.useLocale(Locale.ENGLISH);

        while (sc.hasNext()) {
            String title = sc.next();
            int year = sc.nextInt();
            String categories = sc.next();
            double rating = sc.nextDouble();
            System.out.println(title + " " + year + " " + categories + " " + rating);
        }
    }

    public List<Movie> readMovies() throws FileNotFoundException {

        String path = "film.txt";
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("film.txt"));

        List<Movie> list = new ArrayList<>();

        sc.useDelimiter("\\s*;\\s*");
        sc.useLocale(Locale.ENGLISH);

        while (sc.hasNext()) {
            String title = sc.next();
            int year = sc.nextInt();
            String categories = sc.next();
            double rating = sc.nextDouble();
            System.out.println(title + " " + year + " " + categories + " " + rating);
        }
        return list;
    }
}
