*Want a shortcut to this page? Type in [`cse-lab11.lukas.icu`](https://cse-lab11.lukas.icu) into the search bar and it’ll redirect you here!*

*psst.* Hey, If you got more value out of this than a cup of coffee, consider buying me one.  

<a class="bmc-button" target="_blank" href="https://www.buymeacoffee.com/lukasmurdock"><img src="https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" alt="Buy me a coffee"><span style="margin-left:5px;font-size:28px !important;">Buy me a coffee</span></a>

## What you need to know / what you need to learn
- [Learn how to write conditional statements](https://github.com/LukasMurdock/cse-174/blob/main/zines/conditional-statements.png)
- [Learn how to write loops](https://github.com/LukasMurdock/cse-174/blob/main/zines/loops.png)
- Learn how to write methods

## Pizza Prices
### Size
- Small: $4.00
- Medium: $5.50
- Large: $7.00

### Toppings
- Number of toppings * $0.75
- Anchovies cost an additional +$0.50

### Crust
- Stuffed crust on small pizza: +$1.00
- Stuffed crust on medium pizza: +$2.00
- Stuffed crust on large pizza: +$3.00

### Delivery
- Delivery on orders below $10: +$2.00
- Delivery on orders above $10: $0.00

## Steps
1. Create a PizzaShop class
2. Create a pizzaCost method
3. Given pizza size, calculate price
4. Given pizza toppings, calculate price
5. Given pizza crust, calculate price
6. Given pizza delivery, calculate price
7. Add size, topping, crust, and delivery pricing together to get the total cost of the pizza.

## Step 1: Create a PizzaShop class

```java
public class PizzaShop {

    public static void main(String[] args) {
    }

}
```

## Step 2: Create a pizzaCost method
Honestly, this method should be in the _pizza_ class but I digress.

```java
public static double pizzaCost(Pizza pizza) {
    return 0.0;
}
```

## Step 3: Given pizza size, calculate price
I like to make things reusable, so lets break this into it’s own method.

### Size Prices
- Small: $4.00
- Medium: $5.50
- Large: $7.00

```java
public static double pizzaSizeCost(Pizza pizza) {
    double sizeCost = 0.0;
    switch (pizza.getSize()) {
        case "small":
            sizeCost = 4.00;
            break;
        case "medium":
            sizeCost = 5.50;
            break;
        case "large":
            sizeCost = 7.00;
            break;
        default:
            break;
    }
    return sizeCost;
}
```

## Step 4: Given pizza toppings, calculate price
I like to make things reusable, so lets break this into it’s own method.

### Topping Prices
- Number of toppings * $0.75
- Anchovies cost an additional +$0.50

```java
public static double pizzaToppingsCost(Pizza pizza) {
    final double perToppingPrice = 0.75;
    double toppingsCost = perToppingPrice * pizza.toppingCount();
    if (pizza.getToppings().contains("anchovies")) {
        toppingsCost = toppingsCost + 0.50;
    }
    return toppingsCost;
}
```

## Step 5: Given pizza crust, calculate price
I like to make things reusable, so lets break this into it’s own method.

### Crust Prices
- Stuffed crust on small pizza: +$1.00
- Stuffed crust on medium pizza: +$2.00
- Stuffed crust on large pizza: +$3.00

```java
public static double pizzaCrustCost(Pizza pizza) {
    double crustCost = 0.0;
    if (pizza.getCrust().equals("stuffed")) {
        switch (pizza.getSize()) {
            case "small":
                crustCost = 1.00;
                break;
            case "medium":
                crustCost = 2.00;
                break;
            case "large":
                crustCost = 3.00;
                break;
            default:
                break;
        }
    }
    return crustCost;
}
```

## Step 6: Given pizza delivery, calculate price
I like to make things reusable, so lets break this into it’s own method.

### Delivery Prices
- Delivery on orders below $10: +$2.00
- Delivery on orders above $10: $0.00

I’m making this one a bit jank by calling the other methods we’ve just made, effectively re-running those calculations, but we need the price pre-delivery to determine the delivery price so.

```java
public static double pizzaDeliveryCost(Pizza pizza) {
    final double preDeliveryCost = pizzaSizeCost(pizza)
        + pizzaToppingsCost(pizza)
        + pizzaCrustCost(pizza);

    return pizza.getDelivery()
        ? preDeliveryCost >= 10 ? 0.00 : 2.00
        : 0.00;
}
```

## Step 7: Add size, topping, crust, and delivery pricing together to get the total cost of the pizza.

```java
public static double pizzaCost(Pizza pizza) {
    double totalCost = pizzaSizeCost(pizza)
        + pizzaToppingsCost(pizza)
        + pizzaCrustCost(pizza)
        + pizzaDeliveryCost(pizza);
    return totalCost;
}
```

## Full code

```java
public class PizzaShop {

    public static double pizzaCost(Pizza pizza) {
        double totalCost = pizzaSizeCost(pizza)
            + pizzaToppingsCost(pizza)
            + pizzaCrustCost(pizza)
            + pizzaDeliveryCost(pizza);
        return totalCost;
    }

    public static double pizzaSizeCost(Pizza pizza) {
        double sizeCost = 0.0;
        switch (pizza.getSize()) {
            case "small":
                sizeCost = 4.00;
                break;
            case "medium":
                sizeCost = 5.50;
                break;
            case "large":
                sizeCost = 7.00;
                break;
            default:
                break;
        }
        return sizeCost;
    }

    public static double pizzaToppingsCost(Pizza pizza) {
        final double perToppingPrice = 0.75;
        double toppingsCost = perToppingPrice * pizza.toppingCount();
        if (pizza.getToppings().contains("anchovies")) {
            toppingsCost = toppingsCost + 0.50;
        }
        return toppingsCost;
    }

    public static double pizzaCrustCost(Pizza pizza) {
        double crustCost = 0.0;
        if (pizza.getCrust().equals("stuffed")) {
            switch (pizza.getSize()) {
                case "small":
                    crustCost = 1.00;
                    break;
                case "medium":
                    crustCost = 2.00;
                    break;
                case "large":
                    crustCost = 3.00;
                    break;
                default:
                    break;
            }
        }
        return crustCost;
    }

    public static double pizzaDeliveryCost(Pizza pizza) {
        final double preDeliveryCost = pizzaSizeCost(pizza)
            + pizzaToppingsCost(pizza)
            + pizzaCrustCost(pizza);

        return pizza.getDelivery()
            ? preDeliveryCost >= 10 ? 0.00 : 2.00
            : 0.00;
    }
}
```