
*psst.* Hey, If you got more value out of this than a cup of coffee, consider buying me one.  

<a class="bmc-button" target="_blank" href="https://www.buymeacoffee.com/lukasmurdock"><img src="https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" alt="Buy me a coffee"><span style="margin-left:5px;font-size:28px !important;">Buy me a coffee</span></a>

## What you need to know / what you need to learn
- [Learn how to write conditional statements](https://github.com/LukasMurdock/cse-174/blob/main/zines/conditional-statements.png)
- [Learn how to write loops](https://github.com/LukasMurdock/cse-174/blob/main/zines/loops.png)
- Learn how to write methods
- Learn how to “method overload”


## Steps
1. Have user select from 5 format options:
    1. Only First Name
    2. First Name, and Last Name
    3. First Name, Middle Initial, and Last Name
    4. First Name, Middle Name, and Last Name
    5. Exit
2. Create 4 `formatName` methods (method overload) to perform the different formatting
    1. String firstName
    2. String firstName, String lastName
    3. String firstName, char middleInitial, String lastName
    4. String firstName, String middleName, String lastName
3. Use the selected menu option to call `formatName` properly
4. Loop asking user to format

## Step 1: Have user select from 5 format options
I like to make reusable things, so let’s make a `menu` function that accepts menu options.

Let’s set up our file.

```java
import java.util.Scanner;

public class Lab10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // initialize menu options
        String[] menuOptions = {
            "Only First Name",
            "First Name, and Last Name",
            "First Name, Middle Initial, and Last Name",
            "First Name, Middle Name, and Last Name",
            "Exit"
        };

        // ask user menu options and save number input to variable
        int menuSelection = menuSelection(menuOptions);
    }
}
```

Now let’s write a menuSelection function.

```java
public static int menuSelection(String[] options) {
    int selection = -1;
    boolean validInput = false;
    System.out.println("Select an Option!");

    // print our menu options
    for (int index = 1; index < options.length + 1; index++) {
        System.out.println(index + ". " + options[index - 1]);
    }

    // wait for user to input a valid number
    while (!validInput) {
        selection = input.nextInt();
        validInput = (selection > 0 && selection <= options.length);
    }
    return selection;
}
```

## Step 2: Create 4 `formatName` methods to perform the different formatting
```java
public static String formatName(String firstName) {
    return String.format("%-8s", firstName);
}

public static String formatName(String firstName, String lastName) {
    return String.format("%-8s %-8s", firstName, lastName);
}

public static String formatName(
    String firstName,
    char middleInitial,
    String lastName
) {
    return String.format(
        "%-8s %-8s %-8s", firstName, middleInitial + ".", lastName
    );
}

public static String formatName(
    String firstName,
    String middleName,
    String lastName
) {
    return String.format(
        "%-8s %-8s %-8s", firstName, middleName, lastName
    );
}
```

## Step 3: Use the selected menu option to call `formatName` properly

```java
import java.util.Scanner;

public class Lab10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Step 1: Have user select from 5 format options
        String[] menuOptions = {
            "Only First Name",
            "First Name, and Last Name",
            "First Name, Middle Initial, and Last Name",
            "First Name, Middle Name, and Last Name",
            "Exit"
        };
        int menuSelection = menuSelection(menuOptions);

        // Print question if not exiting
        if (menuSelection != 5) {
            System.out.print("Please enter the name parts separated by a space: ");
        }

        // use the selected menu option to call formatName properly
        switch (menuSelection) {
            case 1:
                System.out.println(formatName(input.next()));
                break;
            case 2:
                System.out.println(formatName(input.next(), input.next()));
                break;
            case 3:
                System.out.println(
                    formatName(input.next(), input.next().charAt(0),
                        input.next())
                );
                break;
            case 4:
                System.out.println(
                    formatName(input.next(), input.next(), input.next())
                );
                break;
            case 5:
                System.out.println("Thank You for using the Name Formatter!");
                break;
            default:
                break;
        }
    }
}
```

## Step 4: Loop asking user to format
```java
import java.util.Scanner;

public class Lab10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // initialize loop variable
        boolean wantsToContinue = true;

        // Step 1: Have user select from 5 format options
        String[] menuOptions = {
            "Only First Name",
            "First Name, and Last Name",
            "First Name, Middle Initial, and Last Name",
            "First Name, Middle Name, and Last Name",
            "Exit"
        };

        // Loop until user selects 5
        while (wantsToContinue) {
            int menuSelection = menuSelection(menuOptions);

            // Step 3: Use the selected menu option to call `formatName` properly
            if (menuSelection != 5) {
                System.out.print("Please enter the name parts separated by a space: ");
            }
            switch (menuSelection) {
                case 1:
                    System.out.println(formatName(input.next()));
                    break;
                case 2:
                    System.out.println(formatName(input.next(), input.next()));
                    break;
                case 3:
                    System.out.println(
                        formatName(input.next(), input.next().charAt(0),
                            input.next())
                    );
                    break;
                case 4:
                    System.out.println(
                        formatName(input.next(), input.next(), input.next())
                    );
                    break;
                case 5:
                    System.out.println("Thank You for using the Name Formatter!");
                    // if user selects 5, stop looping.
                    wantsToContinue = false;
                    break;
                default:
                    break;
            }
        }
    }
}
```

## Full code

```java
import java.util.Scanner;

public class Lab10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean wantsToContinue = true;
        String[] menuOptions = {
            "Only First Name",
            "First Name, and Last Name",
            "First Name, Middle Initial, and Last Name",
            "First Name, Middle Name, and Last Name",
            "Exit"
        };

        while (wantsToContinue) {
            int menuSelection = menuSelection(menuOptions);

            if (menuSelection != 5) {
                System.out.print("Please enter the name parts separated by a space: ");
            }
            switch (menuSelection) {
                case 1:
                    System.out.println(formatName(input.next()));
                    break;
                case 2:
                    System.out.println(formatName(input.next(), input.next()));
                    break;
                case 3:
                    System.out.println(
                        formatName(input.next(), input.next().charAt(0),
                            input.next())
                    );
                    break;
                case 4:
                    System.out.println(
                        formatName(input.next(), input.next(), input.next())
                    );
                    break;
                case 5:
                    System.out.println("Thank You for using the Name Formatter!");
                    wantsToContinue = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static int menuSelection(String[] options) {
        int selection = -1;
        boolean validInput = false;
        System.out.println("Select an Option!");

        for (int index = 1; index < options.length + 1; index++) {
            System.out.println(index + ". " + options[index - 1]);
        }
        while (!validInput) {
            selection = input.nextInt();
            validInput = (selection > 0 && selection <= options.length);
        }
        return selection;
    }

    public static String formatName(String firstName) {
        return String.format("%-8s", firstName);
    }

    public static String formatName(String firstName, String lastName) {
        return String.format("%-8s %-8s", firstName, lastName);
    }

    public static String formatName(String firstName, char middleInitial, String lastName) {
        return String.format("%-8s %-8s %-8s", firstName, middleInitial + ".", lastName);
    }

    public static String formatName(String firstName, String middleName, String lastName) {
        return String.format("%-8s %-8s %-8s", firstName, middleName, lastName);
    }
}
```