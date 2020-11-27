import models.Media;
import models.Movie;
import models.Series;

import java.util.*;

public class FileReader {

    public FileReader() {

    }

    public List<Media> readMedia() {
        List<Media> mediaList = new ArrayList<>();

        for (Movie m : readMovies()) {
            mediaList.add(m);
        }
        for (Series m : readSeries()) {
            mediaList.add(m);
        }
        return mediaList;
    }

    public List<Movie> readMovies() {
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("res/data/film.txt"));

        List<Movie> movieList = new ArrayList<>();

        sc.useDelimiter("\\s*;\\s*");
        sc.useLocale(Locale.FRENCH);

        while (sc.hasNext()) {
            String title = sc.next();
            int year = sc.nextInt();
            String categoriesStr = sc.next();
            double rating = sc.nextDouble();

            List<String> categories = new ArrayList<>();

            for (String str : categoriesStr.split(",")) {
                str = str.trim();
                categories.add(str);
            }
            Movie m = new Movie(title, rating, categories, year);
            movieList.add(m);
        }
        return movieList;
    }

    public List<Series> readSeries() {
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("res/data/serier.txt"));

        List<Series> seriesList = new ArrayList<>();

        sc.useDelimiter("\\s*;\\s*");
        sc.useLocale(Locale.FRENCH);

        while (sc.hasNext()) {
            String title = sc.next();

            int yearFrom = -1;
            int yearTo = -1;

            String yearStr = sc.next().trim();

            if (yearStr.contains("-")) {
                String[] years = yearStr.split("-");

                Calendar cal = Calendar.getInstance();
                int yearToday = cal.get(Calendar.YEAR);

                if (years.length > 1) {
                    String firstYear = years[0];
                    String secondYear = years[1];

                    if (Utility.isInt(firstYear)) {
                        yearFrom = Integer.parseInt(firstYear);
                    }
                    if (Utility.isInt(secondYear)) {
                        yearTo = Integer.parseInt(secondYear);
                    }
                } else {
                    String firstYear = years[0].trim();

                    if (Utility.isInt(firstYear)) {
                        yearFrom = Integer.parseInt(firstYear);
                    }
                    yearTo = yearToday;
                }

            } else {
                if (Utility.isInt(yearStr)) {
                    yearFrom = Integer.parseInt(yearStr);
                }
                yearTo = yearFrom;
            }
            String categoriesStr = sc.next();
            double rating = sc.nextDouble();
            String seasonStr = sc.next();

            List<String> categories = new ArrayList<>();

            for (String str : categoriesStr.split(",")) {
                str = str.trim();
                categories.add(str);
            }
            HashMap<Integer, Integer> seasonMap = new HashMap<>();
            for (String str : seasonStr.split(",")) {
                str = str.trim();
                String[] seasonEpisodes = str.split("-");

                String seasonNumberStr = seasonEpisodes[0];
                String episodeAmountStr = seasonEpisodes[1];

                if (Utility.isInt(seasonNumberStr) && Utility.isInt(episodeAmountStr)) {

                    int seasonNumber = Integer.parseInt(seasonNumberStr);
                    int episodeAmount = Integer.parseInt(episodeAmountStr);

                    seasonMap.put(seasonNumber, episodeAmount);
                }
            }
            Series s = new Series(title, rating, categories, yearFrom, yearTo, seasonMap);
            seriesList.add(s);
        }
        return seriesList;
    }
}
