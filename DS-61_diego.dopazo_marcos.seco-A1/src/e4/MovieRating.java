
package e4;

public enum MovieRating {
    AWFUL (0),
    BAD (2),
    MEDIOCRE (4),
    GOOD (6),
    EXCELLENT (8),
    MASTERPIECE (10),
    NOT_RATED (-1);

    private final int value;

    MovieRating(int value){
        this.value = value;
    }

    /**Gets the numeric value*/
    int getNumericRating(){
        return value;
    }

    /**This method compares the rating of a movie with another one and returns true if the
     *first one has a better ratting
     */
    boolean isBetterThan(MovieRating a){
        return this.getNumericRating() > a.getNumericRating();
    }

}
