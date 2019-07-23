import java.util.Scanner;

public class NumberInWords {


    /*initialization - strings to be used.*/

    private static String[] ones = new String[] {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
        };

    private static String[] tens = new String[] {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    private static String[] thousands =new String[] {"","thousand","million", "billion", "trillion"};

    private static String hundred = "hundred";
    private static String zero= "zero";

    private static String getNumberInWords(int current) {
        if(current == 0) {
            return zero;
        }
        int hundreds = current/100;
        int change = current%100;

        if(current < 20) {
            return ones[current];
        }
        else if (current < 100) {
            return tens[current/10]+" "+ones[current%10];
        }
        else {
            return ones[hundreds] +" "+ hundred + ((change>0) ? " and " + getNumberInWords(change) : "");
        }

    }

    public static String toWords(int number) {

        StringBuilder inWords = new StringBuilder("");

        int place =0;
        while (number > 0) {
            int current = number % 1000;
            String placeString = thousands[place];
            if(current > 0) {
                String currentInWords = getNumberInWords(current) + " "+placeString+" ";
                inWords.insert(0, currentInWords);
            }
            place++;
            number = number / 1000;
        }


        return inWords.toString();
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter a number");
            System.out.println(toWords(sc.nextInt()));

        } catch(Exception ex) {
            System.out.println(" err : "+ex.getMessage());
            throw ex;
        }
    }
}
