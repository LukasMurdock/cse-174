/**
 * --------
 * Section: D
 * Lukas Murdock
 * Sep 2021
 * Lab4.java
 * Calculate Free Time.
 */

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab4 {
    public static void main(String[] args) throws FileNotFoundException {
        class FreeTimeColumn {
            String name;
            String rowName;
            int length;
            char type;
            String alignment;
            String alignmentSymbol;
            String round;

            FreeTimeColumn(String name, String rowName, int length, char type,
                           String alignment) {
                this.name = name;
                this.rowName = rowName;
                this.length = length;
                this.type = type;
                this.alignment = alignment;
                calculateAlignment();
            }

            public void calculateAlignment() {
                this.alignmentSymbol = this.alignment == "left" ? "-" : "+";
            }

            public void setRound(String round) {
                this.round = round;
            }

            public String getRound() {
                return this.round;
            }

            public String getName() {
                return this.name;
            }

            public String getRowName() {
                return this.rowName;
            }

            public int getLength() {
                return this.length;
            }

            public char getType() {
                return this.type;
            }

            public String getAlignmentSymbol() {
                return this.alignmentSymbol;
            }
        }

        class FreeTimeRow {
            String fullName;
            double hoursOfSleep;
            int numberOfClasses;
            double freeTime;

            FreeTimeRow(String fullName, double hoursOfSleep,
                        int numberOfClasses) {
                this.fullName = fullName;
                this.hoursOfSleep = hoursOfSleep;
                this.numberOfClasses = numberOfClasses;
                calculateFreeTime();
            }

            public void calculateFreeTime() {
                this.freeTime =
                        120 - (
                                this.hoursOfSleep
                                        * 5
                                        + this.numberOfClasses
                                        * 8.72
                        );
            }

            public void calculateFreeTime(int hoursOfSleep,
                                          int numberOfClasses) {
                this.freeTime =
                        120 - (hoursOfSleep * 5 + numberOfClasses * 8.72);
            }

            public String getFullName() {
                return this.fullName;
            }
        }

        class FreeTimeTable {
            List<FreeTimeColumn> freeTimeColumns =
                    new ArrayList<FreeTimeColumn>();
            List<FreeTimeRow> freeTimeRows =
                    new ArrayList<FreeTimeRow>();
            int width;

            // FreeTimeTable class constructor
            FreeTimeTable(int tableWidth) {
                this.width = tableWidth;
            }

            public void writeTopBorder(PrintWriter printWriter) {
                printWriter.printf("_".repeat(width) + '\n');
            }

            public void writeMiddleBorder(PrintWriter printWriter) {
                printWriter.printf("|" + ".".repeat(width - 2) + "|\n");
            }

            public void writeBottomBorder(PrintWriter printWriter) {
                printWriter.printf("-".repeat(width) + '\n');
            }

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
                System.out.printf("_".repeat(width) + '\n');
            }

            public void printMiddleBorder() {
                System.out.printf("|" + ".".repeat(width - 2) + "|\n");
            }

            public void printBottomBorder() {
                System.out.printf("-".repeat(width) + '\n');
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

            public void printTable() {
                this.printTopBorder();
                this.printHeaders();
                this.printRows();
                this.printBottomBorder();
            }

            public void printTableRange(int start, int end) {
                this.printTopBorder();
                this.printHeaders();
                this.printRowRange(start, end);
                this.printBottomBorder();
            }

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
                                        + (column.getType() == 'f' ?
                                        column.getRound() : "")
                                        + column.getType();

                        try {
                            Class rowClass = row.getClass();
                            String rowName = column.getRowName();
                            Field field = rowClass.getDeclaredField(rowName);
                            System.out.printf("|" + format,
                                    field.get(row));
                        } catch (
                                NoSuchFieldException
                                        | IllegalAccessException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    }

                    System.out.printf("|\n");
                }
            }

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
                                        + (column.getType() == 'f' ?
                                        column.getRound() : "")
                                        + column.getType();

                        try {
                            Class rowClass = row.getClass();
                            String rowName = column.getRowName();
                            Field field = rowClass.getDeclaredField(rowName);
                            System.out.printf("|" + format,
                                    field.get(row));
                        } catch (
                                NoSuchFieldException
                                        | IllegalAccessException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    }

                    System.out.printf("|\n");
                }
            }

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
                                        + (column.getType() == 'f' ?
                                        column.getRound() : "")
                                        + column.getType();

                        try {
                            Class rowClass = row.getClass();
                            String rowName = column.getRowName();
                            Field field = rowClass.getDeclaredField(rowName);
                            printWriter.printf("|" + format,
                                    field.get(row));
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            printWriter.println("An error occurred.");
                            e.printStackTrace();
                        }
                    }

                    printWriter.printf("|\n");
                }
            }

            public void writeTable() throws FileNotFoundException {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.print("Enter an output filename: ");
                String fileName = keyboardReader.next();

                File myObj = new File(fileName);
                PrintWriter printWriter = new PrintWriter(myObj);

                this.writeTopBorder(printWriter);
                this.writeHeaders(printWriter);
                this.writeRows(printWriter);
                this.writeBottomBorder(printWriter);

                printWriter.close();
            }

            public FreeTimeRow userInputRow() {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.print("Enter your first and last name: ");
                String firstName = keyboardReader.next();
                String lastName = keyboardReader.next();
                String fullName = firstName + " " + lastName;

                System.out.print("Enter your time spent sleeping each night " +
                        "(in " +
                        "hours): ");
                double hoursOfSleep = keyboardReader.nextDouble();

                System.out.print("Enter your number of classes: ");
                int numberOfClasses = keyboardReader.nextInt();

                FreeTimeRow row = new FreeTimeRow(
                        fullName,
                        hoursOfSleep,
                        numberOfClasses);
                return row;
            }

            public FreeTimeRow fileInputRow() {
                Scanner keyboardReader = new Scanner(System.in);
                System.out.print("Enter an input filename: ");
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
        }

        FreeTimeColumn column1 = new FreeTimeColumn(
                "Name",
                "fullName",
                20,
                's',
                "left");
        FreeTimeColumn column2 = new FreeTimeColumn(
                "Num Classes",
                "numberOfClasses",
                12,
                'd',
                "left");
        FreeTimeColumn column3 = new FreeTimeColumn(
                "Free Time",
                "freeTime",
                10,
                'f',
                "left");

        column3.setRound(".1");

        FreeTimeTable freeTimeTable = new FreeTimeTable(46);
        freeTimeTable.freeTimeColumns.add(column1);
        freeTimeTable.freeTimeColumns.add(column2);
        freeTimeTable.freeTimeColumns.add(column3);

        // User input row
        FreeTimeRow row1 = freeTimeTable.userInputRow();
        freeTimeTable.freeTimeRows.add(row1);

        freeTimeTable.printTable();

        // File input row
        FreeTimeRow row2 = freeTimeTable.fileInputRow();
        freeTimeTable.freeTimeRows.add(row2);
        freeTimeTable.printTableRange(1, 2);

        freeTimeTable.writeTable();
    }
}