/**
 * Lukas Murdock
 * Assignment 4
 */
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
     * Quicksort customer list by name.
     *
     * @param customerList list to sort
     */
    public static void sort1(List<Customer> customerList) {
        // QuickSort sort
        // customerList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        // customerList.sort(Comparator.comparing(Customer::getId));
        // customerList.sort(Comparator.comparing(Customer::getName));
        // sortedCustomers = customerList.stream()
        //     .sorted(Comparator.comparing(Customer::getName))
        //     .collect(Collectors.toList());
        sortedCustomers = clone(customerList);
        selectionSortName(sortedCustomers);
    }

    /**
     * Quicksort customer list by id.
     *
     * @param customerList list to sort
     */
    public static void sort2(List<Customer> customerList) {
        sortedCustomers = clone(customerList);
        bubbleSort(sortedCustomers);
        // sortedCustomers = customerList.stream()
        //     .sorted(Comparator.comparing(Customer::getId))
        //     .collect(Collectors.toList());
    }

    /**
     * Clone customer list.
     *
     * @param arr customer list to clone
     * @return cloned customer list
     */
    public static List<Customer> clone(List<Customer> arr) {
        List<Customer> clone = new ArrayList<>(arr);
        // List<Customer> newArr =
        //     (List<Customer>) new ArrayList<Customer>().get(arr.size());
        for (int i = 0; i < arr.size(); ++i) {
            clone.set(i, arr.get(i));
        }
        return clone;
    }

    /**
     * Bubble sort list of customers.
     *
     * @param arr return sorted array
     */
    public static void bubbleSort(List<Customer> arr) {
        boolean madeSwap;
        do {
            madeSwap = false;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i).getId() > arr.get(i + 1).getId()) {
                    Customer temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    madeSwap = true;
                }
            }
        } while (madeSwap);
    }

    public static void selectionSortName(List<Customer> arr) {

        // Use selection sort to sort arraylist.
        for (int i = 0; i < arr.size(); i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(smallest).getName()
                    .compareTo(arr.get(j).getName()) > 0) {
                    smallest = j;
                }
            }

            Customer tmp = arr.set(i,
                arr.get(smallest));

            arr.set(smallest, tmp);
        }

        // System.out.println("Sorting is done!");
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
                System.out.printf("%s. %s\n",
                    repeatIndex + 1, listToPrint.get(repeatIndex).toString());
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
        // System.out.println("Choose from these choices");
        // System.out.println("-------------------------\n");

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
