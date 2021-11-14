
public class Lab12 {

    public static int getNumRows(int[][] array) {
        return array.length;
    }

    public static int getRowLength(int[][] array, int row) {
        return (row < 0 || row >= array.length)
            ? 0
            : array[row].length;
    }

    public static void changeElem(int[][] array, int row, int col, int newInt) {
        if (row >= 0 && row < array.length
            && col >= 0 && col < array[row].length) {
            array[row][col] = newInt;
        }
    }

    public static void display(int[][] array) {
        for (int[] rows : array) {
            for (int number : rows) {
                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }

    public static boolean isMagicRows(int[][] array) {
        int[] sums = new int[array[0].length];
        for (int index = 0; index < array.length; index++) {
            for (int number : array[index]) {
                sums[index] += number;
            }
        }

        int last = sums[0];
        for (int number : sums) {
            if (last != number) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMagicColumns(int[][] array) {
        int[] sums = new int[array.length];
        for (int outerIndex = 0; outerIndex < array.length; outerIndex++) {
            for (
                int innerIndex = 0;
                innerIndex < array[outerIndex].length;
                innerIndex++
            ) {
                sums[outerIndex] += array[outerIndex][innerIndex];
            }
        }

        int last = sums[0];
        for (int val : sums) {
            if (last != val) {
                return false;
            }
        }
        return true;
    }
}