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
