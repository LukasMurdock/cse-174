# Unique

A few of these are labeled _unique_, as the way I’ve gone about solving them uses one of the following distinct methods:
- [Regular Expression](https://en.wikipedia.org/wiki/Regular_expression) (regex)
- [Bubble sorting algorithm](https://www.javatpoint.com/bubble-sort-in-java)
- Custom string repeat method (because the java version coding bat uses doesn’t have one!)
    > What we cant use in coding bat:
    > ```java
    > "hi".repeat(11)
    > ```
    > What we can use in coding bat:
    > ```java
    > new String(new char[count("hi", 11)]).replace("\0", 11)
    > ```

# Bats 🦇

## notDescending
Return true if three ints are in descending order.
- 1, 2, 3 -> false
- 3, 2, 1 -> true
- -2, -3, -4 -> true
- 1, 1, 2 -> false

```java
public boolean notDescending(int a, int b, int c) {
  return a < b || a == b
    ? false
    : b < c || b == c
      ? false
      : true;
}
```

## getSubstring

If the passed `boolean` is true, perform a normal substring.
If the passed `boolean` is false, perform a substring starting at `start` and ending at the end of the string.

```java
public String getSubstring(String str, int start, int end, boolean check) {
  return check
    ? str.substring(start, end)
    : str.substring(start, str.length());
}

```

## switchXO

Given a string, replace any "X" with "O", and any "O" with "X".

```java
public String switchXO(String str) {
  String response = "";
  for(int index = 0; index < str.length(); index++){
    if (str.charAt(index) == 'X') {
      response = response + "O";
    } 
    if (str.charAt(index) == 'O') {
      response = response + "X";
    } 
  }
  return response;
}

```

## nextDiv7

Return the first number divisible by 7 after the given number.

```java
public int nextDiv7(int given) {
  boolean found = false;
  int response = 0;
  int round = given;
  while (!found) {
    if (round % 7 == 0) {
      found = true;
      response = round;
    }
    round = round + 1;
  }
  return response;
}

```

## checknums

If boolean is true, return true if given number is in start-end inclusive.
If boolean is false, return true if given number is greater than end or less than start.

```java
public boolean checknums(int number, int start, int end, boolean isInclusive) {
  return isInclusive
    ? number >= start && number <= end
    : number < start || number > end;
    
}

```

## switchSigns

Given a string of ints separated by a space, switch flip the signs (negative to positive, positive to negative).

```java
public String switchSigns(String str) {
  
  String[] singled = str.split(" ");
  if (!str.equals("")) {
    for(int index = 0; index < singled.length; index++){
      if (!singled[index].equals("0")){
            if (singled[index].contains("-")) {
        singled[index] = singled[index].replace("-", "");
      } else {
        singled[index] = "-" + singled[index];
      }
    }
  }
  }

  
  return String.join(" ", singled);
}

```

## getSimilars

Given three strings, return all characters that appear at the same index in every string.

```java
public String getSimilars(String s1, String s2, String s3) {
  String response = "";
  String shortest = s1.length() < s2.length()
                    ? s1.length() < s3.length()
                      ? s1
                      : s3
                    : s2.length() < s3.length()
                      ? s2
                      : s3;
  for(int index = 0; index < shortest.length(); index++){
    if (
      s1.charAt(index) == s2.charAt(index)
      && s1.charAt(index) == s3.charAt(index)
    ) {
      response = response + s1.charAt(index);
    }
  }
  return response;
}

```

## separate (unique: uses regex)

Given a string, move all lowercase letters to the left.

```java
public String separate(String string) {
  // if ascii >= 65 && ascii <=90
  String response = string.replaceAll("[A-Z]", "");
  for(int index = 0; index < string.length(); index++){
    char ascii = string.charAt(index);
    if(ascii >= 65 && ascii <=90) {
      response = response + ascii;
    }
  }
  return response;
}

```

## addDivisibles

Given an int, return the sum of all _even_ divisible numbers.

```java
public int addDivisibles(int num) {
  int sum = 0;
  for(int index = num - 1; index > 0; index--){
    if(index % 2 == 0 && num % index == 0){
      sum = sum + index;
    }
  }
  return sum;
}


```

## lessPennies

Given change in dollars, return the least number of pennies needed.

```java
public int lessPennies(double change) {
  double quarter = 25;
  double dime = 10;
  double nickel = 5;
  double penny = 1;

  int totalCents = (int) Math.round(100 * change);
  int quarters = (int) ((double) totalCents / quarter);
  totalCents = (int) (totalCents % quarter);
  int dimes = (int) ((double) totalCents / dime);
  totalCents = (int) (totalCents % dime);
  int nickels = (int) ((double) totalCents / nickel);
  totalCents = (int) (totalCents % nickel);
  int pennies = totalCents;

  return pennies;
}

```

## fixSentence

Title case a string.

```java
public String fixSentence(String str) {
  String[] words = str.split(" ");
  String capitalizedWords ="";  
    for(String word:words){  
      capitalizedWords = capitalizedWords + capitalizeWord(word) + " ";
    }
  return capitalizedWords.trim();
}

public String capitalizeWord(String string){
  return string.substring(0,1).toUpperCase()
    + string.substring(1, string.length());
}
```

## pushRight

Given a string and an int, keeping the same string length, add int 0’s to the left side, “pushing” the string to the right.

```java
public String pushRight(String string, int timesToShift) {
  return (new String(new char[timesToShift]).replace("\0", "0") + string)
  .substring(0, string.length());
}

```

## genNumber

Given four booleans with values [1,2,3,4], concatenate all true booleans into a number.

- true, true, true, true -> 1234
- false, false, false, false -> 0
- true, true, false, true -> 124

```java
public int genNumber(boolean a, boolean b, boolean c, boolean d) {
  String sA = a ? "1" : "";
  String sB = b ? "2" : "";
  String sC = c ? "3" : "";
  String sD = d ? "4" : "";
  return !a&&!b&&!c&&!d
    ? 0
    : Integer.parseInt(sA + sB + sC + sD);
  
}

```

## hasOkay

Return true if given string contains "k" anywhere after "o".

```java
public boolean hasOkay(String str) {
  // contains o
  // contains k after o, not in instructions though...
  return str.contains("O")
    ? str.substring(str.indexOf("O"), str.length()).contains("k")
      || str.substring(str.indexOf("O"), str.length()).contains("K")
    : str.contains("o")
      ? str.substring(str.indexOf("o"), str.length()).contains("k")
        || str.substring(str.indexOf("o"), str.length()).contains("K")
      : false;
}
```

## threeChars

Return true if there are three or more matches of the given char in the given string.

```java
public boolean threeChars(String string, char character) {
  int count = 0;
  for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == character) {
          count++;
      }
  }
  return count >= 3;
}

```

## whatMissing

Return the first missing character alphabetically.

```java
public String whatMissing(String str) {
  return firstMissing(str);
}

public String firstMissing(String str){
  String[] array = str.split("");
  boolean hasNoMissing = true;
  int index = 1;
  String missing = "";

  while(hasNoMissing && index < array.length){
    String character = array[index];
    int previous = array[index-1].charAt(0);
    int current = character.charAt(0);
    if(current - previous > 1) {
      missing = "" + (char) (previous + (current-previous)-1);
      hasNoMissing = false;
    }
    index++;
  }

  return missing;
}
```

## addDigits (unique: uses regex)

Given a string with letters and numbers, return the sum of all positive digits.

```java
public int addDigits(String str) {
  str = str.replaceAll("[^0-9.]", "");
  String[] array = str.split("");
  int sum = 0;
  if(str.length() > 0){
    for (String i : array) {
      sum = sum + Integer.parseInt(i);
    }
  }
  return sum;
}

```

## vowelIndexes (unique: uses regex)

Given a string, return vowel indexes concatenated as a single number. Return -1 if there is no vowel.

1. Determine if a string has a vowel in it.
2. Determine if a character is a vowel.


```java
public int vowelIndexes(String str) {
  str = str.toLowerCase().replaceAll("[^aeiou]", "l");
  String strResponse = "";
  int response = -1;
  if(containsVowels(str)) {
    String[] array = str.split("");
    for(int index = 0; index < array.length; index++){
      if (isVowel((char) array[index].charAt(0))) {
        strResponse = strResponse + index;  
      }
    }
    response = Integer.parseInt(strResponse);
  }
  
  return response;
}

public boolean isVowel(char ch) {
  return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' );
}

public boolean containsVowels(String str) {
    return str.length() > 0
      ? str.contains("a") || str.contains("A")
            || str.contains("e") || str.contains("E")
            || str.contains("i") || str.contains("I")
            || str.contains("o") || str.contains("O")
            || str.contains("u") || str.contains("U")
      : false;
}
```

## exist

Given two strings, return true if the first string contains the reverse of the second string.

```java
public boolean exist(String str1, String str2) {
  return str1.contains(reverse(str2));
}

public String reverse(String string) {
  String result="";
  for(int i=string.length()-1; i>=0; i--) {
    result = result + string.charAt(i);
  }
  return result;
}
```

## getSecMax (unique: uses a sorting algorithm)

Given a string of numbers separated by space, return the second highest number.

```java
public double getSecMax(String str) {
  if (str.length() > 1){
    double[] numbers = stringToArray(str);
    return sortArray(numbers)[numbers.length - 2];
  }
  return 0.0;

}


public double[] stringToArray(String string){
  String[] items = string.split(" ");
  double[] numbers = new double[items.length];
  
  for (int i = 0; i < items.length; i++) {
    numbers[i] = Double.parseDouble(items[i]);
  }
  
  return numbers;
}

public double[] sortArray(double[] array){
    double[] arr = array;
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            double tmp = 0;
            if (arr[i] > arr[j]) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
    return arr;
}

```

## putTogether (unique: uses custom string repeat method)

Given a string, put repeated (duplicate) characters together.

```java
public String putTogether(String str) {
  if (str.length() > 0){
    String deDuped = removeDuplicates(str);
    String[] deDupedArray = deDuped.split("");
    for(int index = 0; index < deDupedArray.length; index++){
      String item = deDupedArray[index];
      deDupedArray[index] = new String(new char[count(str, item)]).replace("\0", item);
    }
    return String.join("", deDupedArray);
  }
  return "";

}

public int count(String str, String target) {
    return (str.length() - str.replace(target, "").length()) / target.length();
}

public String removeDuplicates(String string){
    String result = "";
    for (int i = 0; i < string.length(); i++) {
        if(!result.contains(String.valueOf(string.charAt(i)))) {
            result += String.valueOf(string.charAt(i));
        }
    }
    return result;
}
```

## moveLeft (unique: uses custom string repeat method)

Given a string and a char, move all chars in string to the beginning of string.

```java
public String moveLeft(String str, char ch) {
  String target = "" + ch;
  String total = new String(new char[count(str, target)]).replace("\0", target);
  return total + str.replaceAll("" + ch, "");
}

public int count(String str, String target) {
  return (str.length() - str.replace(target, "").length()) / target.length();
}
```

## maxMin (unique: uses a sorting algorithm)

Given a string of ints separated by a space, return the sum of the highest and lowest numbers.

```java
public int maxMin(String str) {
  if (str.length() > 0){
    double[] array = stringToArray(str);
    return (int) sortArray(array)[0] + (int) sortArray(array)[array.length - 1];
  }
  return 0;
}


public double[] stringToArray(String string){
  String[] items = string.split(" ");
  double[] numbers = new double[items.length];
  
  for (int i = 0; i < items.length; i++) {
    numbers[i] = Double.parseDouble(items[i]);
  }
  
  return numbers;
}

public double[] sortArray(double[] array){
    double[] arr = array;
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            double tmp = 0;
            if (arr[i] > arr[j]) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
    return arr;
}
```

## doubleHi

Given a string, return true if there are two "H" and two "I" characters in the given string.

```java
public boolean doubleHi(String str) {
  return count(str, "H") > 1 && count(str, "i") > 1;
}


public int count(String str, String target) {
    return (str.length() - str.replace(target, "").length()) / target.length();
}
```

## areLocked (unique: uses regex)

Given two doubles:
1. Test digit length is the same
    - [6.0, 2.0] -> true
    - [6.0, 30] -> false
2. Test digits at same index are both even, or both odd
    - [6.0, 2.0] -> [{6: even, 2: even}, {0: even, 0: even}] -> true
    - [6.0, 3.0] -> [**{6: even, 3: odd}**, {0: even, 0: even}] -> false

```java
public boolean areLocked(double num1, double num2) {
  // same number of digits
  // ints are both even or both odd
  // 12.31
  // 30.33
  // [12, 31]
  // [30, 33]
  // [1,2,3,1] [3,0,3,3]
  // [0,1,0,0] [0,1,0,0]
  // 0100 == 0100
  boolean passed = testDigitLength(num1, num2) && testEqualEven(num1, num2);
  return passed;
}

public boolean testEqualEven(double num1, double num2){
  String s1 = "" + num1;
  String s2 = "" + num2;
  String[] a1 = s1.replaceAll("[A-Z.]+", "").split("");
  String[] a2 = s2.replaceAll("[A-Z.]+", "").split("");
  boolean locked = false;
  int index = 0;
  while (!locked && index < a1.length) {
      if (!(Integer.parseInt(a1[index]) % 2 == Integer.parseInt(a2[index]) % 2)) {
          locked = true;
      }
      index++;
  }
  return !locked;
}

public boolean testDigitLength(double num1, double num2){
  String s1 = "" + num1;
  String s2 = "" + num2;
  String[] array1 = s1.split("\\.");
  String[] array2 = s2.split("\\.");
  boolean testDigitLength = (array1[0].length() == array2[0].length())
    && array1[1].length() == array2[1].length();
  return testDigitLength;
}

```