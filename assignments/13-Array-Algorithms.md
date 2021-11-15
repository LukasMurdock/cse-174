## Insert

```java
public int[] insert(int[] arr, int switchIndex, int insertValue) {
  int[] newArray = new int[arr.length + 1];
  boolean swapped = false;
  for(int index = 0; index < newArray.length; index++){
    if (index == switchIndex) {
      newArray[index] = insertValue;
      swapped = true;
    } else {
      newArray[index] = swapped
      ? arr[index-1]
      : arr[index];
    }
  }
  
  return newArray;
}
```

## Remove

```java
public int[] remove(int[] arr, int removeIndex) {
  int[] newArray = new int[arr.length - 1];
  boolean removed = false;
  
  for(int index = 0; index < arr.length-1; index++){
    if (index == removeIndex) {
      removed = true;
      newArray[index] = arr[index+1];
    } else {
      newArray[index] = removed
      ? arr[index+1]
      : arr[index];
    }
  }
  
  return newArray;
}
```

## getSingleNum
For every index, for every element, check if equal. If not equal, it’s our boi.

```java
public int getSingleNum(int[] arr) {
  
  int firstNotDuplicated = -1;
  boolean foundFirst = false;
  int index = 0;

  while (!foundFirst && index < arr.length){
    if(!isDuplicated(arr[index], arr)){
      foundFirst = true;
      firstNotDuplicated = arr[index];
    }
    index++;
  }

  return firstNotDuplicated;
}

public boolean isDuplicated(int number, int[] array) {
    int count = 0;

    for (int index = 0; index < array.length; index++) {
        if (array[index] == number) {
            count++;
        }
    }

    return count > 1;
}
```

## returnBooleanArray
Return true if array 2 contains element in array 1

```java
public boolean[] returnBooleanArray(int[] arr1, int[] arr2) {
  boolean[] booleanArray = new boolean[arr1.length];

  for(int index = 0; index < arr1.length; index++){
    booleanArray[index] = contains(arr1[index], arr2);
  }
  
  return booleanArray;
}



public boolean contains(int number, int[] array) {
    int count = 0;
  
    for (int index = 0; index < array.length; index++) {
        if (array[index] == number) {
            count++;
        }
    }

    return count > 0;
}
```