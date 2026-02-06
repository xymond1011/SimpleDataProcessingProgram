package org.example.controller;

import org.example.Main;
import org.example.model.DataProcessorModel;
import org.example.view.DataProcessorView;
import org.example.view.SortingProcessesView;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class DataProcessorController {
    private final DataProcessorModel MAIN_MODEL;
    private final DataProcessorView MAIN_VIEW;
    private final SortingProcessesView SORT_VIEW = new SortingProcessesView();

    public DataProcessorController(DataProcessorModel model, DataProcessorView view) {
        MAIN_MODEL = model;
        MAIN_VIEW = view;
        initialize();
    }

    private void initialize() {
        setButtonListener();
        loadDatasetTable();
    }

    private void setButtonListener() {
        MAIN_VIEW.setButtonListener(MAIN_VIEW.getSortBtn(), (ActionEvent e) -> {
            SORT_VIEW.initialize();
        } );

        MAIN_VIEW.setButtonListener(MAIN_VIEW.getFilterBtn(), (ActionEvent e) -> {});
        MAIN_VIEW.setButtonListener(MAIN_VIEW.getSearchBtn(), (ActionEvent e) -> {});
        MAIN_VIEW.setButtonListener(MAIN_VIEW.getClusterBtn(), (ActionEvent e) -> {});

        MAIN_VIEW.setButtonListener(MAIN_VIEW.getQuitBtn(), (ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                    null,
                    "Thank you for trying the application!",
                    "Thank you!",
                    JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        });

        //SORT_VIEW listeners
        SORT_VIEW.setButtonListener(SORT_VIEW.getTitleButton(), (ActionEvent e) -> {});
        SORT_VIEW.setButtonListener(SORT_VIEW.getUsabilityButton(), (ActionEvent e) -> {});
        SORT_VIEW.setButtonListener(SORT_VIEW.getCreationDateButton(), (ActionEvent e) -> {});
        SORT_VIEW.setButtonListener(SORT_VIEW.getFileSizeButton(), (ActionEvent e) -> {});
        SORT_VIEW.setButtonListener(SORT_VIEW.getLastUpdateButton(), (ActionEvent e) -> {});

        SORT_VIEW.setButtonListener(SORT_VIEW.getBackToMainMenuButton(), (ActionEvent e) -> {
            MAIN_VIEW.initialize();
        });
    }

    private void loadDatasetTable() {
        List<Map<String, Object>> dbTbl = MAIN_MODEL.getDatabaseTable();
        MapListToTable(dbTbl);
    }

    private void MapListToTable(List<Map<String, Object>> mapList) {
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

            MAIN_VIEW.getDatasetTable().setModel(
                    new DefaultTableModel(dataTable, columns)
            );
        }

        JTableHeader header = MAIN_VIEW.getDatasetTable().getTableHeader();
        Font headerFont = header.getFont();
        header.setFont(headerFont.deriveFont(java.awt.Font.BOLD));

        FontMetrics headerLength = header.getFontMetrics(headerFont);
        TableColumnModel columnModel = MAIN_VIEW.getDatasetTable().getColumnModel();

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
}
