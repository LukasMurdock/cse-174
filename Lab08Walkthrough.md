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

## Parts

This lab is split into two submissions.

I find it helps to break down what’s required into explicit steps. So let‘s do that first.

## Part 1
### Part 1 Steps
1. Ask a [number] from user
    - 1.1: If [number] <= 0, ask if they want to repeat
        - 1.1.1: Continue asking until a no (n, N) or yes (y, Y)
        - 1.1.2: If yes, repeat
        - 1.1.3: If no, print "End" and end
2. Print [number] rows, and [number] columns
    - 2.1: Make the cells row % columns
3. Print rows and columns
4. Ask if they want to repeat

## Part 2
### Part 2 Steps
1. Ask a [number] from user
    - 1.1: If [number] <= 0 throw new IllegalArgumentException();
        - 1.1.1: Catch IllegalArgumentException and print "No result with an input less than or equal to zero!"
    - 1.2: If NoSuchElementException, print "InvalidInput!"
        - 1.2.1: Ask a [number] from user
    - 1.3: If IllegalArgumentException
        - 1.3.1: Ask a [number] from user
2. Print [number] rows, and [number] columns
    - 2.1: Make the cells row % columns
3. Print rows and columns
4. Ask if they want to repeat
    - 4.1: Continue asking until a no (n, N) or yes (y, Y)
    - 4.2: If yes, repeat
    - 4.3: If no, print "End" and end

### Functions
I’m too tired to not make this with functions.
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