# Getting Started

A few key questions to start us off (oh boy (girl, cat, or squirrel) do I hope you were asking these):
- Where does code run?
- How does code run?

Keywords that you will soon forget!:
- Compiler
- Java Development Environment (JDK)
- Java Runtime Environment (JRE)
- Java Virtual Machine (JVM)
- Integrated Development Environment (IDE)


## Where does code run?

We call the places code runs a **runtime**. It has this special name because to properly run the code, the *runtime* has to have the proper code to implement the features of the coding language itself.

You can think of the *runtime* as code on a machine that enables it to read a particular coding language.

For example, if we image humans as machines and the English language as a, well, language, then we can imagine the runtime–where the code runs–as our brains. But, while every human has a brain, not every human brain has the proper knowledge to run the English language!

To run Java on a machine it must have the **Java Runtime Environment (JRE)**. In the case of a language like JavaScript, (which has about as much relation to Java as English does to Chinese–that is to say, no relation) the runtime is within browsers like Chrome (V8), Safari (WebKit JavaScriptCore), or Firefox (SpiderMonkey) (or Node || Deno if you’re running it on a Server, and if you don’t know what those are, safely ignore this comment).

The JRE takes takes any `.java` files we write and uses a development tool that is a part of the Java Development Kit (JDK), which is a specific implementation of Java with it’s own compiler. To give another example, the different browsers listed above all use their own implementation of JavaScript! (again, no relation to Java). This means that some JavaScript methods will work in Chrome, but not in Safari–I love Web Development!

The JRE contains the **Java Virtual Machine (JVM)**, class libraries, and other supporting files.

But just as you can have the proper knowledge to *run* the English language, actually running it is a different story. That’s where the **Java Virtual Machine (JVM)** comes in. JVM is able to run interprets and translate Bytecode into Native Machine Code Java programs and it uses the class libraries, and other supporting files provided in JRE.

Don’t understand?

Great! Me neither. Just remember this next part.

So, where does code run? Aside from “wherever there is a runtime and the code is run,” we can also say:
- Code runs when it’s *compiled*
- Code runs at *runtime*.

You know what this means? Two places where code runs means there’s two places we can get errors. Yay!

Luckily they’re referred to as `compiler error` and `runtime errors`. But, we like to have multiple names so here we go:
- Compiler error: exception error, syntax error
- Runtime error: logic error

## How does code run?

I mean if we’re being honest, there’s only one answer: magic. Okay, I lied, there’s another answer: I don’t care, as long as it do. But, for the sake of learning I guess we can find yet another answer…

But, like, I really don’t care, so…

Here’s an image from the internet.

![](https://sp-ao.shortpixel.ai/client/to_avif,q_glossy,ret_img,w_839/https://simplesnippets.tech/wp-content/uploads/2018/03/java-execution-flow-diagram.png)

1. Compile step: `JavaClass.java` Java -> Compiler -> `JavaClass.class` Bytecode
2. Run step: `JavaClass.class` Bytecode -> JVM -> Runtime (Yo code is runnin bb)

The compile step is kinda like how you can’t read the next volume of your favorite series because it was written in another language, so you have to get a version converted into a language that you can read. Once you have the compiled version you can run it. Without the compile step, ya can’t do nothin with it.

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

You can pass data, known as parameters, into methods.

Why use methods? To reuse code: define the code once, and use it many times. In this case, we apparently want to create multiple cars.

I no longer like this example, so I’m going to rewrite it again to be a calculator.

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

You see how we can call `addNumbers()` multiple times and not have to add more code to handle the addition of numbers? While this is a simple example, this is an *extremely* common code pattern–Don’t Repeat Yourself!

! Except the `subtractNumbers()` function isn’t subtracting! We wouldn’t receive an error anywhere for this, there’s nothing wrong with the syntax. The error is in the `logic`, and logic is left up to us humans to verify if it’s correct or not. 

## Comments
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

