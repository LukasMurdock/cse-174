import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4Walkthrough {

    public static double calculateFreeTime(double hoursOfSleep,
                                           int numberOfClasses) {
        double freeTime = 120 - (hoursOfSleep * 5 + numberOfClasses * 8.72);
        return freeTime;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboardReader = new Scanner(System.in);

        System.out.printf("Enter your first and last name: ");
        String firstName = keyboardReader.next();
        String lastName = keyboardReader.next();
        String fullName = firstName + " " + lastName;

        System.out.printf("Enter your time spent sleeping each night (in "
            + "hours): ");
        double hoursOfSleep = keyboardReader.nextDouble();

        System.out.printf("Enter your number of classes: ");
        int numberOfClasses = keyboardReader.nextInt();

        double freeTime = calculateFreeTime(hoursOfSleep, numberOfClasses);

        String topBorder = " " + "_".repeat(44) + " \n";
        String middleBorder = "|" + ".".repeat(44) + "|\n";
        String bottomBorder = " " + "-".repeat(44) + " \n";

        System.out.printf(topBorder);
        System.out.printf(
            "|%-20s|%-12s|%-10s|\n", "Name", "Num Classes", "Free Time"
        );
        System.out.printf(middleBorder);

        // %s String
        // %d Integer (decimal)
        // %f Double or Float
        System.out.printf(
            "|%-20s|%-12d|%-10.1f|\n", fullName, numberOfClasses, freeTime
        );
        System.out.printf(bottomBorder);

        System.out.printf("Enter an input filename: ");
        String inputFileName = keyboardReader.next();

        File fileObject = new File(inputFileName);
        Scanner fileReader = new Scanner(fileObject);

        String fileFirstName = fileReader.next();
        String fileLastName = fileReader.next();
        String fileFullName = fileFirstName + " " + fileLastName;

        double fileHoursOfSleep = fileReader.nextDouble();
        int fileNumberOfClasses = fileReader.nextInt();
        double fileFreeTime = calculateFreeTime(
            fileHoursOfSleep,
            fileNumberOfClasses
        );

        System.out.printf("Enter an output filename: ");
        String outputFileName = keyboardReader.next();

        File outputFileObject = new File(outputFileName);
        PrintWriter fileWriter = new PrintWriter(outputFileObject);

        fileWriter.printf(topBorder);
        fileWriter.printf(
            "|%-20s|%-12s|%-10s|\n", "Name", "Num Classes", "Free " + "Time"
        );
        fileWriter.printf(middleBorder);

        fileWriter.printf(
            "|%-20s|%-12d|%-10.1f|\n", fullName, numberOfClasses, freeTime
        );
        fileWriter.printf(middleBorder);
        fileWriter.printf(
            "|%-20s|%-12d|%-10.1f|\n", fileFullName, fileNumberOfClasses,
            fileFreeTime
        );
        fileWriter.printf(bottomBorder);
        fileWriter.close();
    }
}