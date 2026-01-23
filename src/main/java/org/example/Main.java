package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        Display display = new Display();

        ArrayList<Dataset> dataset = utilities.readDataset(
                Main.class.getResourceAsStream("/Kaggle_Datasets.csv")
        );
        display.mainMenu(dataset);
    }
}