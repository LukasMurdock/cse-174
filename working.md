## More on Objects
Objects and methods
Use standard Object methods: equals(), toString(), compareTo()

Java's API documentation to select and use appropriate classes, objects, constructors, and methods.

## Input and Output

## Testing

```java
@Test
public void testAddNumbers() {
    int x  = 1 ; int y = 1;
    assertEquals(2, Calculator.addNumbers(x,y));
}

@Test
public void testSubtractNumbers() {
    int x  = 1 ; int y = 1;
    assertEquals(0, Calculator.subtractNumbers(x,y));
}

public class Calculator {
    public static void main(String[] args) {
        System.out.println(addNumbers(400, 20));
        System.out.println(addNumbers(60, 9));
    }

    public static int addNumbers(int x, int y) {
        return x + y;
    }

    public static int subtractNumbers(int x, int y) {
        return x + y;
    }
}
```

## Conditionals

## Loops

## Algorithms
### Common Array Algorithms
counting, adding, computing the min/max
### Search Algorithms
Linear search, non-recursive binary search, and non-recursive sorting algorithms (e.g. bubble sort, selection sort, insertion sort)

Compare algorithms with respect to their efficiency, elegance, and readability

