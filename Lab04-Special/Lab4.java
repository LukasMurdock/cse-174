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
        freeTimeTable.userInputFull();

        // Commented out because test uses one line...
        // FreeTimeRow row1 = freeTimeTable.userInputRow();
        // freeTimeTable.freeTimeRows.add(row1);
        //
        // freeTimeTable.printTable();
        //
        //        // File input row
        //// FreeTimeRow row2 = freeTimeTable.fileInputRow();
        ////        freeTimeTable.freeTimeRows.add(row2);
        //        freeTimeTable.printTableRange(1, 2);
        //
        //        freeTimeTable.writeTable();
    }
}