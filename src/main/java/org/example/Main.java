package org.example;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * General Processes to be made:
 * <br>1. Sorting (Including: by title, [by number of files], by file size, by date, [by downloads], by usability, and [by vote counts])
 * <br>2. Filtering: (Including: by medals, by file types, by keywords, and by date)
 * <br>3. Clustering: (Including: by medals, by file types, and by keywords)
 * <br>4. Keyword Searching
 * <br>5. Single Item Information (Embedded to another processes)
 */
public class Main {
    public void run() {
        Utilities utilities = new Utilities();
        Display display = new Display();

        String[] header = {"Sample", "Dataset"};
        Dataset ds = new Dataset();
        ArrayList<Dataset> dsArray = new ArrayList<>();
        dsArray.add(ds);
//        display.displayDatasetTable(header,dsArray, "Some text");
        display.mainMenu();
    }
    public static void main(String[] args) {
        Main program;

        try {
            program = new Main();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}