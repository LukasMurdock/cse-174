import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            menu();
            try {
                option = in.nextInt();
            } catch (InputMismatchException err) {
                in.next();
                option = 0;
            }
            switch (option) {
                case 1:
                    System.out.printf("Enter a single binary code: ");
                    char letter = getLetter(in.next());
                    System.out.printf("The letter is: %s\n", letter);
                    break;
                case 2:
                    System.out.printf("Enter binary codes: ");
                    String word = getWord(in.next());
                    System.out.printf("The word is: %s\n", word);
                    break;
                case 3:
                    System.out.printf("End!\n");
                    break;
                default:
                    System.out.printf("Invalid Input!\n");
            }
        } while (option != 3);
    }

    private static void menu() {
        System.out.printf("\n**Binary Code Translator v 1.0**\n");
        System.out.printf("1. Translate a binary code into a letter\n");
        System.out.printf("2. Translate binary codes into a word\n");
        System.out.printf("3. Exit\nEnter a number [1-3]: ");
    }

    /**
     * Given a single binary character as a string, returns the character code.
     *
     * @param binaryCharacter a string holding a single binary character
     * @return a char with the converted binary character.
     */
    public static char getLetter(String binaryCharacter) {
        // Binary to decimal, decimal to ascii
        char character = (char) Integer.parseInt(binaryCharacter, 2);
        return character;
    }

    /**
     * Given a string of binary codes, returns the converted string.
     *
     * @param binaryString a string of binary codes.
     * @return a string of translated binary codes.
     */
    public static String getWord(String binaryString) {
        // set split regex: on every 8th character
        String regex = "(?<=\\G........)";
        // split string into characters
        String[] characters = binaryString.split(regex);
        String text = "";
        for (String character : characters) {
            text = text + getLetter(character);
        }
        return text;
    }
}