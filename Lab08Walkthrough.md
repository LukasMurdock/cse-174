> *Currently a work in progress, but the code blocks should be useful*

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

This lab is split into two submissions.

I find it helps to break down what’s required into explicit steps. So let‘s do that first.

## Steps
### Part 1 Steps

### Step 1.1: If number <= 0, print
### Step 1.2: Ask if they want to repeat until a no (n, N) or yes (y, Y)

1. Ask a [number] from user
    - 1.1: If number >= 0, print
    - 1.2: Ask if they want to repeat until a no (n, N) or yes (y, Y)
        - 1.2.1: If they want to repeat, repeat
2. Print [number] rows, and [number] columns
    - 2.1: Make the cells row % columns

### Part 2 Steps
1. Ask a [number] from user
    - 1.1: If [number] <= 0 throw new IllegalArgumentException();
        - 1.1.1: Catch IllegalArgumentException and print "No result with an input less than or equal to zero!"
    - 1.2: If NoSuchElementException, print "InvalidInput!"
        - 1.2.1: Ask a [number] from user
    - 1.3: If IllegalArgumentException
        - 1.3.1: Ask a [number] from user
2. Make [number] rows, and [number] columns
    - 2.1: Make the cells row % columns
3. Print rows and columns
4. Ask if they want to repeat
    - 4.1: Continue asking until a no (n, N) or yes (y, Y)
    - 4.2: If yes, repeat
    - 4.3: If no, print "End" and end

## Part 1
Okay, so we’re looking to:
1. Ask a [number] from user
2. Print [number] rows, and [number] columns
3. Ask if they want to repeat

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

### Step 1.2: Ask if they want to repeat until a no (n, N) or yes (y, Y)
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
        // Wrap in do-while loop
        do {
            // Step 1: Ask a number from user
            Scanner keyboardReader = new Scanner(System.in);
            System.out.print("Enter an int number: ");
            int enteredNumber = keyboardReader.nextInt();
            
            // Step 1.1: If number >= 0, print
            if (enteredNumber >= 0) {
                System.out.println(enteredNumber);
            }
            
            // Step 1.2: Ask if they want to repeat until a no (n, N) or yes (y, Y)
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
                    // Inputs are either now either yes or no
                    validInput = true;
                    // Set wantsToRepeat to true if user said "y" or "Y"
                    // otherwise sets wantsToRepeat to false
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
        do {
            // Step 1: Ask a number from user
            Scanner keyboardReader = new Scanner(System.in);
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

            // Step 1.2: Ask if they want to repeat until a no (n, N) or yes
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
        do {
            // Step 1: Ask a number from user
            Scanner keyboardReader = new Scanner(System.in);
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

            // Step 1.2: Ask if they want to repeat until a no (n, N) or yes
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

## Part 2

### Functions
I’m too tired to not make this with functions right now. We haven’t talked about methods yet in class, but the code blocks should still be of some use.
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