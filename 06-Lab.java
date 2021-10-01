import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab6 {

    public static char getLetterFromGrade(int grade) {
        char letter;
        if (grade >= 90) {
            letter = 'A';
        } else if (grade >= 80) {
            letter = 'B';
        } else if (grade >= 70) {
            letter = 'C';
        } else if (grade >= 60) {
            letter = 'D';
        } else {
            letter = 'F';
        }

        return letter;
    }

    public static void main(String[] args) {

        Scanner keyboardReader = new Scanner(System.in);

        System.out.printf("Enter a filename: ");
        System.out.printf("Enter an output filename: ");
        String inputFilename = keyboardReader.next();
        String outputFilename = keyboardReader.next();

        try {
            File inputFileObject = new File(inputFilename);
            Scanner fileReader = new Scanner(inputFileObject);

            File outputFileObject = new File(outputFilename);
            PrintWriter printWriter = new PrintWriter(outputFileObject);

            int numberOfStudents = 0;
            int classTotal = 0;
            while (fileReader.hasNextLine()) {
                numberOfStudents = numberOfStudents + 1;
                String data = fileReader.nextLine();

                String[] split = data.split("\\s+");

                // String name = String.valueOf(split[0]);
                Integer grade = Integer.valueOf(split[1]);
                classTotal = classTotal + grade;

                printWriter.println(getLetterFromGrade(grade));
            }
            printWriter.close();
            fileReader.close();
            System.out.printf("Number of students: %s\n", numberOfStudents);
            System.out.printf("Class Average: %.2f",
                ((double) classTotal / (double) numberOfStudents));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}