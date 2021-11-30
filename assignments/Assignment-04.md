*psst.* Hey, If you got more value out of this than a cup of coffee, consider buying me one.

<a class="bmc-button" target="_blank" href="https://www.buymeacoffee.com/lukasmurdock"><img src="https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" alt="Buy me a coffee"><span style="margin-left:5px;font-size:28px !important;">Buy me a coffee</span></a>

## What you need to know / what you need to learn
- [Learn how to write conditional statements](https://github.com/LukasMurdock/cse-174/blob/main/zines/conditional-statements.png)
- [Learn how to write loops](https://github.com/LukasMurdock/cse-174/blob/main/zines/loops.png)
- Learn how to write methods
- Learn how to read from a file
- Learn how to construct class objects
- Learn how to write sorting algorithms

## Steps
1. Get the `Customer.java` class, `list.txt`, and `customers.txt` in same folder.
2. Create a menu
3. Read from a file and create an array of `Customer` objects
4. Create a sorted array of the same `Customer` objects
5. Print array of `Customer` objects with pagination
6. Make everything work with the menu selection

## Step 1: Get the `Customer.java` class, `list.txt`, and `customers.txt` in same folder.
Download the links in the PDF.

## Step 2: Create a menu
I like to make reusable things so let’s make a `menuSelection` method that:
1. Accepts an array of `Strings` as menu options
2. Automatically prints the menu options
3. Automatically repeats until a valid selection is given
4. Returns the menu selection number

```java
public static int menuSelection(String[] options) {
    Scanner input = keyboardReader;

    int selection = -1;
    boolean validInput = false;

    for (int index = 1; index < options.length + 1; index++) {
        System.out.println(index + ". " + options[index - 1]);
    }
    System.out.printf("Enter a number[1-%s]: ", options.length);
    while (!validInput) {
        selection = input.nextInt();
        validInput = (selection > 0 && selection < options.length + 1);
    }
    return selection;
}
```

Now we can simply call it in our `main` method like so:

```java
public class Assignment4 {
    private static Scanner keyboardReader = new Scanner(System.in);
    private static String[] menuOptions = {
        "Load from a file",
        "Print the loaded list",
        "Sort the list based on the nicknames",
        "sort the list based on the ids",
        "Print the sorted list",
        "Exit"
    };

    public static void main(String[] args) {
        menuSelection = menuSelection(menuOptions);
    }

}
```

## Step 3: Read from a file and create an array of `Customer` objects
We want to do a few things here:
1. Get filename to read
2. Load customer objects from file
3. Access the state on whether data from a file has been loaded

To keep things somewhat orderly, let’s create a cascade of functions:
1. `loadCustomersFromFile()` will be the parent function that will initialize the class variables and state and call the next function
2. `setFile()` will handle asking the user for the filename to load and call the next function
3. `addCustomersFromFile()` will take the filename from `setFile()` and the `customers` object set by `loadCustomersFromFile()` and actually _add customers from the file_

```java
public class Assignment4 {
    private static boolean hasLoadedData = false;
    private static List<Customer> customers = new ArrayList<Customer>();
    private static Scanner keyboardReader = new Scanner(System.in);
    private static String[] menuOptions = {
        "Load from a file",
        "Print the loaded list",
        "Sort the list based on the nicknames",
        "sort the list based on the ids",
        "Print the sorted list",
        "Exit"
    };

    public static void main(String[] args) {
        menuSelection = menuSelection(menuOptions);
    }

    public static void loadCustomersFromFile() {
        System.out.println();
        customers = new ArrayList<Customer>();
        sortedCustomers = new ArrayList<Customer>();
        setFile();
        hasLoadedData = true;
        isSorted = false;
    }

    public static void setFile() {
        Scanner input = keyboardReader;

        System.out.print("Enter the name of the file: ");
        String fileName = input.next();
        addCustomersFromFile(fileName, customers);

        System.out.println("Loading from the file is done!");
        System.out.println();
    }

    public static Object addCustomersFromFile(
        String filename, List<Customer> customers
    ) {
        try {
            File fileObject = new File(filename);
            Scanner fileReader = new Scanner(fileObject);
            while (fileReader.hasNext()) {
                String customerName = fileReader.next();
                long customerId = fileReader.nextLong();
                Customer customer = new Customer(customerName, customerId);
                customers.add(customer);
            }

            fileReader.close();
            return customers;
        } catch (FileNotFoundException fileNotFoundException) {
            return new Customer[0];
        }
    }
}
```

## Step 4: Create a sorted array of the same `Customer` objects
Let’s create a few functions to make the code more readable. First, a `sortCustomers()` method that accepts a `sortType` so we can use it to call the (terribly named) assignment functions `sort1()` and `sort2()`. Second, a `checkDataLoad()` method that will… guess. It will check if file data has been loaded and print out the statements required by the assignment.

And okay, I’m ~~lazy~~ efficient. So I just used the Java sorting methods by importing `Comparator` and `Collectors`. Is this what the assignment asked for? `¯\_(ツ)_/¯` (no)

```java
public class Assignment4 {
    private static boolean hasLoadedData = false;
    private static boolean isSorted = false;
    private static List<Customer> customers = new ArrayList<Customer>();
    private static List<Customer> sortedCustomers = new ArrayList<Customer>();
    private static Scanner keyboardReader = new Scanner(System.in);
    private static String[] menuOptions = {
        "Load from a file",
        "Print the loaded list",
        "Sort the list based on the nicknames",
        "sort the list based on the ids",
        "Print the sorted list",
        "Exit"
    };
    // { … }

    public static boolean checkDataLoad() {
        if (!hasLoadedData) {
            System.out.println("No data has been loaded yet!");
            System.out.println();
        }

        return hasLoadedData;
    }

    public static void sortCustomers(String sortType) {
        if (checkDataLoad()) {
            if (sortType.equals("name")) {
                sort1(customers);
            } else if (sortType.equals("id")) {
                sort2(customers);
            }
            System.out.println("Sorting is done!");
            System.out.println();
            isSorted = true;
        }
    }

    public static void sort1(List<Customer> customerList) {
        sortedCustomers = customerList.stream()
            .sorted(Comparator.comparing(Customer::getName))
            .collect(Collectors.toList());
    }

    public static void sort2(List<Customer> customerList) {
        sortedCustomers = customerList.stream()
            .sorted(Comparator.comparing(Customer::getId))
            .collect(Collectors.toList());
    }
}
```

## Step 5: Print array of `Customer` objects with pagination
Paginate every 10 items, and go to next page with `s`. Let’s make a `printCustomerList()` method to handle printing either the sorted array or the non-sorted array. And then make `printLoadedList()` and `printSortedList()` methods to handle their individual logic.

```java
public static void printCustomerList(List<Customer> listToPrint) {
    Scanner input = keyboardReader;

    String selection = "";
    int index = listToPrint.size();
    int numbersToDisplay = 10;
    int displayCount = 0;

    boolean validInput = false;
    System.out.println();
    System.out.println("**** Printing the list ****");
    int repeatIndex = displayCount;
    while (!validInput && repeatIndex < listToPrint.size()) {
        while (
            repeatIndex < listToPrint.size()
                && repeatIndex < numbersToDisplay + displayCount
        ) {
            System.out.printf(
                "%s. %s\n",
                repeatIndex + 1, listToPrint.get(repeatIndex).toString()
            );
            repeatIndex++;
        }

        displayCount = displayCount + 10;
        if (repeatIndex < listToPrint.size()) {
            System.out.print(
                "Enter something to continue/enter s to stop: ");
            selection = input.next();
            validInput =
                selection.equals("s")
                    || (repeatIndex == listToPrint.size() - 1);
        } else {
            validInput = true;
        }

        index--;
    }
    System.out.println();
}

public static void printLoadedList() {
    if (checkDataLoad()) {
        printCustomerList(customers);
    }
}

public static void printSortedList() {
    if (checkDataLoad()) {
        if (isSorted) {
            printCustomerList(sortedCustomers);
        } else {
            System.out.println("Nothing is sorted yet!");
            System.out.println();
        }
    }
}
```

## Step 6: Make everything work with the menu selection
Finally back to the `main` method! Let’s complete our menu.

```java
public static void main(String[] args) {
        int menuSelection = -1;
        while (menuSelection != 6) {

            menuSelection = menuSelection(menuOptions);

            switch (menuSelection) {
                case 1:
                    loadCustomersFromFile();
                    break;
                case 2:
                    printLoadedList();
                    break;
                case 3:
                    sortCustomers("name");
                    break;
                case 4:
                    sortCustomers("id");
                    break;
                case 5:
                    printSortedList();
                    break;
                case 6:
                    System.out.println("End!");
                    break;
                default:
                    break;
            }
        }
    }
```

## Final Code

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment4 {

    private static boolean hasLoadedData = false;
    private static boolean isSorted = false;
    private static List<Customer> customers = new ArrayList<Customer>();
    private static List<Customer> sortedCustomers = new ArrayList<Customer>();
    private static Scanner keyboardReader = new Scanner(System.in);
    private static String[] menuOptions = {
        "Load from a file",
        "Print the loaded list",
        "Sort the list based on the nicknames",
        "sort the list based on the ids",
        "Print the sorted list",
        "Exit"
    };

    public static void main(String[] args) {
        int menuSelection = -1;
        while (menuSelection != 6) {

            menuSelection = menuSelection(menuOptions);

            switch (menuSelection) {
                case 1:
                    loadCustomersFromFile();
                    break;
                case 2:
                    printLoadedList();
                    break;
                case 3:
                    sortCustomers("name");
                    break;
                case 4:
                    sortCustomers("id");
                    break;
                case 5:
                    printSortedList();
                    break;
                case 6:
                    System.out.println("End!");
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Load customers from file. It's in the name.
     */
    public static void loadCustomersFromFile() {
        System.out.println();
        customers = new ArrayList<Customer>();
        sortedCustomers = new ArrayList<Customer>();
        setFile();
        hasLoadedData = true;
        isSorted = false;
    }

    /**
     * Print loaded customer list. It's in the name.
     */
    public static void printLoadedList() {
        if (checkDataLoad()) {
            printCustomerList(customers);
        }
    }

    /**
     * Sort customers. It's in the name.
     *
     * @param sortType Sort by `name` or `id`.
     */
    public static void sortCustomers(String sortType) {
        if (checkDataLoad()) {
            if (sortType.equals("name")) {
                sort1(customers);
            } else if (sortType.equals("id")) {
                sort2(customers);
            }
            System.out.println("Sorting is done!");
            System.out.println();
            isSorted = true;
        }
    }

    /**
     * Print sorted list. It's in the name.
     */
    public static void printSortedList() {
        if (checkDataLoad()) {
            if (isSorted) {
                printCustomerList(sortedCustomers);
            } else {
                System.out.println("Nothing is sorted yet!");
                System.out.println();
            }
        }
    }

    /**
     * Check `hasLoadedData` and print message.
     *
     * @return boolean hasLoadedData
     */
    public static boolean checkDataLoad() {
        if (!hasLoadedData) {
            System.out.println("No data has been loaded yet!");
            System.out.println();
        }

        return hasLoadedData;
    }

    /**
     * Sort customer list by name.
     *
     * @param customerList list to sort
     */
    public static void sort1(List<Customer> customerList) {
        sortedCustomers = customerList.stream()
            .sorted(Comparator.comparing(Customer::getName))
            .collect(Collectors.toList());
    }

    /**
     * Sort customer list by id.
     *
     * @param customerList list to sort
     */
    public static void sort2(List<Customer> customerList) {
        sortedCustomers = customerList.stream()
            .sorted(Comparator.comparing(Customer::getId))
            .collect(Collectors.toList());
    }

    /**
     * Set the file and add customers to class field.
     */
    public static void setFile() {
        Scanner input = keyboardReader;

        System.out.print("Enter the name of the file: ");
        String fileName = input.next();
        addCustomersFromFile(fileName, customers);

        System.out.println("Loading from the file is done!");
        System.out.println();
    }

    /**
     * Print customer list.
     *
     * @param listToPrint customer list to print
     */
    public static void printCustomerList(List<Customer> listToPrint) {
        Scanner input = keyboardReader;

        String selection = "";
        int index = listToPrint.size();
        int numbersToDisplay = 10;
        int displayCount = 0;

        boolean validInput = false;
        System.out.println();
        System.out.println("**** Printing the list ****");
        int repeatIndex = displayCount;
        while (!validInput && repeatIndex < listToPrint.size()) {
            while (
                repeatIndex < listToPrint.size()
                    && repeatIndex < numbersToDisplay + displayCount
            ) {
                System.out.printf(
                    "%s. %s\n",
                    repeatIndex + 1, listToPrint.get(repeatIndex).toString()
                );
                repeatIndex++;
            }

            displayCount = displayCount + 10;
            if (repeatIndex < listToPrint.size()) {
                System.out.print(
                    "Enter something to continue/enter s to stop: ");
                selection = input.next();
                validInput =
                    selection.equals("s")
                        || (repeatIndex == listToPrint.size() - 1);
            } else {
                validInput = true;
            }

            index--;
        }
        System.out.println();
    }

    /**
     * Create a menu selection.
     *
     * @param options list of options to select from
     * @return menu selection int
     */
    public static int menuSelection(String[] options) {
        Scanner input = keyboardReader;

        int selection = -1;
        boolean validInput = false;

        for (int index = 1; index < options.length + 1; index++) {
            System.out.println(index + ". " + options[index - 1]);
        }
        System.out.printf("Enter a number[1-%s]: ", options.length);
        while (!validInput) {
            selection = input.nextInt();
            validInput = (selection > 0 && selection < options.length + 1);
        }
        return selection;
    }

    /**
     * Create array of customers from a file with customer information.
     *
     * @param filename  filename to read from
     * @param customers array of customers to add too
     * @return array of customers
     */
    public static Object addCustomersFromFile(
        String filename, List<Customer> customers
    ) {
        try {
            File fileObject = new File(filename);
            Scanner fileReader = new Scanner(fileObject);
            while (fileReader.hasNext()) {
                String customerName = fileReader.next();
                long customerId = fileReader.nextLong();
                Customer customer = new Customer(customerName, customerId);
                customers.add(customer);
            }

            fileReader.close();
            return customers;
        } catch (FileNotFoundException fileNotFoundException) {
            return new Customer[0];
        }
    }
}
```
