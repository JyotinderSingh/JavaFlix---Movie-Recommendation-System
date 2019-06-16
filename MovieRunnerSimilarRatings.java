import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;


/**
 * Write a description of MovieRunnerSimilarRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {

    public void printAverageRatings(){

        int minimalRaters =35;
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        //String moviefile = "ratedmoviesfull.csv";
        //String ratingsfile = "data/ratings.csv";


        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize(moviefile);
        RaterDatabase.initialize(ratingsfile);


        System.out.println("Number of raters: "+ RaterDatabase.size());


        System.out.println("Number of movies rated: "+ MovieDatabase.size());

        ArrayList<Rating> avgRatingList = fr.getAverageRatings(minimalRaters);
        Collections.sort(avgRatingList);
        System.out.println("avgRatingList size " + avgRatingList.size());

        for(Rating r:avgRatingList){
            String Title = MovieDatabase.getTitle(r.getItem());
            System.out.println(r.getValue()+ " : " + Title);
        }

    }

    public void printAverageRatingsByYearAfterAndGenre(){
        int minimalRaters =25;
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        int yearCount = 1990;
        String selecGenre = "Drama";

        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);

        System.out.println("Number of raters: "+ RaterDatabase.size());
        System.out.println("read data for "+ MovieDatabase.size() + " movies");

        Filter yf = new YearAfterFilter(yearCount);
        Filter gf = new GenreFilter(selecGenre);
        AllFilters filtersList = new AllFilters();
        filtersList.addFilter(yf);
        filtersList.addFilter(gf);

        ArrayList<Rating> list = fr.getAverageRatingsByFilter(minimalRaters,filtersList);
        Collections.sort(list);
        System.out.println(list.size() + " movie " + "matched");

        for(Rating r:list){
            String Title = MovieDatabase.getTitle(r.getItem());
            String Genre = MovieDatabase.getGenres(r.getItem());
            int Year = MovieDatabase.getYear(r.getItem());

            System.out.println(r.getValue()+ " " + Year +" "+ Title );
            System.out.println("       "+ Genre);
        }

    }

    public ArrayList<Rating> printSimiliarRatings(double[] rates){
        int minimalRaters =4;
//        String id = "65";
        int numSimilarRaters=15;

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
        //TRYING MY BEST
        RaterDatabase.addRaterRating("1049", "3390572", rates[0]);
        RaterDatabase.addRaterRating("1049", "1201607", rates[1]);
        RaterDatabase.addRaterRating("1049", "1723121", rates[2]);
        RaterDatabase.addRaterRating("1049", "1343092", rates[3]);
        RaterDatabase.addRaterRating("1049", "1951261", rates[4]);
        RaterDatabase.addRaterRating("1049", "3678782", rates[5]);
        RaterDatabase.addRaterRating("1049", "2184339", rates[6]);
        RaterDatabase.addRaterRating("1049", "1454468", rates[7]);
        RaterDatabase.addRaterRating("1049", "2278388", rates[8]);
        RaterDatabase.addRaterRating("1049", "2752200", rates[9]);

//        System.out.println("----------------------------" + MovieDatabase.getTitle("1690953"));

        ArrayList<Rating> recommendations= fr.getSimilarRatings("1049",numSimilarRaters,minimalRaters);
        //Collections.sort(recommendations);
        System.out.println(recommendations.size() + " movie " + "matched");
        System.out.println("movieSimRatings: " + recommendations);

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
        return recommendations;

    }

    public void printSimiliarRatingsByGenre(){
        int minimalRaters =5;
        String id = "65";
        int numSimilarRaters=20;
        String selecGenre = "Action";

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);

        Filter gr = new GenreFilter(selecGenre);
        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter(id,numSimilarRaters,minimalRaters,gr);
        System.out.println(recommendations.size() + " movie " + "matched");
        //System.out.println("movieSimRatings: " + recommendations);

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
    }

    public void printSimiliarRatingsByDirector(){
        int minimalRaters =3;
        String id = "1034";
        int numSimilarRaters=10;
        String inputDirectors = "";

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);

        //TRYING MY BEST
        RaterDatabase.addRaterRating("1049", "3390572", 4);
        RaterDatabase.addRaterRating("1049", "1201607", 3);
        RaterDatabase.addRaterRating("1049", "1723121", 4);
        RaterDatabase.addRaterRating("1049", "1343092", 7);
        RaterDatabase.addRaterRating("1049", "1951261", 6);
        RaterDatabase.addRaterRating("1049", "3678782", 7);
        RaterDatabase.addRaterRating("1049", "2184339", 0);
        RaterDatabase.addRaterRating("1049", "1454468", 9);
        RaterDatabase.addRaterRating("1049", "2278388", 9);
        RaterDatabase.addRaterRating("1049", "2752200", 9);

        Filter dr = new DirectorsFilter(inputDirectors);
        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter("1049",numSimilarRaters,minimalRaters,dr);
        System.out.println(recommendations.size() + " movie " + "matched");

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
    }

    public void printSimiliarRatingsByGenreAndMinutes(){
        int minimalRaters =3;
        String id = "65";
        int numSimilarRaters=15;
        int minMinutes = 50;
        int maxMinutes = 200;
        String selecGenre = "Action";

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
        //TRYING MY BEST
        RaterDatabase.addRaterRating("1049", "3390572", 4);
        RaterDatabase.addRaterRating("1049", "1201607", 3);
        RaterDatabase.addRaterRating("1049", "1723121", 4);
        RaterDatabase.addRaterRating("1049", "1343092", 7);
        RaterDatabase.addRaterRating("1049", "1951261", 6);
        RaterDatabase.addRaterRating("1049", "3678782", 7);
        RaterDatabase.addRaterRating("1049", "2184339", 0);
        RaterDatabase.addRaterRating("1049", "1454468", 9);
        RaterDatabase.addRaterRating("1049", "2278388", 9);
        RaterDatabase.addRaterRating("1049", "2752200", 9);

        Filter gr = new GenreFilter(selecGenre);
        Filter mr = new MinutesFilter(minMinutes,maxMinutes);
        AllFilters filtersList = new AllFilters();
        filtersList.addFilter(mr);
        filtersList.addFilter(gr);

        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter("1049",numSimilarRaters,minimalRaters,filtersList);
        System.out.println(recommendations.size() + " movie " + "matched");

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
    }

    public void printAverageRatingsByYearAfterAndMinutes(){
        int minimalRaters =5;
        String id = "65";
        int numSimilarRaters=10;
        int minMinutes = 80;
        int maxMinutes = 100;
        int yearCount = 2000;

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);


        Filter yf = new YearAfterFilter(yearCount);
        Filter mr = new MinutesFilter(minMinutes,maxMinutes);
        AllFilters filtersList = new AllFilters();
        filtersList.addFilter(mr);
        filtersList.addFilter(yf);

        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter(id,numSimilarRaters,minimalRaters,filtersList);
        System.out.println(recommendations.size() + " movie " + "matched");

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
    }

    @SuppressWarnings("Duplicates")
    public ArrayList<Rating> printSimiliarRatingsByAllFilters(double[] rates, String selecGenre, String minMinutes, String maxMinutes, String dirs, String yearAfter ){
        int minimalRaters =3;
        String id = "65";
        int numSimilarRaters=15;
//        int minMinutes = 50;
//        int maxMinutes = 200;
//        String selecGenre = "Action";

        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize(ratingsfile);
        MovieDatabase.initialize(moviefile);
        //TRYING MY BEST
        RaterDatabase.addRaterRating("1049", "3390572", rates[0]);
        RaterDatabase.addRaterRating("1049", "1201607", rates[1]);
        RaterDatabase.addRaterRating("1049", "1723121", rates[2]);
        RaterDatabase.addRaterRating("1049", "1343092", rates[3]);
        RaterDatabase.addRaterRating("1049", "1951261", rates[4]);
        RaterDatabase.addRaterRating("1049", "3678782", rates[5]);
        RaterDatabase.addRaterRating("1049", "2184339", rates[6]);
        RaterDatabase.addRaterRating("1049", "1454468", rates[7]);
        RaterDatabase.addRaterRating("1049", "2278388", rates[8]);
        RaterDatabase.addRaterRating("1049", "2752200", rates[9]);


        AllFilters filtersList = new AllFilters();
        if(!selecGenre.isEmpty()) {
            Filter gr = new GenreFilter(selecGenre);
            filtersList.addFilter(gr);
        }
        try {
            int minM = Integer.parseInt(minMinutes);
            System.out.println("1");
            int maxM = Integer.parseInt(maxMinutes);
            System.out.println("2");
            Filter mr = new MinutesFilter(minM,maxM);
            System.out.println(3);
            filtersList.addFilter(mr);
            System.out.println("4");

        } catch(Exception e) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(e);
            System.out.println("------------------------------------------------------------------------------------");

        }
        if(!dirs.isEmpty()) {
            Filter dr = new DirectorsFilter(dirs);
            filtersList.addFilter(dr);
        }

        try {
            int yrAfter = Integer.parseInt(yearAfter);
            Filter yr = new YearAfterFilter(yrAfter);
            filtersList.addFilter(yr);

        } catch(Exception e) {

        }


        ArrayList<Rating> recommendations = fr.getSimilarRatingsByFilter("1049",numSimilarRaters,minimalRaters,filtersList);
        System.out.println(recommendations.size() + " movie " + "matched");

        for(Rating rating:recommendations){
            String movieTitle = MovieDatabase.getTitle((rating.getItem()));
            System.out.println(movieTitle+ " : " + rating.getValue());
        }
        return recommendations;
    }

//    public static void main(String[] args) {
//        MovieRunnerSimilarRatings ref = new MovieRunnerSimilarRatings();
//        ref.printSimiliarRatingsByGenreAndMinutes("65");
//        ref.printSimiliarRatings();
//        ref.printSimiliarRatingsByDirector();
//        ref.printSimiliarRatingsByGenreAndMinutes();
//    }

}