package e2;

import java.util.Arrays;

public class SocialDistance {

    public static int neighbors(int x, int y, char [][] auxmatrix){
        int index = 0;

        /*If one of the elements that is around the element or the element has someone seated in it
         * then the index increments by 1. The try and catch avoids the errors when tryig to calculate
         * the non-existing elements around corner or side elements. */
        for(int i = (x - 1); i <= (x + 1); i++){
            for(int j = (y - 1); j <= (y + 1); j++){
                try{
                    if(auxmatrix[i][j] == '#' ){
                        index++;
                    }
                }catch(Exception ignore){

                }
            }
        }
        /*To not count the element itself we subtract one from the index count */
        return index - 1;
    }


    public static char [][] seatingPeople ( char [][] layout ) {

        /*If the layout is NULL, throwIllegalArgumentException */
        if(layout == null){
            throw new IllegalArgumentException();
        }

        int rows = layout.length;
        int col = layout[0].length;

        /*This loop checks if the layout is a valid layout*/
        for (int i = 0; i < rows; i++) {
            if(col != layout[i].length){
                throw new IllegalArgumentException();
            }
        }

        /* To seat and check if the student can sit where they have, an auxiliar matrix
         * is created to compare with the layout.*/
        char [][]auxmatrix = new char [rows][col];

        /*First, the students sit down*/
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< col; j++){
                if(layout[i][j] == 'A'){
                    layout[i][j] = '#';
                }
            }
        }

        /*A loop compares the current cycle layout with the previous cycle layout by using an auxiliar
        * matrix. If the current cycle layout is the same as the previous one then the students cannot move
        * and the final layout is returned. */

        do{
            /*The layout is copied in the auxiliar matrix*/
            for(int i = 0; i < rows; i++){
                for(int j = 0; j< col; j++){
                    auxmatrix[i][j] = layout[i][j];
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < col; j++){
                    if( auxmatrix[i][j] =='A'){
                        /*If no one is sat down in the 8 adjacent seats then the student sits down*/
                        if(neighbors(i,j,auxmatrix) < 0){
                            layout[i][j] = '#';
                        }
                    }else if(auxmatrix[i][j] =='#'){
                        /*If four or more of the adjacent sits are occupied the student leaves the spot*/
                        if(neighbors(i,j,auxmatrix) >= 4){
                            layout[i][j] = 'A';
                        }
                    }else if(auxmatrix[i][j] != '.'){
                        /*If there is an element in the matrix tha is not ['A', '.', '#'] then an IllegalArgumentException
                        * is thrown*/
                        throw new IllegalArgumentException();
                    }

                }
            }
        }while(!Arrays.deepEquals(layout, auxmatrix));

        return layout;
    }
}
