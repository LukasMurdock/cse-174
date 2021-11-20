public class Lab13 {

    public static int linearSearch(Customer[] customers,
                                   Customer customerToFind) {
        for (int index = 0; index < customers.length; index++) {
            if (customers[index].getId() == customerToFind.getId()) {
                System.out.printf("Linear Search: The key is found after "
                    + "%s comparison\n", index + 1);
                return index;
            }
        }
        System.out.printf("Linear Search: The key is found after "
            + "%s comparison\n", customers.length);
        return -1;
    }

    public static int binarySearch(Customer[] customers,
                                   Customer customerToFind) {
        int lower = 0;
        int higher = customers.length - 1;

        int count = 0;
        while (lower <= higher) {
            count++;
            int middle = (lower + higher) / 2;
            if (customers[middle].getId() == customerToFind.getId()) {
                System.out.printf("Binary Search: the key is found after "
                    + "%s comparison\n", count);
                return middle;
            } else if (customerToFind.getId() > customers[middle].getId()) {
                lower = middle + 1;
            } else if (customerToFind.getId() < customers[middle].getId()) {
                higher = middle - 1;
            }
        }
        System.out.printf("Binary Search: the key is found after "
            + "%s comparison\n", count);
        return -1;
    }

    public static int getLinesFromFile(String filename) {
        try {
            File fileObject = new File(filename);
            Scanner fileReader = new Scanner(fileObject);
            int lineLength = 0;
            while (fileReader.hasNextLine()) {
                fileReader.nextLine();
                lineLength++;
            }
            fileReader.close();

            return lineLength;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException);
        }

        return -1;
    }

    public static Customer[] addCustomersFromFile(
        String filename, Customer[] customers
    ) {
        try {
            File fileObject = new File(filename);
            Scanner fileReader = new Scanner(fileObject);
            int index = customers.length;
            while (fileReader.hasNext()) {
                String customerName = fileReader.next();
                long customerId = fileReader.nextLong();
                Customer customer = new Customer(customerName, customerId);
                customers[customers.length - index] = customer;
                index--;
            }

            fileReader.close();
            return customers;
        } catch (FileNotFoundException fileNotFoundException) {
            return new Customer[0];
        }
    }

    public static void printIndex(Customer[] customer, int index) {
        if (index != customer.length - 1) {
            System.out.printf(
                "[%s]: [%s, %s]\n",
                index,
                customer[index].getName(),
                customer[index].getId()
            );
        } else {
            System.out.printf(
                "[last index]: [%s, %s]\n",
                customer[index].getName(),
                customer[index].getId()
            );
        }
    }
}