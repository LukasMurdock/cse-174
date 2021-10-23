Key concepts:
- Expressions: The representation of a value
- Variables: Same as math, it’s useful to have a quantity which admits of an infinite number of values in the same expression
- Types: Characters are not numbers*
- Operators: More than just math
- Arrays: "Put in order"
- Loops: It’s useful to have something to run until we say stop
- Scope: It’s useful to have things only exist in a scope (e.g. variable
index)
- Methods: It’s useful to have easily reusable code
- Objects: It’s useful to encapsulate methods
- Classes: It’s useful to construct new objects

Resources:
- [Learn Java in 14 minutes](https://youtu.be/RRubcjpTkks)
- [w3](https://www.w3schools.com/java/)
- https://www.codecademy.com/learn/learn-java
- https://www.learnjavaonline.org/

# Getting Started With Programming

You know how to use a phone. You know how to interact with it and you can recreate its behavior in your mind–easy.

That confidence and experience came from hours, endless hours, of _working with it_.

It’s the same with programming.

It’s confusing at first. Sometimes nothing makes sense. You’ll read the code again and again, unable to find any mistake as the voice in your head becomes overbearing.

_I don’t know what I’m doing._

_Will I ever get good at this?…_

### Don’t panic
We all guess when reading code. But to gain confidence, you need more than that.

You need to _see_ what happens as your program runs. So, you have some work to do, because, you need to think in code.

### You have to do it
No one learns to ride a bike from a book, or even a video. You learn by doing it. Actually, by _not_ doing it. You learn by doing it wrong, by falling off, by getting back on, by doing it again.

If you want to learn it, you have to do it.

### You have to discover and build your programming mental models.

Just like how you can easily recreate the interactions with a phone in your mind, you’re going to build mental models that will enable you to easily recreate the interactions of a program in your mind.

But first, a question.

## Part 1: What is code?
Etymologically (in a way that relates to the origin and history of words), code is a _systematic compilation of laws_.

And the oldest known law code is the [Code of Ur-Nammu](https://en.wikipedia.org/wiki/Code_of_Ur-Nammu).

But that’s not quite the code we will be talking about today.

The code we’re going to talk about today can still be considered a _systematic compilation of laws_, but more specifically it is a system of laws to express information and instructions to computers and other humans.

_Program_ comes from the meaning “a definite line of procedure prepared or announced beforehand”.

And by the end of this, I hope to instill you with the confidence to call yourself a programmer–one who creates programs.

There are many galaxies in the coding universe. Depending on the paths you take, you may visit many of them or focus on just one.

Regardless of the _language_, the principles, the fundamentals of programming are largely the same.

You may think of programming as _writing code_. But, in reality, programming is much more about _reading code_.

Code is read by _both_ computers and other humans.

However, computers don’t read code like we do. Computers don’t have to guess the meaning of code from variable names or by noticing patterns. Computers read code according to the rules created by other humans decades ago.

Code is similar to this language (English)–in fact they’re called coding _languages_.

And as you know, different languages are used in different areas. But the basics of every languages are mostly the same.

## Expressions: The representation of a value
You know expressions.

Expressions like:
- 2+2
- 2*2
- 2/2

And you know expressions _result_ in a value.
- 2+2 (4)
- 2*2 (4)
- 2/2 (1)

In the Java Universe, we can call _anything that results in a value_ an expression.

And just like in math, we can store expressions in _variables_.

## Variables
You know variables.

Variables like:
- x
- y
- m
- b

And you know that *variables represent a value or expression*, like:
- a = 24
- x = 2+2
- y = mx+b

And you also know that *the value variables represent can change*. The value of `x` is often assigned many numbers while an expression is run again and again.

In the Java Universe, we can name variables just about anything we want. And because programmers care about readability, we want to make our variable names meaningful!

I don‘t really know what `y = mx+b` is. That literally reads as a bunch of letters.

In Java, we can make our variables have meaningful names like: `yCoordinate = (slope * xCoordinate) + yIntercept`

Now, numbers are useful, but we want to deal with more than just numbers.

So code has _types_.

## Types: Characters are not numbers*
Coding is about solving problems. But not all problems are number problems!

What if we want to add _characters_? The values in math are primarily numbers, but characters are not numbers.

To handle this, Java has _primitive types_.

Taking our variable and expression examples before, we can give them the primitive type of `int`, short for Integer and represents a whole number in Java.

```java
int slope = 10;
int xCoordinate = 12;
int yIntercept = 4;
int yCoordinate =  (slope * xCoordinate) + yIntercept;
```

But, to handle literal characters like 'x' and 'y', Java has the primitive type `char`. Java still stores the value of characters as numbers, ASCII codes to be precise, but it enables us to do things with characters!

```java
char iAmAChar = 'x';
```

You may have noticed I said that the `int` type can only handle _whole numbers_. In Java, there are actually six different primitive number types!

- `byte`: for storing whole numbers from -128 to 127
- `short`: for storing whole numbers from -32,768 to 32,767
- `int`: for storing whole numbers from -2,147,483,648 to 2,147,483,647
- `long`: for storing whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
- `float`: for storing numbers up to 6 to 7 decimal digits
- `double`: for storing numbers up to 15 decimal digits

Don’t let that stress you out though. For the most part, you’ll only use the `int` and `double` primitive number types.

And there are two more primitive types:
- `char`: stores a single character or ASCII values
- `boolean`: stores true or false values

So in total, there are eight primitive Java types.

```java
byte iAmBelow127 = 126;
short iAmBelow32767 = 32766;
int iAmBelow2_15Mil = 2;
long iAmBigNumber = 9_223_372_036_854_775_800;
float iStoreUpTo7Digits = 3.141592;
double iStoreUpTo15Digits = 3.14159265358979;
char iAmAChar = 'x';
boolean truthyFalsey = true;
```

And remember, these can be expressions!

```java
byte iAmBelow127 = 122 + 4;
short iAmBelow32767 = 30000 + 766;
int iAmBelow2_15Mil = 4 / 2;
long iAmBigNumber = 9_223_372_036_854_775_800;
float iStoreUpTo7Digits = 22 / 5;
double iStoreUpTo15Digits = 22 / 5;
char iAmAChar = 'x';
boolean truthyFalsey = (iAmBelow127 > iAmBelow127);
```

<!-- Perfect time for a syntax quiz? -->

### Primitive types?
You’re probably wondering why I’ve been saying “primitive” types.

The alternative to a primitive type is a _reference type_. The basic difference is that primitive variables store the actual values, whereas reference variables store the addresses of the objects they refer to.

You’re also probably wondering why up till now we’ve only been able to store single characters in Java–isn’t that pretty pointless? We want to use _words_!

Java provides a String _class_ to handle this (don’t worry, we’ll talk about classes in Java soon!).

```java
String firstWords = "Hello World!";
```

You may have noticed that unlike the primitive types that were lowercase, the type declaration for a string was capitalized. Again, this is because the string type is a reference type.

And remember: variables can store expressions!

```java
String firstWords = "Hello " + "World" + "!";
```

## Operators: More than just math
Just like how you had to learn addition, subtraction, multiplication, division, and other operations for math, code has it’s own set of operators.

And just like how you had to do a lot of multiplication and division before you understood them, don’t expect to memorize the meaning of all operations!

The memory comes with usage over time. And Google is always there to help you remember.

In Java they look like the following:

### Java Arithmetic Operators
Arithmetic operators are used to perform common mathematical operations and return a numerical value.

| Operator | Name           | Description                            | Example |
|:--------:|----------------|----------------------------------------|---------|
| +        | Addition       | Adds together two values               | x + y   |
| -        | Subtraction    | Subtracts one value from another       | x - y   |
| *        | Multiplication | Multiplies two values                  | x * y   |
| /        | Division       | Divides one value by another           | x / y   |
| %        | Modulus        | Returns the division remainder         | x % y   |
| ++       | Increment      | Increases the value of a variable by 1 | ++x     |
| --       | Decrement      | Decreases the value of a variable by 1 | --x     |

### Java Comparison Operators
Comparison operators are used to compare two values and return a boolean value.


| Operator | Name                     | Example |
|:--------:|--------------------------|---------|
| ==       | Equal to                 | x == y  |
| !=       | Not equal                | x != y  |
| >        | Greater than             | x > y   |
| <        | Less than                | x < y   |
| >=       | Greater than or equal to | x >= y  |
| <=       | Less than or equal to    | x <= y  |

### Java Assignment Operators
Assignment operators are used to assign values to variables.

| Operator | Example | Same as    |
|:--------:|---------|------------|
| =        | x = 5   | x = 5      |
| +=       | x += 3  | x = x + 3  |
| -=       | x -= 3  | x = x - 3  |
| /=       | x /= 3  | x = x / 3  |
| &=       | x &= 3  | x = x & 3  |
| \|=      | x \|= 3 | x = x \| 3 |
| ^=       | x ^= 3  | x = x ^ 3  |
| >>=      | x >>= 3 | x = x >> 3 |
| <<=      | x <<= 3 | x = x << 3 |

### Java Logical Operators
Logical operators are used to determine the logic between variables or values and return a boolean `true` or `false`.

| Operator | Name        | Description                                             | Example            |
|:--------:|-------------|---------------------------------------------------------|--------------------|
| &&       | Logical and | Returns true if both statements are true                | x < 5 &&  x < 10   |
| \|\|     | Logical or  | Returns true if one of the statements is true           | x < 5 \|\| x < 4   |
| !        | Logical not | Reverse the result, returns false if the result is true | !(x < 5 && x < 10) |

Again, don’t feel the need to memorize the meaning of all operations right now!

The memory comes with usage over time. And Google is always there to help you remember.

## Arrays: "Put in order"
What if we want to store multiple numbers into a single variable?

For example, what if we wanted to have a list of numbers that represent the scores we’ve received on each assignment?

Code enables us to do this with _Arrays_. And arrays in Java are expressed in the type by adding `[]` to the end of the type of the items that will be in the array.

```java
int[] arrayOfGrades = {100, 42, 69};
```

We can _access_ the values in our array by calling it’s position (referred to as index) in the array.

```java
String[] arrayOfStrings = {"Hello", "World", "!"};
int[] arrayOfGrades = {100, 42, 69};
int firstGrade = arrayOfGrades[0];
```

Do you see how arrays save us from having to declare a variable to store each grade?

And you may have noticed, **array positions (index) start at 0**.

We can change the value of an item in our array, just like any other variable.

```java
int[] arrayOfGrades = {100, 42, 69};
int firstGrade[1] = 100;
```

Now, what if we want to add 2 to every item in our array? To rephrase, we want to loop through every index of our array and add 2 to the value.

## Loops: It’s useful to have something to run until we say stop
Here’s how we could add 2 to every item in our array.

```java
int[] arrayOfGrades = {100, 42, 69};
int index = 0;
while(index < arrayOfGrades.length){
    index = index + 1; // increase index every loop
    arrayOfGrades[index] = arrayOfGrades[index] + 2;
}
```

Reading this in English could sound like this:
1. Create an array of 3 integers
2. As our array item index starts at zero, we can create an index variable and assign it to zero.
3. While the index variable is less than the length of our array, increase the index by 1 every loop and add 2 to the value at the current array index.

This loop format is so common, where we want to loop through something with a known length, that there is more condensed loop called a for loop.

Here’s how the above would look as a for loop.

```java
int[] arrayOfGrades = {100, 42, 69};
for(int index = 0; index < arrayOfGrades.length; index = index + 1){
    arrayOfGrades[index] = arrayOfGrades[index] + 2;
}
```

The code is the same, but the for loop contains all the loop logic inside the for loop statement.

But there’s another big difference between these loops.

You may have noticed the pattern difference between the for and while loops:
1. Index and array variable declarations
    - While loop: **declared before** the while loop
    - For loop: **declared in** the for loop statement
2. Increment index
    - While loop: increment index **inside the while loop code block{}**
    - For loop: increment index **inside the for loop statement()**

This has to do with _scope_.

## Scope: It’s useful to have things only exist in a scope (e.g. variable index)
Variables declared in a code block `{}`, stay in that code block `{}`.

We cannot access variables outside the _scope_ of the current code block `{}`.

We couldn’t declare the index variable inside the while loop, because then we wouldn’t be able to access it in the while conditional.

```java
int[] arrayOfGrades = {100, 42, 69};
while(index < arrayOfGrades.length){ // would not work
    int index = 0; 
    index = index + 1;
    arrayOfGrades[index] = arrayOfGrades[index] + 2;
}
```

Similarly, because the for loop statement scopes the index variable to that specific for loop code block, we can create other variables with the name index.


```java
int[] arrayOfGrades = {100, 42, 69};
for(int index = 0; index < arrayOfGrades.length; index = index + 1){
    arrayOfGrades[index] = arrayOfGrades[index] + 2;
}
// using the same variable name, but in a different scope, so it’s fine!
for(int index = 0; index < arrayOfGrades.length; index = index + 1){
    arrayOfGrades[index] = arrayOfGrades[index] + 2;
}
```

## Methods: It’s useful to have easily reusable code

You know what sucks? When you’re in math class and you have to write down the same expression over and over and over again.

It also sucks having to write the same code over and over and over again.

Programmers have a principle called [Don’t Repeat Yourself](https://deviq.com/principles/dont-repeat-yourself) (DRY).

Say, for example, you wrote some code to solve a Pythagorean theorem.

```java
double triangleSideA = 10;
double triangleSideB = 12;
double triangleSideC = Math.sqrt(triangleSideA*triangleSideA + triangleSideB*triangleSideB);
// triangleSideC = 15.620499351813308
```

It would really suck if you had write `Math.sqrt(triangleSideA*triangleSideA + triangleSideB*triangleSideB)` every time you wanted to calculate the Pythagorean theorem.

So, to not repeat ourselves, we can create a **method**.

```java
public static double getPythagoreanTheorem(double triangleSideA, double triangleSideB) {
    return Math.sqrt(triangleSideA*triangleSideA + triangleSideB*triangleSideB);
}
// getPythagoreanTheorem(10, 12) = 15.620499351813308
```

## Class
Triangle class

```java
public class Triangle {
    // declare Triangle object variables
    private double sideA;
    private double sideB;
    private double sideC;

    // create constructor method
    Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        calculateUnknownSide();
    }

    
    public void calculateUnknownSide(){
        if (this.sideA == 0) {
            calculateSideA();
        }
        if (this.sideB == 0) {
            calculateSideB();
        }
        if (this.sideC == 0) {
            calculateSideC();
        }
    }

    // a*a + b*b = c*c
    public void calculateSideA() {
        this.sideA = Math.sqrt(this.sideC*this.sideC - this.sideB*this.sideB);
    }

    // a*a + b*b = c*c
    public void calculateSideB() {
        this.sideB = Math.sqrt(this.sideC*this.sideC - this.sideA*this.sideA);
    }

    // a*a + b*b = c*c
    public void calculateSideC() {
        this.sideC = Math.sqrt(this.sideA*this.sideA + this.sideB*this.sideB);
    }

    public double getSide(char side) {
        return side == 'A'
                ? this.sideA
                : side == 'B'
                    ? this.sideB
                    : this.sideC;
    }
}
```

Using this class, we can now easily create new triangle objects and get the the unknown side.

```java
class Main {
    public static void main(String[] args){

        Triangle firstTriangle = new Triangle(12, 10, 0);
        System.out.println(firstTriangle.getSide('C'));

        Triangle secondTriangle = new Triangle(3, 4, 0);
        System.out.println(secondTriangle.getSide('C'));
        
    }
}
```