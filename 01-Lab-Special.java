// For posterity, this is not the code the class asked students to write.
// This is just what I ended up with while seeing what I could do with Java.
// Guaranteed this is garbage code, just for some context!

import java.util.Scanner;
import java.util.Arrays;

public class FirstProgram {
  public static void main(String[] args) {
    Scanner keyboardReader = new Scanner(System.in);

    System.out.print("What’s your favorite number? ");
    String favoriteNumber = keyboardReader.next();

    System.out.print("What’s your first and last name? ");
    String first = keyboardReader.next();
    String last = keyboardReader.next();

    drawBorder(50, false);
    System.out.print(welcomeText(first, last));
    drawBorder(50, false);
    System.out.print(gameRulesText(first));
    startGame(first, Integer.valueOf(favoriteNumber));
  }

  public static java.lang.StringBuilder welcomeText(String first, String last) {
    String[] stringArray = {
            String.format("Welcome, %s %s.", first, last),
            "This is my first CSE 174 programming assignment.",
            "Let’s play “Guess My Number”"
    };

    java.lang.StringBuilder result = appendStrings(stringArray);
    return result;
  }

  public static java.lang.StringBuilder gameRulesText(String name) {
    String[] stringArray = {
            String.format("Ready to play, %s?", name),
            "I’m thinking of a number between 1 and 100.",
            "Try to find it within 5 guesses."
    };
    java.lang.StringBuilder result = appendStrings(stringArray);
    return result;
  }

  public static StringBuilder drawBorder(int length, boolean factorial) {
    if (!factorial) {
      for (int i = 0; i < length; i++) {
        System.out.print("*");
      }
      System.out.println();
    } else {
      char[] charArray = new char[length];
      Arrays.fill(charArray, '*');
      String initialStar = new String(charArray);
      String[] strs = new String[length];

      Arrays.setAll(strs, (index) -> initialStar.substring(strs.length - index));

      java.lang.StringBuilder starsResult = appendStrings(strs, "\n");
      return starsResult;
    }

    return null;
  }

  public static void startGame(String first, int favoriteNumber) {
    int guessCount = 0;
    int correctNumber = (int) (1 + 100 * Math.random());
    Scanner keyboardReader = new Scanner(System.in);
    guessCount++;
    System.out.print("Enter guess #" + guessCount + ": ");
    int guess = keyboardReader.nextInt();

    while (guess != correctNumber) {
      if (guess < correctNumber) {
        System.out.println("Guess higher.");
      } else {
        System.out.println("Guess lower.");
      }

      guessCount++;
      System.out.print("Enter guess #" + guessCount + ": ");
      guess = keyboardReader.nextInt();
    }

    String[] stringArray = {
            String.format("Noice, %s!", first),
            String.format("You got it in %s guesses.", guessCount),
            (guessCount > 10
                    ? "You lost the game."
                    : "You won the game!"),
            String.valueOf(drawBorder(favoriteNumber, true)),
            "Goodbye!"
    };

    java.lang.StringBuilder result = appendStrings(stringArray);
    System.out.println(result);
  }

  private static java.lang.StringBuilder appendStrings(String[] arrayToAppend, String separator) {
    StringBuilder stringBuilder = new StringBuilder();

    separator = separator == null
            ? "\n"
            : separator;

    for (String i : arrayToAppend) {
      stringBuilder.append(i + separator);
    }
    return stringBuilder;
  }

  private static java.lang.StringBuilder appendStrings(String[] arrayToAppend) {
    StringBuilder stringBuilder = new StringBuilder();

    for (String i : arrayToAppend) {
      stringBuilder.append(i + "\n");
    }
    return stringBuilder;
  }
}