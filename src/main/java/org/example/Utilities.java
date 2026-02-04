package org.example;

//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.time.LocalDate;

import java.util.ArrayList;

public class Utilities {
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Utilities(boolean isDB) {

        if (isDB) {
            System.out.println("Connecting to database...");

            // Establishing the connection
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                if (connection != null) {
                    System.out.println("Successfully connected to MySQL database!");
                }
            } catch (SQLException e) {
                System.err.println("Connection failed!");
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Dataset> readDataset(String query) {
        ArrayList<Dataset> dataset = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(query)
        ) {
            while (result.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataset;
    }
//    public ArrayList<Dataset> readDataset(InputStream filepath) {
//        ArrayList<Dataset> dataset = new ArrayList<>();
//
//        try (CSVReader datasetReader = new CSVReader(new InputStreamReader(filepath))) {
//            String[] contentRow;
//            while ((contentRow = datasetReader.readNext()) != null) {
//                Dataset datasetEntry = new Dataset(
//                        contentRow[0],
//                        contentRow[1].isEmpty() ? 0:Float.parseFloat(contentRow[1]),
//                        contentRow[2].isEmpty() ? 0:Integer.parseInt(contentRow[2]),
//                        contentRow[3],
//                        contentRow[4],
//                        contentRow[5].isEmpty() ? 0:Integer.parseInt(contentRow[5]),
//                        contentRow[6],
//                        URI.create(contentRow[7]),
//                        contentRow[8].isEmpty() ? 0:Short.parseShort(contentRow[8]),
//                        contentRow[9].isEmpty() ? 0:Integer.parseInt(contentRow[9]),
//                        contentRow[10].isEmpty() ? 0:Integer.parseInt(contentRow[10]),
//                        contentRow[11].isEmpty() ? 0:Float.parseFloat(contentRow[11]),
//                        contentRow[12].isEmpty() ? null: LocalDate.parse(contentRow[12]),
//                        contentRow[13].isEmpty() ? null:LocalDate.parse(contentRow[13])
//                );
//                dataset.add(datasetEntry);
//            }
//        } catch (IOException | CsvValidationException e) {
//            e.printStackTrace();
//        }
//        return dataset;
//    }
}
