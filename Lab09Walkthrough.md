*Want a shortcut to this page? Type in [`cse-lab8.lukas.icu`](https://cse-lab8.lukas.icu) into the search bar and it’ll redirect you here!*

*psst.* Hey, If you got more value out of this than a cup of coffee, consider buying me one.  

<a class="bmc-button" target="_blank" href="https://www.buymeacoffee.com/lukasmurdock"><img src="https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" alt="Buy me a coffee"><span style="margin-left:5px;font-size:28px !important;">Buy me a coffee</span></a>

## What you need to know / what you need to learn
- [Learn how to write conditional statements](https://github.com/LukasMurdock/cse-174/blob/main/zines/conditional-statements.png)
- [Learn how to write loops](https://github.com/LukasMurdock/cse-174/blob/main/zines/loops.png)
- Learn how to convert `int` to `String`
- Learn how to write methods

[See the current zines on Fundamentals of Programming with Java](https://github.com/LukasMurdock/cse-174/blob/main/zines.md)

## Steps
1. Write `getLetter()` method
    - 1.1 Given string, convert to ascii character
2. Write `getWord()` method
    - 2.1 Given string, call `getLetter()` on every 8 characters

## Step 1: Write `getLetter()` Method
So, here’s what we know:
- `getLetter()` receives a string
- When `getLetter()` is called, it’s saved as a `char` type. So we need to return a `char` type.

```java
public static char getLetter(String binaryCharacterString){
    char character = 'x'
    return character;
}
```

### Step 1.1: Given string, convert to ascii character
So, here’s what we know:
- `getLetter()` receives a string
- We need to convert the string from binary code to ascii
- The Java `char` type reads numbers as ascii characters

How do you convert a string of binary code to ascii?
1. Convert string to int
2. Convert int to base 2
3. Convert int to char

```java
public static char getLetter(String binaryCharacterString){
    // Read string as int base 2, then cast to char (ascii)
    char character = (char) Integer.parseInt(binaryCharacterString, 2);
    return character;
}
```

(Note: I didn’t know this conversion method beforehand. I [googled for methods](https://stackoverflow.com/questions/42032237/java-binary-translator) and then googled more to [understand the methods](https://stackoverflow.com/questions/6611824/why-do-we-need-to-use-radix-parameter-when-calling-parseint).)

## Step 2: Write `getWord()` method
So, here’s what we know:
- `getWord()` receives a string
- When `getWord()` is called, it’s saved to a `String` type. So we need to return a String.

```java
public static String getWord(String binaryCharacters){
    String word = "hello"
    return word;
}
```

### Step 2.2: Given string, call `getLetter()` on every 8 characters
So, here’s what we know:
- `getWord()` receives a string
- When `getWord()` is called, it’s saved to a `String` type. So we need to return a String.
- For every set of 8 characters in the string, we need to pass it into `getLetter()` and return all of the converted letters.


```java
public static String getWord(String binaryCharacters){
    // Get number of characters in string
    int numberOfCharacters = binaryCharacters.length() / 8;

    // Initialize word outside loop
    String word = "";

    // For the number of characters in our given string
    for(int index = 0; index < numberOfCharacters; index++) {
        // The current character binary code starts at current index * 8
        int characterStart = index * 8;

        // The binary code is 8 characters long, so the character binary code ends characterStart + 8
        int characterEnd = (characterStart) + 8;

        // Get the letter at current start and end
        String letter = binaryCharacters.substring(characterStart, characterEnd);

        // add letter to word
        word = word + getLetter(letter);
    }
    
    return word;
}
```

Don’t forget to add method comments.

## Final Code


```java
/**
 * Given a single binary character as a string, returns the character code.
 *
 * @param binaryCharacter a string holding a single binary character
 * @return a char with the converted binary character.
 */
public static char getLetter(String binaryCharacterString){
    char character = (char) Integer.parseInt(binaryCharacterString, 2);
    return character;
}

public static String getWord(String binaryCharacters){
    int numberOfCharacters = binaryCharacters.length() / 8;
    String word = "";

    for(int index = 0; index < numberOfCharacters; index++) {
        int characterStart = index * 8;
        int characterEnd = characterStart + 8;
        String letter = binaryCharacters.substring(characterStart, characterEnd);
        word = word + getLetter(letter);
    }
    
    return word;
}
```