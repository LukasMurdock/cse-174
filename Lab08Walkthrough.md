*Want a shortcut to this page? Type in [`cse-lab8.lukas.icu`](https://cse-lab8.lukas.icu) into the search bar and it’ll redirect you here!*

*psst.* Hey, If you got more value out of this than a cup of coffee, consider buying me one.  

<a class="bmc-button" target="_blank" href="https://www.buymeacoffee.com/lukasmurdock"><img src="https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" alt="Buy me a coffee"><span style="margin-left:5px;font-size:28px !important;">Buy me a coffee</span></a>

## What you need to know / what you need to learn
- Learn how to print (System.out)
- [Learn how to write conditional statements](https://github.com/LukasMurdock/cse-174/blob/main/zines/conditional-statements.png)
- Learn how to get input from keyboard (Scanner)
- [Learn how to write loops](https://github.com/LukasMurdock/cse-174/blob/main/zines/loops.png)
- Learn how to catch Exceptions

[See the current zines on Fundamentals of Programming with Java](https://github.com/LukasMurdock/cse-174/blob/main/zines.md)

---

This lab is split into two submissions. Part 1 is the bulk of it. Part 2 is catching errors.

I find it helps to break down what’s required into explicit steps. So let‘s do that first.

## Steps
### Part 1 Steps
1. Ask a [number] from user
    - 1.1: If number >= 0, print
    - 1.2: Ask “Do you want to repeat” until a no (n, N) or yes (y, Y)
        - 1.2.1: If they want to repeat, repeat
2. Print [number] rows, and [number] columns
    - 2.1: Make the cells row % columns

### Part 2 Steps
1. Catch NoSuchElementException and print "Invalid Input!"
2. If [number] > 0 then print, else throw new IllegalArgumentException();
    - 2.1: Catch IllegalArgumentException and print "No result with an input less than or equal to zero!"


## Part 1
Okay, so we’re really all we’re looking to do in part 1 is:
1. Ask a [number] from user
2. Print [number] rows, and [number] columns
3. Ask if they want to repeat

Here’s a repeat of the detailed steps:
1. Ask a [number] from user
    - 1.1: If number >= 0, print
    - 1.2: Ask “Do you want to repeat” until a no (n, N) or yes (y, Y)
        - 1.2.1: If they want to repeat, repeat
2. Print [number] rows, and [number] columns
    - 2.1: Make the cells row % columns

### Step 1: Ask a number from user
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Create scanner object to read keyboard
        Scanner keyboardReader = new Scanner(System.in);
        // Ask user to enter a number
        System.out.print("Enter an int number: ");
        // Store entered number as a variable
        int enteredNumber = keyboardReader.nextInt();
        // Print entered number to test if it works
        System.out.println(enteredNumber);
    }
}
// input: 3
// output: 3
```

### Step 1.1: If number >= 0, print
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Step 1: Ask a number from user
        Scanner keyboardReader = new Scanner(System.in);
        System.out.print("Enter an int number: ");
        int enteredNumber = keyboardReader.nextInt();
        
        // If number >= 0, print
        if (enteredNumber >= 0) {
            System.out.println(enteredNumber);
        }
    }
}
```

### Step 1.2: Ask “Do you want to repeat” until a no (n, N) or yes (y, Y)
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Step 1: Ask a number from user
        Scanner keyboardReader = new Scanner(System.in);
        System.out.print("Enter an int number: ");
        int enteredNumber = keyboardReader.nextInt();
        
        // Step 1.1: If number >= 0, print
        if (enteredNumber >= 0) {
            System.out.println(enteredNumber);
        }

        // Initialize validInput outside loop, so we can use it in conditional
        boolean validInput = false;
        while (!validInput) {
            // Ask user if they want to repeat
            System.out.print("Do you want to repeat (y/n)? ");
            // Save response into variable userRepeatString
            String userRepeatString = keyboardReader.next();
            // Check if response is valid
            if (
                userRepeatString.equals("y")
                    || userRepeatString.equals("Y")
                    || userRepeatString.equals("n")
                    || userRepeatString.equals("N")
            ) {
                validInput = true;
            }
        }
    }
}
```

### Step 1.2.1: If they want to repeat, repeat
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Initialize wantsToRepeat outside loop, so we can access it in conditional
        boolean wantsToRepeat;
        // Move scanner outside loop so you pass the dumb test
        Scanner keyboardReader = new Scanner(System.in);
        // Wrap in do-while loop
        do {
            // Step 1: Ask a number from user
            System.out.print("Enter an int number: ");
            int enteredNumber = keyboardReader.nextInt();
            
            // Step 1.1: If number >= 0, print
            if (enteredNumber >= 0) {
                System.out.println(enteredNumber);
            }
            
            // Step 1.2: Ask "Do you want to repeat" until a no (n, N) or yes (y, Y)
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to repeat (y/n)? ");
                String userRepeatString = keyboardReader.next();
                if (
                    userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                        || userRepeatString.equals("n")
                        || userRepeatString.equals("N")
                ) {
                    // Inputs are now either either yes (y, Y) or no (n, N)
                    validInput = true;
                    // Set variable wantsToRepeat to true if user said "y" or "Y"
                    // otherwise set wantsToRepeat to false
                    wantsToRepeat = userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                }
            }
        } while (wantsToRepeat)
    }
}
```

### Step 2: Print number rows, and number columns
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Step 1.2.1: If they want to repeat, repeat
        boolean wantsToRepeat = false;
        Scanner keyboardReader = new Scanner(System.in);
        do {
            // Step 1: Ask a number from user
            System.out.print("Enter an int number: ");
            int enteredNumber = keyboardReader.nextInt();

            // Overwriting Step 1.1: If number >= 0, print
            // Step 2: Print number rows, and number columns
            if (enteredNumber >= 0) {
                // For enteredNumber of rows…
                for (int rowIndex = 1; rowIndex < enteredNumber + 1; rowIndex++) {
                    // For enteredNumber of columns…
                    for (int columnIndex = 1; columnIndex < enteredNumber + 1; columnIndex++) {
                        // Print "O" in each cell (each row in each column)
                        System.out.print("O");
                    }
                    // Print a new line at the end of each row, to start the next row.
                    System.out.println();
                }
            }

            // Step 1.2: Ask "Do you want to repeat" until a no (n, N) or yes (y, Y)
            // (y, Y)
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to repeat (y/n)? ");
                String userRepeatString = keyboardReader.next();
                if (
                    userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                        || userRepeatString.equals("n")
                        || userRepeatString.equals("N")
                ) {
                    validInput = true;
                    wantsToRepeat = userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                }
            }
        } while (wantsToRepeat);

        System.out.println("End");
    }
}
```

### Step 2.1: Make the cells row % columns
```java
public class Lab8Part1 {
    public static void main(String[] args) {
        // Step 1.2.1: If they want to repeat, repeat
        boolean wantsToRepeat = false;
        Scanner keyboardReader = new Scanner(System.in);
        do {
            // Step 1: Ask a number from user
            System.out.print("Enter an int number: ");
            int enteredNumber = keyboardReader.nextInt();

            // Overwriting Step 1.1: If number >= 0, print
            // Step 2: Print number rows, and number columns
            if (enteredNumber >= 0) {
                for (int rowIndex = 1; rowIndex < enteredNumber + 1; rowIndex++) {
                    for (int columnIndex = 1; columnIndex < enteredNumber + 1; columnIndex++) {
                        // If row is divisible by column, print "O", else print "X" in each cell
                        String stringToPrint = (rowIndex % columnIndex == 0) ? "O" : "X";
                        System.out.print(stringToPrint);
                    }
                    // Print a new line at the end of each row, to start the next row.
                    System.out.println();
                }
            }

            // Step 1.2: Ask "Do you want to repeat" until a no (n, N) or yes (y, Y)
            // (y, Y)
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to repeat (y/n)? ");
                String userRepeatString = keyboardReader.next();
                if (
                    userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                        || userRepeatString.equals("n")
                        || userRepeatString.equals("N")
                ) {
                    validInput = true;
                    wantsToRepeat = userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                }
            }
        } while (wantsToRepeat);

        System.out.println("End");
    }
}
```

## Part 2: Catch them exceptions

Using the `nextInt()` method on the Scanner object means we can determine at least two events that would make our code fail:
1. If what is read is not an int
2. If there is nothing to read

In both of these cases, [according to the Java Docs on the Scanner class](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#:~:text=public%C2%A0int%C2%A0nextInt()-,Scans%20the%20next%20token%20of%20the%20input%20as%20an%20int.,-An%20invocation%20of), an error will be thrown:
1. If what is read is not an int, `InputMismatchException` will be thrown.
2. If there is nothing to read, `NoSuchElementException` will be thrown.

One way to prevent these events from making our code fail is to implement a try-catch block. A try-catch block lets you define a block of code to *try*, and a block of code to run if a specified error is *caught* in the try block.

Steps:
1. Try to read the next input as a number
    1.1 If the next input is not a number, it will throw `InputMismatchException` error. Catch that.
2. If the entered number is less than or equal to 0, the lab wants us to throw `IllegalArgumentException`. Catch that.


Working Code
```java
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab8Part2 {
    public static void main(String[] args) {
        boolean wantsToRepeat = true;
        Scanner keyboardReader = new Scanner(System.in);
        do {
            int enteredNumber = 0;
            boolean validRepeatInput = false;
            System.out.print("Enter an int number: ");
            // declare a try block to try to read the next input as a number
            try {
                enteredNumber = keyboardReader.nextInt();

                if (enteredNumber > 0) {
                    for (int rowIndex = 1; rowIndex < enteredNumber + 1; rowIndex++) {
                        for (int columnIndex = 1; columnIndex < enteredNumber + 1; columnIndex++) {
                            String stringToPrint = (rowIndex % columnIndex == 0)
                                ? "O" : "X";
                            System.out.print(stringToPrint);
                        }
                        System.out.println();
                    }
                } else {
                    // if the next input is less than or equal to zero, throw IllegalArgumentException
                    throw new IllegalArgumentException();
                }
            // catch the InputMismatchException that is thrown if number is not an int
            } catch (InputMismatchException error) {
                // Reading from the keyboard failed, so we need to read in the value to clear out the Scanner input.
                String waste = keyboardReader.next();
                System.out.println("Invalid Input!");
                validRepeatInput = true;
            // catch the IllegalArgumentException that we throw if number <= 0
            } catch (IllegalArgumentException error) {
                System.out.println(
                    "No result with an input less than or equal to zero!"
                );
            }

            while (!validRepeatInput) {
                System.out.print("Do you want to repeat (y/n)? ");
                String userRepeatString = keyboardReader.next();
                if (
                    userRepeatString.equals("y")
                        || userRepeatString.equals("Y")
                        || userRepeatString.equals("n")
                        || userRepeatString.equals("N")
                ) {
                    validRepeatInput = true;
                    wantsToRepeat = userRepeatString.equals("y")
                        || userRepeatString.equals("Y");
                }
            }
        } while (wantsToRepeat);

        System.out.println("End");
    }
}
```

---

# Extra?

### Functions
I usually make functions to handle big code blocks. Here’s how I did the lab.
- int getNumberFromUser
- boolean getRepeatFromUser
- printTable(int)

### Plan

#### Main Method
```java
public static void main(String[] args) {
    Scanner kbRead = new Scanner(System.in);
    boolean wantsToRepeat;
    do {
        int numberFromUser = getNumberFromUser(kbRead);
        printTable(numberFromUser);
        wantsToRepeat = getRepeatFromUser(kbRead);
    } while (wantsToRepeat);
    System.out.println("End");
}
```

#### getNumberFromUser
```java
public static int getNumberFromUser(Scanner kbRead) {
    final int errorNumber = -9999;
    boolean validInput = false;
    int enteredNumber = errorNumber;

    while (!validInput) {
        System.out.print("Enter an int number: ");
        try {
            enteredNumber = kbRead.nextInt();
            if (enteredNumber <= 0) {
                throw new IllegalArgumentException();
            }
            validInput = true;
        } catch (NoSuchElementException error) {
            String waste = kbRead.next();
            System.out.println("Invalid Input!");
        } catch (IllegalArgumentException error) {
            System.out.println(
                "No result with an input less than or equal to zero!"
            );
            getRepeatFromUser(kbRead);
        }
    }

    return enteredNumber;
}
```

#### getRepeatFromUser
```java
public static boolean getRepeatFromUser(Scanner kbRead) {
    String[] yesString = {"y", "Y"};
    String[] checkStrings = {"y", "Y", "n", "N"};
    String userInput = "";
    boolean validInput = false;
    while (!validInput) {
        System.out.print("Do you want to repeat (y/n)? ");
        userInput = kbRead.next();
        validInput =
            Arrays.stream(checkStrings).anyMatch(userInput::equals);
    }
    return Arrays.stream(yesString).anyMatch(userInput::equals);
}
```

#### printTable
```java
public static void printTable(int tableLength) {
    for (int rowIndex = 1; rowIndex < tableLength + 1; rowIndex++) {
        for (int columnIndex = 1; columnIndex < tableLength + 1;
                columnIndex++) {
            String stringToPrint =
                (rowIndex % columnIndex == 0) ? "O" : "X";
            System.out.print(stringToPrint);
        }
        System.out.println();
    }
}
```