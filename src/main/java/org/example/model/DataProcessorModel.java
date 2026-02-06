package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProcessorModel {
    private Connection connection;
    private String query;

    public DataProcessorModel() {
        final String URL = "jdbc:mysql://localhost:3306/kaggle_dataset";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database successfully");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Map<String, Object>> getDatabaseTable() {
        List<Map<String, Object>> dbContent = new ArrayList<>();
        String query = "SELECT * FROM `dataset_entries_phpmyadmin`";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (result.next()) {
                Map<String, Object> row = new LinkedHashMap<>();

                for (int i = 1; i <= columnCount; i++) {
                    //exclude columns; not needed yet.
                    if (i == 9) {
                        continue;
                    }

                    String label = metaData.getColumnLabel(i);
                    row.put(label, result.getObject(i));
                }
                dbContent.add(row);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return null;
        }
        return dbContent;
    }

    public int getRowCount() {
        return getDatabaseTable().size();
    }

    public ResultSet getDBContent() {
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query);
        ) {
            return result;
        } catch (SQLException e) {
            System.err.println("Failed to fetch database table.");
            e.printStackTrace();
        }
        return null;
    }

    public static List<Map<String, Object>> toMapList(List<Map<String, Object>> dbContent) {
        dbContent = new ArrayList<>();

        return dbContent;
    }
}
