import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {
        class Discount {
            String name;
            double[] discounts;

            public Discount(String name, double[] discounts) {
                this.name = name;
                this.discounts = discounts;
            }
        }

        Discount dogDiscount = new Discount("Dog discount", new double[]{0.10,
            0.20});
        Discount catDiscount = new Discount("Cat discount", new double[]{0.10,
            0.15});
        Discount rodentDiscount = new Discount("Rodent discount",
            new double[]{0.10,
                0.15});

        Discount[] discounts = {dogDiscount, catDiscount, rodentDiscount};

        Scanner keyboardReader = new Scanner(System.in);
        int menuSelection = userInputMenuSelection(keyboardReader);

        System.out.print("Enter total purchase: ");
        double totalPurchase = keyboardReader.nextDouble();

        int isOver100 = totalPurchase <= 100 ? 0 : 1;

        String discountFormat = "%s (%f%%): %f";
        double discountPercent =
            (discounts[menuSelection - 1].discounts[isOver100] * 100);
        double calculatedDiscount =
            (totalPurchase * discounts[menuSelection - 1].discounts[isOver100]);

        System.out.printf("%s (%.0f%%): %.2f\n",
            discounts[menuSelection - 1].name,
            discountPercent,
            calculatedDiscount);
        System.out.printf("Price Payable: %.2f\n",
            totalPurchase - calculatedDiscount);
        System.out.println("End");
    }

    public static int userInputMenuSelection(Scanner keyboardReader) {
        System.out.println("*Discount Calculator*");
        System.out.println("1. Calculating dog discount");
        System.out.println("2. Calculating cat discount");
        System.out.println("3. Calculating rodent discount");
        System.out.print("Enter a number [1, 2, 3]: ");
        int selection = keyboardReader.nextInt();
        return selection;
    }
}