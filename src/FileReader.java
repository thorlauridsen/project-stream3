import models.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {

    public FileReader() {

    }

    public List<Movie> readMovies() {

        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("res/data/film.txt"));

        List<Movie> list = new ArrayList<>();

        sc.useDelimiter("\\s*;\\s*");
        sc.useLocale(Locale.FRENCH);

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
