/**
 * A PizzaShop class that calculates the has a method to calculate the price
 * of pizzas.
 * November, 2020
 *
 * @author Lukas Murdock
 * @version 1.0
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PizzaShop {

    public static void main(String[] args) {
        // Pizza pizza = new Pizza(234);
        Pizza pizza = new Pizza(199);
        System.out.printf("$%.2f", pizzaCost(pizza));
        // new Pizza(234) // $7.75
        // new Pizza(8675) // $10.00
    }

    /**
     * Given a pizza object, returns the price of the house.
     *
     * @param pizza a pizza object
     * @return the price of the pizza as a double
     */
    public static double pizzaCost(Pizza pizza) {
        Map<String, Double> sizePricing = new HashMap<>();
        Map<String, Double> specialToppingPricing = new HashMap<>();
        Map<String, Double> crustPricing = new HashMap<>();

        // Set flat rate topping pricing
        double toppingFlatRate = 0.75;
        // Set size pricing
        sizePricing.put("small", 4.0);
        sizePricing.put("medium", 5.50);
        sizePricing.put("large", 7.0);
        // Set special topping pricing
        specialToppingPricing.put("anchovies", 0.5);
        // Set crust pricing
        crustPricing.put("small", 1.0);
        crustPricing.put("medium", 2.0);
        crustPricing.put("large", 3.0);

        double sizePrice = sizePricing.get(pizza.getSize());
        double crustPrice = pizza.getCrust().equals("stuffed")
            ? crustPricing.get(pizza.getSize())
            : 0.0;

        String[] toppings = pizza.getToppings()
            .replace("[", "")
            .replace("]", "")
            .split(" ");

        Double toppingsPrice = (pizza.toppingCount() * toppingFlatRate)
            + Arrays.stream(toppings)
            .filter(specialToppingPricing::containsKey)
            .distinct()
            .map(specialToppingPricing::get)
            .mapToDouble(Double::doubleValue)
            .sum();
        double deliveryPrice = pizza.getDelivery()
            ? (sizePrice + toppingsPrice + crustPrice) >= 10.0 ? 0 : 2
            : 0.0;
        double totalPrice =
            sizePrice + crustPrice + toppingsPrice + deliveryPrice;

        // Debug statements
        // System.out.println("Toppings: "
        //     + pizza.getToppings() + ": " + toppingsPrice);
        // System.out.println(pizza.getSize() + ": " + sizePrice);
        // System.out.println(pizza.getCrust() + ": " + crustPrice);
        // System.out.println("Delivery: " + deliveryPrice);
        // System.out.println("Total: " + totalPrice);
        return totalPrice;
    }
}