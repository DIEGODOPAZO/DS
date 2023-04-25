package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Movie {
    /**
     * Creates a new movie with the list of ratings empty .
     * @param title Movie title .
     */
    private final String title;
    private final List<MovieRating> ratings=new ArrayList<MovieRating>();

    public Movie ( String title ) {
        this.title = title;
    }


    /**
     * Returns the movie title
     * @return the movie title .
     */

    public String getTitle () {

        return title;
    }



    /**
     * Inserts a new movieRating .
     * It is allowed to insert NOT_RATED .
     * @param movieRating MovieRating to be inserted .
     */
    public void insertRating ( MovieRating movieRating ) {
        ratings.add(movieRating);
    }
    /**
     * Check if this movie has any rating .
     * @return true if and only if there is a valuation other than NOT_RATED .
     */
    private boolean isRated () {

        return ratings.size() > 0;
    }
    /**
     * Gets the highest rating for this movie .
     * @return maximum rating ; or NOT_RATED if there are no ratings .
     */
    public MovieRating maximumRating () {
        int maxRating = -1;
        int maxtRatingPosition = 0;
        int x;

        /*This for loop iterates through the list and compares the actual maximum rating with the rating of the
        * element at the current position, if that elements it has a greater rating its rates becomes the
        * masRating and maxtRatingPosition becomes that position index */
        for(int i = 0; i < ratings.size(); i++){
            x = ratings.get(i).getNumericRating();
            if (maxRating < x) {
                maxRating = x;
                maxtRatingPosition = i;
            }
        }
        /*If there are no ratings*/
        if(maxRating == -1)
            return MovieRating.NOT_RATED;
        else
            /*returns the rating at the position maxRatingPosition*/
            return ratings.get(maxtRatingPosition);
    }
    /**
     * Calculate the numerical average rating of this movie .
     * NOT_RATED values are not considered .
     * @return Numerical average rating of this movie .
     * @throws java . util . NoSuchElementException if there are no valid ratings .
     */
    public double averageRating () {
        int additionOfRates= 0;
        int numberOfRates = 0;

        /*This for loop iterates through the list of ratings, if the rating type is 'NOT_RATED' it does nothing
        * and goes to the next iteration of the loop, else it converts the rating to a number, adds it to the sum
        * of ratings and updates a counter which counts the number of ratings.*/

        for(MovieRating i: ratings){
            if(i == MovieRating.NOT_RATED)
                continue;
            additionOfRates += i.getNumericRating();
            numberOfRates++;
        }
        /*throws an exception if there are no ratings*/
        if (numberOfRates == 0)
            throw new NoSuchElementException();

        return  (double)(additionOfRates / numberOfRates);
    }


}

