import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FreeTimeTable {
    List<FreeTimeColumn> freeTimeColumns =
        new ArrayList<>();
    List<FreeTimeRow> freeTimeRows =
        new ArrayList<>();
    int width;

    // FreeTimeTable class constructor
    FreeTimeTable(int tableWidth) {
        this.width = tableWidth;
    }

    /**
     * <p>Writes top border to given printWriter object.</p>
     *
     * @param printWriter the printWriter with file obj
     */
    public void writeTopBorder(PrintWriter printWriter) {
        printWriter.printf("  " + "_".repeat(width - 4) + '\n');
    }

    /**
     * <p>Writes middle border to given printWriter object.</p>
     *
     * @param printWriter the printWriter with file obj
     */
    public void writeMiddleBorder(PrintWriter printWriter) {
        printWriter.printf("|" + ".".repeat(width - 2) + "|\n");
    }

    /**
     * <p>Writes bottom border to given printWriter object.</p>
     *
     * @param printWriter the printWriter with file obj
     */
    public void writeBottomBorder(PrintWriter printWriter) {
        printWriter.printf(" " + "-".repeat(width - 2) + '\n');
    }

    /**
     * <p>Writes column headers to given printWriter object.</p>
     *
     * @param printWriter the printWriter with file obj
     */
    public void writeHeaders(PrintWriter printWriter) {
        for (
            FreeTimeColumn column : this.freeTimeColumns) {
            String format =
                "%"
                    + column.getAlignmentSymbol()
                    + column.getLength()
                    + "s";
            printWriter.printf("|" + format, column.getName());
        }
        printWriter.printf("|\n");
    }

    public void printTopBorder() {
        System.out.printf(" " + "_".repeat(width - 2) + '\n');
    }

    public void printMiddleBorder() {
        System.out.printf("|" + ".".repeat(width - 2) + "|\n");
    }

    public void printBottomBorder() {
        System.out.printf(" " + "-".repeat(width - 2) + '\n');
    }

    public void printHeaders() {
        for (
            FreeTimeColumn column : this.freeTimeColumns) {
            String format =
                "%"
                    + column.getAlignmentSymbol()
                    + column.getLength()
                    + "s";
            System.out.printf("|" + format, column.getName());
        }
        System.out.printf("|\n");
    }

    /**
     * <p>Prints top border, headers, rows, and bottom border to
     * console.</p>
     *
     * @see #printTopBorder()
     * @see #printHeaders()
     * @see #printRows()
     * @see #printBottomBorder()
     */
    public void printTable() {
        this.printTopBorder();
        this.printHeaders();
        this.printRows();
        this.printBottomBorder();
    }

    /**
     * <p>Prints top border, headers, rows in given range, and bottom
     * border to console.</p>
     *
     * @param start the starting range int
     * @param end   the ending range int
     * @see #printTopBorder()
     * @see #printHeaders()
     * @see #printRows()
     * @see #printBottomBorder()
     */
    public void printTableRange(int start, int end) {
        this.printTopBorder();
        this.printHeaders();
        this.printRowRange(start, end);
        this.printBottomBorder();
    }

    /**
     * <p>Prints rows in given range to console.</p>
     *
     * @param start the starting range int
     * @param end   the ending range int
     */
    public void printRowRange(int start, int end) {
        for (
            int rowIndex = start;
            rowIndex < end;
            rowIndex++
        ) {
            FreeTimeRow row = freeTimeRows.get(rowIndex);
            this.printMiddleBorder();
            for (
                int columnIndex = 0;
                columnIndex < freeTimeColumns.size();
                columnIndex++
            ) {
                FreeTimeColumn column =
                    freeTimeColumns.get(columnIndex);

                String format =
                    "%"
                        + column.getAlignmentSymbol()
                        + column.getLength()
                        + (column.getType() == 'f'
                        ? column.getRound() : "")
                        + column.getType();

                try {
                    Class rowClass = row.getClass();
                    String rowName = column.getRowName();
                    Field field = rowClass.getDeclaredField(rowName);
                    System.out.printf("|" + format,
                        field.get(row));
                } catch (
                NoSuchFieldException | IllegalAccessException e
                ) {
                    System.out.printf("An error occurred.");
                    e.printStackTrace();
                }
            }

            System.out.printf("|\n");
        }
    }

    /**
     * <p>Prints rows to console.</p>
     */
    public void printRows() {
        for (
            FreeTimeRow row : this.freeTimeRows) {
            this.printMiddleBorder();
            for (
                int columnIndex = 0;
                columnIndex < freeTimeColumns.size();
                columnIndex++
            ) {
                FreeTimeColumn column =
                    freeTimeColumns.get(columnIndex);

                String format =
                    "%"
                        + column.getAlignmentSymbol()
                        + column.getLength()
                        + (column.getType() == 'f'
                        ? column.getRound() : "")
                        + column.getType();

                try {
                    Class rowClass = row.getClass();
                    String rowName = column.getRowName();
                    Field field = rowClass.getDeclaredField(rowName);
                    System.out.printf("|" + format,
                        field.get(row));
                } catch (
                NoSuchFieldException | IllegalAccessException e
                ) {
                    System.out.printf("An error occurred.");
                    e.printStackTrace();
                }
            }

            System.out.printf("|\n");
        }
    }

    /**
     * <p>Writes rows to given printWriter object.</p>
     *
     * @param printWriter the printWriter with file obj
     */
    public void writeRows(PrintWriter printWriter) {
        for (
            FreeTimeRow row : this.freeTimeRows) {
            this.writeMiddleBorder(printWriter);
            for (
                int columnIndex = 0;
                columnIndex < freeTimeColumns.size();
                columnIndex++
            ) {
                FreeTimeColumn column =
                    freeTimeColumns.get(columnIndex);

                String format =
                    "%"
                        + column.getAlignmentSymbol()
                        + column.getLength()
                        + (column.getType() == 'f'
                        ? column.getRound() : "")
                        + column.getType();

                try {
                    Class rowClass = row.getClass();
                    String rowName = column.getRowName();
                    Field field = rowClass.getDeclaredField(rowName);
                    printWriter.printf("|" + format,
                        field.get(row));
                } catch
                (NoSuchFieldException | IllegalAccessException e) {
                    printWriter.printf("An error occurred.");
                    e.printStackTrace();
                }
            }

            printWriter.printf("|\n");
        }
    }

    /**
     * <p>Gets output file name from user and writes the table to it
     * .</p>
     *
     * @see #writeTopBorder(PrintWriter)
     * @see #writeHeaders(PrintWriter)
     * @see #writeRows(PrintWriter)
     * @see #writeBottomBorder(PrintWriter)
     */
    public void writeTable() throws FileNotFoundException {
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an output filename: ");
        String fileName = keyboardReader.next();

        File myObj = new File(fileName);
        PrintWriter printWriter = new PrintWriter(myObj);

        this.writeTopBorder(printWriter);
        this.writeHeaders(printWriter);
        this.writeRows(printWriter);
        this.writeBottomBorder(printWriter);

        printWriter.close();
    }

    /**
     * <p>Gets and sets row input from user keyboard.</p>
     *
     * @see FreeTimeRow
     */
    public FreeTimeRow userInputRow() {
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter your first and last name: ");
        String firstName = keyboardReader.next();
        String lastName = keyboardReader.next();
        String fullName = firstName + " " + lastName;

        System.out.printf("Enter your time spent sleeping each night "
            + "(in "
            + "hours): ");
        double hoursOfSleep = keyboardReader.nextDouble();

        System.out.printf("Enter your number of classes: ");
        int numberOfClasses = keyboardReader.nextInt();

        FreeTimeRow row = new FreeTimeRow(
            fullName,
            hoursOfSleep,
            numberOfClasses);

        return row;
    }

    /**
     * <p>Gets and sets row input from file input.</p>
     *
     * @see FreeTimeRow
     */
    public FreeTimeRow fileInputRow() {
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter an input filename: ");
        String fileName = keyboardReader.next();

        try {
            File myObj = new File(fileName);
            Scanner fileReader = new Scanner(myObj);

            String rawName = fileReader.nextLine();
            fileReader.nextLine();
            int hoursOfSleep = fileReader.nextInt();
            int numberOfClasses = fileReader.nextInt();
            fileReader.close();

            String[] split = rawName.split(" ");
            String firstName = String.valueOf(split[0]);
            String lastName = String.valueOf(split[1]);
            String fullName = rawName
                .trim()
                .replaceAll("\\s{2,}", " ");

            FreeTimeRow row = new FreeTimeRow(
                fullName,
                hoursOfSleep,
                numberOfClasses);
            return row;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void userInputFull() {
        Scanner keyboardReader = new Scanner(System.in);
        System.out.printf("Enter your first and last name: ");
        String firstName = keyboardReader.next();
        String lastName = keyboardReader.next();
        String fullName = firstName + " " + lastName;

        System.out.printf("Enter your time spent sleeping each night "
            + "(in "
            + "hours): ");
        double hoursOfSleep = keyboardReader.nextDouble();

        System.out.printf("Enter your number of classes: ");
        int numberOfClasses = keyboardReader.nextInt();

        FreeTimeRow row1 = new FreeTimeRow(
            fullName,
            hoursOfSleep,
            numberOfClasses);
        freeTimeRows.add(row1);

        printTable();

        System.out.printf("Enter an input filename: ");
        String fileName = keyboardReader.next();

        try {
            File myObj = new File(fileName);
            Scanner fileReader = new Scanner(myObj);

            //            String rawName = fileReader.nextLine();
            //            String[] split = rawName.split(" ");
            //            String fileFirstName = String.valueOf(split[0]);
            //            String fileLastName = String.valueOf(split[1]);
            //            String fileFullName = rawName
            //                .trim()
            //                .replaceAll("\\s{2,}", " ");

            String fileFirstName = fileReader.next();
            String fileLastName = fileReader.next();
            fileReader.nextLine();
            int fileHoursOfSleep = fileReader.nextInt();
            int fileNumberOfClasses = fileReader.nextInt();
            fileReader.close();

            String fileFullName = fileFirstName + " " + fileLastName;

            FreeTimeRow row = new FreeTimeRow(
                fileFullName,
                fileHoursOfSleep,
                fileNumberOfClasses);
            freeTimeRows.add(row);
            printTableRange(1, 2);

            System.out.printf("Enter an output filename: ");
            String fullFileName = keyboardReader.next();

            File fullObj = new File(fullFileName);
            PrintWriter printWriter = new PrintWriter(fullObj);

            this.writeTopBorder(printWriter);
            this.writeHeaders(printWriter);
            this.writeRows(printWriter);
            this.writeBottomBorder(printWriter);

            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}