```java
public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int iMin = i;
        // finding the index of the minimum value
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[iMin]) {
                iMin = j;
            }
        }
        // swapping if needed
        if (iMin != i) {
            int temp = arr[iMin];
            arr[iMin] = arr[i];
            arr[i] = temp;
        }
    }
}

public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int next = arr[i];
        // Moving all larger elements to the end if needed
        int j = i;
        while (j > 0 && arr[j - 1] > next) {
            arr[j] = arr[j - 1]; // move to the right
            j--;
        }
        // Insert the element
        arr[j] = next;
    }
}

public static void bubbleSort(int[] arr) {
    boolean madeSwap;
    do {
        madeSwap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            // compare side by side elements
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                madeSwap = true;
            }
        }
    } while (madeSwap);
}

public static int[] clone(int[] arr) {
    int[] newArr = new int[arr.length];
    for (int i = 0; i < arr.length; ++i) {
        newArr[i] = arr[i];
    }
    return newArr;
}

public static int linearSearch(int[] array, int numberToFind) {
    for (int index = 0; index < array.length; index++) {
        if (array[index] == numberToFind) {
            System.out.printf("Key found after %s comparison\n", index + 1);
            return index;
        }
    }
    System.out.printf("Key is found after %s comparison\n", customers.length);
    return -1;
}

public static int binarySearch(int[] array, int numberToFind) {
    int lower = 0;
    int higher = array.length - 1;

    int count = 0;
    while (lower <= higher) {
        count++;
        int middle = (lower + higher) / 2;
        if (array[middle] == numberToFind) {
            System.out.printf("Key found after %s comparison\n", count);
            return middle;
        } else if (numberToFind > array[middle]) {
            lower = middle + 1;
        } else if (numberToFind < array[middle]) {
            higher = middle - 1;
        }
    }
    System.out.printf("Key found after %s comparison\n", count);
    return -1;
}

public static int countString(String str, String target) {
    return (str.length() - str.replace(target, "").length()) / target.length();
}

public static int countNumber(int[] array, int number) {
  int count = 0;
  for(int checkNumber: array){
    if(checkNumber == number){
      count++;
    }
  }
  return count;
}

public static boolean isDuplicated(int number, int[] array) {
    int count = 0;
    for (int index = 0; index < array.length; index++) {
        if (array[index] == number) {
            count++;
        }
    }
    return count > 1;
}

public static boolean contains(int number, int[] array) {
    int count = 0;
    for (int index = 0; index < array.length; index++) {
        if (array[index] == number) {
            count++;
        }
    }
    return count > 0;
}

public static int[] reverseArray(int[] nums) {
  if (nums.length > 1){
    int[] reverseArray = new int[nums.length];
    for(int index = 0; index < nums.length; index++){
      reverseArray[nums.length - 1 - index] = nums[index];
    }
    return reverseArray;
  }
  return nums;
}

```
