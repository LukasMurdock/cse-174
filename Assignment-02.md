## Assignment 02

Assignment: Read from a file containing the following
```
5 H a  p p  y  4 F a l l  5 B
r   e a    k # 6 E n
j o y  !
```

Steps:
1. Ask user to “Enter an input file name: ”
2. Store given filename contents
    - 2.1: Read the dumb file formatting
    - 2.2: Add spaces
3. Print given filename contents
4. Ask user if they want to print in a file.
    - 4.1: Continue asking until user inputs `y` or `n`
    - 4.3: If yes, print given filename contents to file

Need to know:
- How to print
- How to get input from keyboard
- How to read from a file
- How to write to a file
- How to write loops

## Step 1: Ask user to “Enter an input file name: ”
```java
public class Assignment2 {
    public static void main(String[] args) {
        // Uses a new Scanner object to read from the keyboard 
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input file name: ");
        // Saves the next keyboard input as a String
        String inputFileName = keyboardReader.next();
    }
}
```

## Step 2: Store given filename contents
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment2 {
   public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Ask user to “Enter an input file name: ”
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input file name: ");
        String inputFileName = keyboardReader.next();

        // Create File object using the given filename
        File inputFileObject = new File(inputFileName);
        // Create Scanner object using the File object to read from the file
        Scanner fileReader = new Scanner(inputFileObject);
        // Initialize empty String variable so we can add the file contents
        // into it later
        String fileContents = "";
        // Use while loop to make sure we don't use next() when there is nothing next!
        while (fileReader.hasNext()) {
            String word = fileReader.next();
            fileContents = fileContents + word;
        }
        System.out.println(fileContents);
    }
}
```

### Step 2.1: Read the dumb file formatting
We were able to nicely get the file contents, but there’s extra data in this file that we don’t want!

The numbers represent the length of the following word and the `#` represents a line break. Gross.

To solve this the way the assignment expects you to solve it, we know the number represents the next words length. So one way we know we can read the file is to:
1. Read the number that represents the length of the next word
2. Read that number of characters, and we’ll have the next word
3. If we read a # instead of a number, we know to add a new line.

With a bit of mental wizardry, we can think of each next() read as starting with either a number (which represents the word length) or a `#` (which represents a new line).

So we can reorganize the steps above into the following:
```java
while (fileReader.hasNext()) {
    if(fileReader.hasNextInt()){
        // Read the number that represents the length of the next word
        int lengthOfNextWord = fileReader.nextInt();
        // Initialize empty String to store the characters into the word
        String word = "";
        // Read that number of characters, and we’ll have the next word
        for (int i = 0; i < lengthOfNextWord; i++) {
            String letter = fileReader.next();
            word = word + letter;
        }
        // Add the word to the file contents
        fileContents = fileContents + " " + word;
    } else if (fileReader.next().equals("#")) {
        // Insert a new line
        fileContents = fileContents + "\n";
    }
}
//HappyFallBreak
//Enjoy!
```

### Step 2.2: Add spaces
We have our words, but our words don’t have spaces!

Take a minute to think about how you could add spaces.

While you’re thinking, let’s port the previous step to our full code example to take up some space

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment2 {
   public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Ask user to “Enter an input file name: ”
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input file name: ");
        String inputFileName = keyboardReader.next();

        File inputFileObject = new File(inputFileName);
        Scanner fileReader = new Scanner(inputFileObject);
        String fileContents = "";

        while (fileReader.hasNext()) {
            if(fileReader.hasNextInt()){
                int lengthOfNextWord = fileReader.nextInt();
                String word = "";

                for (int i = 0; i < lengthOfNextWord; i++) {
                    String letter = fileReader.next();
                    word = word + letter;
                }

                fileContents = fileContents + " " + word;
            } else if (fileReader.next().equals("#")) {
                fileContents = fileContents + "\n";
            }
        }
        System.out.println(fileContents);
    }
}
```

Thought about it for a bit?

Okay, I’ll tell you how I went about it.

After taking a bit to think about it, *we really only want spaces after the **first** word*.

So, if we add a boolean (which is true or false) to see if we’re at the first word or not, then we can implement an if() statement to only add the spaces if it’s not the first word!

Here’s how that might look.

1. Outside of the loop create a variable to represent the boolean isFirstWord
2. Set it to true because the first iteration of the loop will be the first word
3. Inside the loop it’s a word (inside the .hasNextInt loop), if this is the first word then make sure the next loop will know it’s not the first word.
4. Else, it’s not the first word and we should add a space to the file contents.
5. If there’s a new line, we should set isFirstWord to true, as it will be the first word.

```java
File inputFileObject = new File(inputFileName);
Scanner fileReader = new Scanner(inputFileObject);
String fileContents = "";
// Initialize boolean outside of loop to be true.
// It’s true because the first iteration of the loop will be the first word
boolean isFirstWord = true;

while (fileReader.hasNext()) {
    if(fileReader.hasNextInt()){
        int lengthOfNextWord = fileReader.nextInt();
        String word = "";

        // If this is the first word, we need to set isFirstWord to false
        // for the next loop
        if (isFirstWord) {
            isFirstWord = false;
        } else {
            // Add space to file
            fileContents = fileContents + " ";
        }

        for (int i = 0; i < lengthOfNextWord; i++) {
            String letter = fileReader.next();
            word = word + letter;
        }

        fileContents = fileContents + " " + word;
    } else if (fileReader.next().equals("#")) {
        // Set first word to true if there’s a new line!
        isFirstWord = true;
        fileContents = fileContents + "\n";
    }
}
```

## Step 3: Print given filename contents
Putting steps one and two together fully gets us the file contents stored into a variable we can print out.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment2 {
   public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Ask user to “Enter an input file name: ”
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input file name: ");
        String inputFileName = keyboardReader.next();

        File inputFileObject = new File(inputFileName);
        Scanner fileReader = new Scanner(inputFileObject);
        String fileContents = "";

        while (fileReader.hasNext()) {
            if(fileReader.hasNextInt()){
                int lengthOfNextWord = fileReader.nextInt();
                String word = "";

                for (int i = 0; i < lengthOfNextWord; i++) {
                    String letter = fileReader.next();
                    word = word + letter;
                }

                fileContents = fileContents + " " + word;
            } else if (fileReader.next().equals("#")) {
                fileContents = fileContents + "\n";
            }
        }
        System.out.println(fileContents);
    }
}
```

## Step 4: Ask user if they want to print in a file
Just like in step 1, we just need to save the next keyboard input as a String.

```java
System.out.printf("Do you want to print in a file (y/n): ");
String wantsToPrint = keyboardReader.next();
```

### Step 4.1: Continue asking until user inputs `y` or `n`
To continue asking, we’ll want to make a loop that runs until our wantsToPrint variable equals "y" or "n".

Or, in other words, we want to make a loop that runs while wantsToPrint variable does not equal "y" and does not equal "n".

```java
// Initialize our variable so we can use it in the loop conditional.
String wantsToPrint = "";

// While wantsToPrint variable does not equal "y" and does not equal "n"
while (!wantsToPrint.equals("y") && !wantsToPrint.equals("n")) {
    // Ask user
    System.out.printf("Do you want to print in a file (y/n): ");
    // Save next input into the wantsToPrint variable
    wantsToPrint = keyboardReader.next();
}
```

### Step 4.3: If yes, print given filename contents to file
A bit more breakdown assuming the user wants to print to file:
1. Ask user what to name the file
2. Create PrintWriter object using the given filename (don’t forget to import java.io.PrintWriter)
3. Print to file
4. Don’t forget to close the PrintWriter object


```java
String wantsToPrint = "";

while (!wantsToPrint.equals("y") && !wantsToPrint.equals("n")) {
    System.out.printf("Do you want to print in a file (y/n): ");
    wantsToPrint = keyboardReader.next();
}

if (wantsToPrint.equals("y")) {
    // Ask user what to name the file
    System.out.printf("Enter an output file name: ");
    // Save next input into the outputFilename variable
    String outputFilename = keyboardReader.next();

    // Create PrintWriter object using the given filename
    File outputFileObject = new File(outputFilename);
    PrintWriter printWriter = new PrintWriter(outputFileObject);

    // Print to file (we already saved it as a string so this part is easy!)
    printWriter.println(fileContents);
    // Don’t forget to close the PrintWriter object
    printWriter.close();
    System.out.println("Printed inside the " + outputFilename + " successfully!");
}
```

## Putting it all together
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment2 {
   public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Ask user to “Enter an input file name: ”
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input file name: ");
        String inputFileName = keyboardReader.next();

        // Step 2: Store given filename contents
        File inputFileObject = new File(inputFileName);
        Scanner fileReader = new Scanner(inputFileObject);
        String fileContents = "";

        while (fileReader.hasNext()) {
            if(fileReader.hasNextInt()){
                int lengthOfNextWord = fileReader.nextInt();
                String word = "";

                for (int i = 0; i < lengthOfNextWord; i++) {
                    String letter = fileReader.next();
                    word = word + letter;
                }

                fileContents = fileContents + " " + word;
            } else if (fileReader.next().equals("#")) {
                fileContents = fileContents + "\n";
            }
        }
        // Step 3: Print given filename contents
        System.out.println(fileContents);

        // Step 4: Ask user if they want to print in a file
        String wantsToPrint = "";

        while (!wantsToPrint.equals("y") && !wantsToPrint.equals("n")) {
            System.out.printf("Do you want to print in a file (y/n): ");
            wantsToPrint = keyboardReader.next();
        }

        if (wantsToPrint.equals("y")) {
            System.out.printf("Enter an output file name: ");
            String outputFilename = keyboardReader.next();

            File outputFileObject = new File(outputFilename);
            PrintWriter printWriter = new PrintWriter(outputFileObject);

            printWriter.println(fileContents);
            printWriter.close();
            System.out.println("Printed inside the " + outputFilename + " successfully!");
        }
    }
}
```