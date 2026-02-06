package org.example;

import org.example.controller.DataProcessorController;
import org.example.model.DataProcessorModel;
import org.example.view.DataProcessorView;

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
        DataProcessorView view = new DataProcessorView();
        DataProcessorModel model = new DataProcessorModel();
        DataProcessorController dataProcessingProgram = new DataProcessorController(model, view);
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