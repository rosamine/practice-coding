import java.util.Scanner;

public class ISBNChecker {

    public static boolean checkISBN(String isbn) {
        if(isbn.length() != 13) {
            return false;
        }
        int total = 0;
        for(int i=0; i < 12; i++) {
            int currentDigit = isbn.charAt(i) - '0';
            total += currentDigit * ((i % 2 == 0) ? 1: 3);
        }
        int checkSum = (10 - (total % 10)) %10;

        return (checkSum == isbn.charAt(12)-'0');
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            String isbnString = input.replaceAll("[\\-\\s]", "");
            String outMessage = "The ISBN number you entered is " + (checkISBN(isbnString) ? "valid" : "not valid");
            System.out.println(outMessage);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
