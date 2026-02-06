package org.example.controller;

import org.example.model.DataProcessorModel;
import org.example.view.DataProcessorView;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class DataProcessorController {
    private final DataProcessorModel MODEL;
    private final DataProcessorView VIEW;

    public DataProcessorController(DataProcessorModel model, DataProcessorView view) {
        MODEL = model;
        VIEW = view;

        loadDatasetTable();
        initializeButtonListeners();
    }

    private void loadDatasetTable() {
        MODEL.setQuery("SELECT * FROM `dataset_entries_phpmyadmin`");
        MapListToTable(MODEL.getDatabaseContent(), VIEW.getDatasetTable());
        changeSortTableLabelDisplay("Kaggle Dataset");
        MapListToTable(MODEL.getDatabaseContent(), VIEW.getSortTable());
    }

    private void initializeButtonListeners() {
        changeDisplay(VIEW.getSortBtn(), "sortMenu");
        changeDisplay(VIEW.getBackToMainMenuBtn(), "mainMenu");

        VIEW.setButtonListener(VIEW.getFilterBtn(), (ActionEvent e) -> {});
        VIEW.setButtonListener(VIEW.getSearchBtn(), (ActionEvent e) -> {});
        VIEW.setButtonListener(VIEW.getClusterBtn(), (ActionEvent e) -> {});
        VIEW.setButtonListener(VIEW.getQuitBtn(), (ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                    null,
                    "Thank you for trying the application!",
                    "Thank you!",
                    JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        });

        //SORT PROCESSES BUTTONS
        VIEW.setButtonListener(VIEW.getByTitleBtn(), (ActionEvent e) -> {
            MODEL.setQuery("SELECT * FROM `dataset_entries_phpmyadmin` ORDER BY `title` ASC");
            changeSortTableLabelDisplay("Kaggle Dataset (Sorted By: Title)");
            MapListToTable(MODEL.getDatabaseContent(), VIEW.getSortTable());
        });
        VIEW.setButtonListener(VIEW.getByUsabilityBtn(), (ActionEvent e) -> {
            MODEL.setQuery("SELECT * FROM `dataset_entries_phpmyadmin` ORDER BY `usability` DESC");
            changeSortTableLabelDisplay("Kaggle Dataset (Sorted By: Usability)");
            MapListToTable(MODEL.getDatabaseContent(), VIEW.getSortTable());
        });
        VIEW.setButtonListener(VIEW.getByCreationDateBtn(), (ActionEvent e) -> {
            MODEL.setQuery("SELECT * FROM `dataset_entries_phpmyadmin` ORDER BY `date_created` DESC");
            changeSortTableLabelDisplay("Kaggle Dataset (Sorted By: Data of Creation)");
            MapListToTable(MODEL.getDatabaseContent(), VIEW.getSortTable());

        });
        VIEW.setButtonListener(VIEW.getByLastUpdateBtn(), (ActionEvent e) -> {
            MODEL.setQuery("SELECT * FROM `dataset_entries_phpmyadmin` ORDER BY `latest_update` DESC");
            changeSortTableLabelDisplay("Kaggle Dataset (Sorted By: Latest Update)");
            MapListToTable(MODEL.getDatabaseContent(), VIEW.getSortTable());
        });
    }

    private void MapListToTable(List<Map<String, Object>> mapList, JTable table) {
        if (mapList != null && !mapList.isEmpty()) {

            Map<String, Object> firstRow = mapList.getFirst();
            String[] columns = firstRow.keySet().toArray(new String[0]);

            Object[][] dataTable = new Object[mapList.size()][columns.length];

            for (int i = 0; i < mapList.size(); i++) {
                Map<String, Object> row = mapList.get(i);
                for (int j = 0; j < columns.length; j++) {
                    Object value = row.get(columns[j]);
                    dataTable[i][j] = (value != null) ? value.toString() : "";
                }
            }

            table.setModel(
                    new DefaultTableModel(dataTable, columns)
            );
        }

        JTableHeader header = table.getTableHeader();
        Font headerFont = header.getFont();
        header.setFont(headerFont.deriveFont(java.awt.Font.BOLD));

        FontMetrics headerLength = header.getFontMetrics(headerFont);
        TableColumnModel columnModel = table.getColumnModel();

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            String columnName = column.getHeaderValue().toString();
            int headerSize = headerLength.stringWidth(columnName) + 30;

            if (columnName.equalsIgnoreCase("title")) {
                column.setPreferredWidth(350);
                continue;
            }
            if (columnName.equalsIgnoreCase("url_reference")) {
                column.setPreferredWidth(400);
                continue;
            }
            column.setPreferredWidth(headerSize);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            //centers dates (since they're uniform in length)
            if (i == columnModel.getColumnCount() - 1 || i == columnModel.getColumnCount() - 2) {
                column.setCellRenderer(centerRenderer);
            }
        }
    }

    private void changeDisplay(JButton button, String cardName) {
        CardLayout cardLayout = (CardLayout) VIEW.getMainPanel().getLayout();
        VIEW.setButtonListener(button, (ActionEvent e) -> {
            cardLayout.show(VIEW.getMainPanel(), cardName);
        });
    }
    private void changeSortTableLabelDisplay(String text) {
        JLabel label = VIEW.getSortTableTitleLabel();
        label.setText(text);
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
