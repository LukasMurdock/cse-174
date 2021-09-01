## ASCII // character codes
American Standard Code for Information Interchange, is a character encoding standard for electronic communication.


## Type Casting
The simplest way to convert a floating-point value to an integer is to use a type cast, so called because it molds or “casts” a value from one type to another. The syntax for type casting is to put the name of the type in parentheses and use it as an operator.

```java
double pi = 3.14159;
int x = (int) pi;
System.out.println(x)
// 3
```

Converting to an integer it simply throws away the fractional part.

**type cast**: An operation that explicitly converts one data type into another. In Java it appears as a type name in parentheses, like (int).


## Java Final Modifier
Want a variable to never be capable of being changed? Java provides a language feature that enforces that rule, the keyword `final`.

Declaring that a variable is final means that it cannot be reassigned once it has been initialized. If you try, the compiler reports an error. Variables declared as final are called constants. 

By convention, names for constants are all uppercase, with the underscore character (_) between words.

- final `primitive variables` can be set only once (constant)
    - `final double cmPerInch = 2.54;`
- final `object variables` may be modified, final applies to object reference.
- final `fields` can be set only once (constant)
- final `methods` can’t be overridden, hidden
- final `classes` can't be extended


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

