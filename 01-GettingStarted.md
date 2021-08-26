# Getting Started

A few key questions to start us off (oh boy (girl, cat, or squirrel) do I hope you were asking these):
- Where does code run?
- How does code run?

Keywords that you will soon forget!:
- Compiler
- Java Development Kit (JDK)
- Java Runtime Environment (JRE)
- Java Virtual Machine (JVM)
- Integrated Development Environment (IDE)


## Where does code run?

We call the places code runs a **runtime**. It has this special name because to properly run a coding language, the *runtime* has to have the proper code to implement the features of the coding language itself.

You can think of the *runtime* as code on a machine that enables it to read a particular coding language.

For example, if we image humans as machines and the English language as a, well, language, then we can imagine the runtime–where the code runs–as our brains. But, while every human has a brain, not every human brain has the proper knowledge to run the English language!

To run Java on a machine it must have the **Java Runtime Environment (JRE)**. In the case of a language like JavaScript, (which has about as much relation to Java as English does to Chinese–that is to say, no relation) the runtime is within browsers like Chrome (V8), Safari (WebKit JavaScriptCore), or Firefox (SpiderMonkey) (or Node || Deno if you’re running it on a Server, and if you don’t know what those are, safely ignore this comment).

The JRE takes takes any `.java` files we write and uses a development tool that is a part of the Java Development Kit (JDK), which is a specific implementation of Java with it’s own compiler. To give another example, the different browsers listed above all use their own implementation of JavaScript! (again, no relation to Java). This means that some JavaScript methods will work in Chrome, but not in Safari–I love Web Development!

The JRE contains the **Java Virtual Machine (JVM)**, class libraries, and other supporting files.

But just as you can have the proper knowledge to *run* the English language, actually running it is a different story. That’s where the **Java Virtual Machine (JVM)** comes in. JVM is able to run interprets and translate Bytecode into Native Machine Code Java programs and it uses the class libraries, and other supporting files provided in JRE.

Don’t understand?

Great! Me neither. That’s what an Integrated Development Environment (IDE) is for–an IDE combines developer tools into a single application. Just remember this next part.

So, where does code run? Aside from “wherever there is a runtime and the code is run,” we can also say:
- Code runs when it’s *compiled*
- Code runs at *runtime*.

You know what this means? Two places where code runs means there are two places we can get errors. Yay!

Luckily they’re referred to as `compiler errors` and `runtime errors`. But, we like to have multiple names so here we go:
- Compiler error: syntax error
- Runtime error: logic error, exception error

## How does code run?

I mean if we’re being honest, there’s only one answer: magic. Okay, I lied, there’s another answer: I don’t care, as long as it do. But, for the sake of learning I guess we can find yet another answer…

But, like, I really don’t care, so…

Here’s an image from the internet.

![](https://sp-ao.shortpixel.ai/client/to_avif,q_glossy,ret_img,w_839/https://simplesnippets.tech/wp-content/uploads/2018/03/java-execution-flow-diagram.png)

1. Compile step: `JavaClass.java` Java -> Compiler -> `JavaClass.class` Bytecode
2. Run step: `JavaClass.class` Bytecode -> JVM -> Runtime (Yo code is runnin bb)

The compile step is kinda like how you can’t read the next volume of your favorite series because it was written in another language, so you have to get a version converted into a language that you can read. Once you have the compiled version you can run it. Without the compile step, ya can’t do nothin with it.

## Okay IDK, IDE?

Yes, more terms, gotta love learning the *jargon*. At least you don’t have to learn [Geek Code](https://www.geekcode.xyz/geek.html). Integrated Development Environments (IDEs) are not required to code–but they make some things easier! They bundle a lot of otherwise manual work into an easier flow.

Popular Java IDEs include:
- Eclipse
- IntelliJ Idea
- NetBeans
- BlueJ
- jGRASP
- DrJava

Does your IDE really matter? **No**. But as a Pragmatic Programmer, you must learn your tools and make them your own. Development environments are customizable, customize yours. Pick a theme, pick a font, it’s your world to make.

## Help, I Can’t Read This \@\#\$\&ing \+\%\$\#

```java
// JavaClass.java
public class JavaClass {
    public static void main(String[] args) {
        System.out.println("Sir, this is a Wendy’s.");
    }
}

// Sir, this is a Wendy’s
```

*Deep breath*. *Inhale*. *Exhale*.

This, fellow human,  
is the wonderful *Java*.  
Take it all in, please.

Java is verbose–it took 17 words, just so we could output 5.

### Object-ion!

You know what an object is. An object is something visible or tangible–our physical world is made of of objects. And objects are made up of smaller objects. A car is an object, an object with an engine, tires, and other objects–and it’s turtles all the way down (they’re all objects). And if you’re a mechanic, someone who works with the car object, you have to *understand the object*.

Welcome to Java-land! It’s also made up of objects, but instead of having the object definitions be limited by physics, instead, in Java-land, objects are only limited by our *imagination*.

Now the `class` in the code above is an object too, so let’s rewrite it.

```java
// JavaClass.java
public class Car {
    public static void main(String[] args) {
        System.out.println("This doesn’t seem very… you know… car like…");
    }
}

// This doesn’t seem very… you know… car like…
```

Right, so what’s all that `main(…) {…}` business?

The `main(…) {…}` block is what is called a **method** (aka a function)

A method is a block of code which only runs when it is called. The `main()` method is required and you will see it in every Java program. Any code inside the `main()` method will run. You don't have to understand the keywords before and after main *yet*. We’ll get into that soon enough.

You can pass objects, into methods (which are objects themselves, more on this in a bit).

Why use methods? To reuse code: define the code once, and use it many times. In this case, we apparently want to create multiple cars.

I no longer like this example, so I’m going to rewrite it again to be a calculator. Coding makes it easy to not repeat yourself, say you don’t want to remember how to add and subtract, you can just abstract that math into a method and then you’ll never have to think about it again!

```java
// JavaClass.java
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

// 420
// 69
```

*Are ya feeling it?* Give it a bit more. Let’s keep moving.

You can see I’ve added two new methods, `addNumbers()` and `subtractNumbers()`. They seem to take in two variables that you state when you call the function (reminder: methods are functions) like so `addNumbers(2, 2)`. The function then simply returns the result of the two variables added or subtracted together.

You see how we can call `addNumbers()` multiple times and not have to add more code to handle the addition of numbers? While this is a simple example, this is an *extremely* common code pattern–[Don’t Repeat Yourself](https://deviq.com/principles/dont-repeat-yourself)!

! Except the `subtractNumbers()` function isn’t subtracting! We wouldn’t receive an error anywhere for this, there’s nothing wrong with the syntax. The error is in the *logic*, and logic is left up to us humans to verify if it’s correct or not. 

Just to continue your inundation, if we were to rewrite this in JavaScript, it might look something like this (You can do classes in JavaScript, but I… don’t):

```javascript
// JavaScriptFunction.js
const calculator = {
    addNumbers: function(x, y) {
        return x + y;
    },
    subtractNumbers: function(x, y) {
        return x - y;
    }
}

console.log(calculator.addNumbers(2, 4))
console.log(calculator.subtractNumbers(2, 4))

// 6
// -2
```

## Data Types

Maybe you’re starting to notice some interesting patterns. Coding languages have data types built in to the language that always have a value. For example, Java has the following **primitive types**:
- byte (Stores whole numbers from -128 to 127)
- short (Stores whole numbers from -32,768 to 32,767)
- int (Stores whole numbers from -2,147,483,648 to 2,147,483,647)
- long (Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
- float (Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits)
- double (Stores fractional numbers. Sufficient for storing 15 decimal digits)
- boolean (Stores true or false values)
- char (Stores a single character/letter)

In contrast, JavaScript has the following primitive types:
- string (Stores text)
- number (Stores numbers between -(2^53 − 1) and 2^53 − 1))
- bigint (Stores numbers beyond the safe integer limit for the number type)
- boolean (Stores true or false values)
- undefined (A variable that has not been assigned a value has the value undefined)
- symbol (Honestly, I have no idea)
- null (the only value of its own type. However, null is a fat liar. Due to a [bug](https://2ality.com/2013/10/typeof-null.html) in JavaScript, it pretends to be an object)

Java is statically-typed, so it expects its variables to be declared before they can be assigned values. Whereas JavaScript is dynamically typed, and checks variable types at runtime.

This is why the function in Java has specified types: `addNumbers(int x, int y)` but the function in JavaScript does not `addNumbers(2, 4)`.

However, typechecking at compile time catches some nice errors. To make it a bit closer to the Java code, we can use TypeScript–a superset of JavaScript (all JavaScript is valid TypeScript) that adds type checking at compile time. Here’s the same code but in TypeScript.

```typescript
// TypeScriptFunction.ts
const calculator = {
  addNumbers: function (x: number, y: number): number {
    return x + y;
  },
  subtractNumbers: function (x: number, y: number): number {
    return x - y;
  },
};

console.log(calculator.addNumbers(2, 4));
console.log(calculator.subtractNumbers(2, 4));

// 6
// -2
```

Now we have types specified! Hopefully you see a few patterns of code here:
- Values and variables
- Primitive values (primitive types!)
- Objects and methods (aka functions)
    - Functions can accept objects
    - Functions can return objects

Now, it’s time to introduce non-primitive values—types that let us make our own values.

In Java a few non-primitive data types are:
- class
- object
- array
- string
- interface

Bringing back the Java code for our basic calculator:

```java
// JavaClass.java
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

// 420
// 69
```

You can see that *we* are creating the value for the `class` Calculator and the object methods `addNumbers()` and `subtractNumbers()`. Whenever we use primitive types, you can imagine that we’re merely *summoning* the values from Java-land, instead of *creating* them. All numbers already exist within Java-land. When we use `400`, `20`, `60`, `9`, we’re just *summoning* those values–we can change what number we use from `400` to `20` but we cannot change the value of the number `400` to `20`. However, with non-primitives, such as our `addNumbers()` object, we *can* change the value of it–that let’s us do cool coding things!

## Operators

You know what mathematical operations like addition (+), subtraction (-), multiplication (*), division (/), equal (=), not-equal (!=), greater than (>), less than (<), greater than or equal to (<=), and less than or equal to (>=).

These operators exist in coding languages as well to perform operations on variables and values. In Java they look like the following:

### Java Arithmetic Operators
Arithmetic operators are used to perform common mathematical operations.

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
Comparison operators are used to compare two values.


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
Logical operators are used to determine the logic between variables or values.

| Operator | Name        | Description                                             | Example            |
|:--------:|-------------|---------------------------------------------------------|--------------------|
| &&       | Logical and | Returns true if both statements are true                | x < 5 &&  x < 10   |
| \|\|     | Logical or  | Returns true if one of the statements is true           | x < 5 \|\| x < 4   |
| !        | Logical not | Reverse the result, returns false if the result is true | !(x < 5 && x < 10) |

## Code Comments
Honestly, I’m just gonna plug Stack Overflows [Best practices for writing code comments](https://stackoverflow.blog/2021/07/05/best-practices-for-writing-code-comments/).

- Rule 1: **Comments should not duplicate the code**.
- Rule 2: **Good comments do not excuse unclear code**.
- Rule 3: **If you can’t write a clear comment, there may be a problem with the code**.
- Rule 4: **Comments should dispel confusion, not cause it**.
- Rule 5: **Explain unidiomatic code in comments**.
- Rule 6: **Provide links to the original source of copied code**.
- Rule 7: **Include links to external references where they will be most helpful**.
- Rule 8: **Add comments when fixing bugs**.
- Rule 9: **Use comments to mark incomplete implementations**.

Now, go read it.

## Vocab Review

**Compiler**: translates computer code from one language (the source language) to another language (the target language).

**Java Development Kit (JDK)**: Includes the Java Compiler, JRE, and other development tools into one nice package.

**Java Runtime Environment (JRE)**: Provides class libraries and other resources a Java program needs to run.

**Java Virtual Machine (JVM)**: The run-time engine that runs Java applications.

**Integrated Development Environment (IDE)**: An application that consolidates basic tools required to write and test software.

**Syntax**: The rules of the language.

**Semantics**: The meaning of the words used in the language.

**Data Types**: 
- Primitive Data Types:
    - byte (Stores whole numbers from -128 to 127)
    - short (Stores whole numbers from -32,768 to 32,767)
    - int (Stores whole numbers from -2,147,483,648 to 2,147,483,647)
    - long (Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
    - float (Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits)
    - double (Stores fractional numbers. Sufficient for storing 15 decimal digits)
    - boolean (Stores true or false values)
    - char (Stores a single character/letter)
- Non-primitive Data Types:
    - String (Stores text)
    - Array (Stores multiple objects in a single variable)
    - Class