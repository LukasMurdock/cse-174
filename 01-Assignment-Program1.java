/**
 * --------
 * Program1.java
 */
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int GET_AREA_CODE_DIGITS = 10000000;
        final int GET_CENTER_DIGITS = 10000;

        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");
        final long PHONE_NUM = in.nextLong();

        int areaCode = (int) (PHONE_NUM / GET_AREA_CODE_DIGITS);
        int centralOfficeCode = (int) ((PHONE_NUM % GET_AREA_CODE_DIGITS) / GET_CENTER_DIGITS);
        int stationNumber = (int) ((PHONE_NUM % GET_AREA_CODE_DIGITS) % GET_CENTER_DIGITS);

        System.out.println("(" + areaCode + ") " + centralOfficeCode + " - " + stationNumber);

        char firstEncrypt = (char) ((stationNumber / 100) + 33);
        char secondEncrypt = (char) ((stationNumber % 100) + 33);

        final int CONCAT_WITHOUT_CLASS = 1000;
        int thirdEncrypt = Integer.MAX_VALUE - ((areaCode * CONCAT_WITHOUT_CLASS + centralOfficeCode));

        System.out.println("(" + areaCode + ") " + centralOfficeCode + " - " + secondEncrypt + firstEncrypt);
        System.out.println(thirdEncrypt);
        System.out.println(secondEncrypt + "" + thirdEncrypt + "" + firstEncrypt);
    }
}