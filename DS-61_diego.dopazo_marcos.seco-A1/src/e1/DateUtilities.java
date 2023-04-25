package e1;

public class DateUtilities {
    /**
     * Indicates whether a year is a leap year . A leap year is divisible by 4,
     * unless it is divisible by 100 , in which case it must be divisible by 400
     * in order to be considered a leap year (e.g., 1900 is not a leap year ,
     * but 2000 is) = > See the JUnit seminar for an example .
     * @param year the given year
     * @return True if the given year is a leap year , false otherwise .
     */
    public static boolean isLeap(int year){
        if(year % 4 == 0){
            if(year % 100 == 0 && year % 400 != 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Indicates the number of days of a given month . As the number of days in
     * the month of February depends on the year , it is also necessary to pass
     * the year as an argument .
     * @param month The given month
     * @param year The given year
     * @return The number of days of that month in that year .
     * @throws IllegalArgumentException if the month is not valid .
     */

    public static int numberOfDays(int month, int year){
        int [] thirtyDays = {4,6,9,11};
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month");
        }else{
            if(month == 2){
                if(isLeap(year)){
                    return 29;
                }else{
                    return 28;
                }
            }else{
                for(int m : thirtyDays){
                    if(m == month){
                        return 30;
                    }
                }
                return 31;
            }
        }
    }

    /*Auxiliary function to obtain the month number of a string*/
    public static int monthNumber(String month){

        int index = 1;
        String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

        for(String n: months){
            if(n.equals(month)){
                break;
            }
            index ++;
        }
        if(index == 13){
            // returns -1 if it is not a valid month
            return -1;
        }else{
            return index;
        }
    }


    /**
     * The ISO date format is a standard format that displays the dates
     * starting with the year , followed by the month and the day , i.e. ,
     * "YYYY -MM -DD ". For example , in that format the text " July 28 , 2006"
     * would be represented as "2006 -07 -28".
     * The " convertToISO " method converts a date in the " Month DD , AAAA "
     * format to its ISO representation . For simplicity , let us assume that
     * the values are correctly formatted even if the date is invalid
     * (e.g., " February 31 , 2006" is correctly formatted but it is not a valid date )
     *
     * @param dateText Date in textual format ( USA style ).
     * @return A string with the given date in ISO format .
     */
    public static String convertToISODate(String dateText){
        String [] arr = dateText.split(" ");
        arr[1] = arr[1].replace(",", "");
        int index = monthNumber(arr[0]);

        String ISO;

        if(index >= 10)
            ISO = arr[2] + "-" + index + "-" + arr[1];
        else
            ISO = arr[2] + "-" + "0" + index + "-" + arr[1];
        return ISO;
    }


    /**
     * Given a String representing an ISO - formatted date , the methods checks
     * its validity . This includes checking for non - valid characters , erroneous
     * string lengths , and the validity of the date itself (i.e. , checking the
     * number of days of the month ).
     * @param ISODate A date in ISO format
     * @return True if the ISO - formatted date is a valid date , False otherwise .
     */
    public static boolean checkISODate(String ISODate){
        //we convert the string to an array of strings
        String [] arr = ISODate.split("-");


        try {
            //we convert the strings into numbers
            int year_ISO = Integer.parseInt(arr[0]);
            int month_ISO = Integer.parseInt(arr[1]);
            int days_ISO = Integer.parseInt(arr[2]);

            //we obtain the maximum number of days that this month can have
            int number_of_days = numberOfDays(month_ISO, year_ISO);

            //we check if an invalid number of days was passed
            if(days_ISO <= 0 || number_of_days < days_ISO){
                return false;
            }//we check if an invalid month was passed
            else if(month_ISO > 12 || month_ISO <= 0){
                return false;
            }

        }//we catch all the exceptions
        catch(IllegalArgumentException e){
            return false;
        }

        return true;
    }
}
