package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Display {
    private JFrame frame = new JFrame();

    public Display() {
        initialize();
    }

    public void initialize() {
        frame.setTitle("Simple Data Preprocessing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void mainMenu(ArrayList<Dataset> dataset) {
        JPanel panel = new JPanel();
        JLabel greetings = new JLabel("Welcome to My Program!\n Please Select an Option.");
        panel.setLayout(new BorderLayout());
        panel.add(greetings, BorderLayout.NORTH);
        panel.add(displayTable(dataset), BorderLayout.CENTER);
        Container pane = frame.getContentPane();
        pane.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public JTable displayTable(ArrayList<Dataset> dataset) {
        String[] columns = {
                "Title",
                "Usability",
                "Number of Files",
                "Type of Files",
                "File Size",
                "Vote Counts",
                "Medal",
                "URL Reference",
                "Number of Columns",
                "Views",
                "Downloads",
                "Download Per View",
                "Date Created",
                "Last Update"
        };
        JTable table = initializeTable(dataset, columns);
        for (int index = 0; index < table.getColumnCount(); index++) {
            table.getColumnModel().getColumn(index).setPreferredWidth(250);
        }

        table.setEnabled(false);

        return table;
    }

    private static JTable initializeTable(ArrayList<Dataset> dataset, String[] columns) {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Dataset data : dataset) {
            Object[] row = {
               data.getTitle(), data.getUsability(),
                    data.getNumOfFiles(), data.getTypeOfFiles(),
                    data.getFileSize(), data.getVoteCounts(),
                    data.getMedal(), data.getUrlReference(),
                    data.getNumOfColumns(), data.getViews(),
                    data.getDownloads(), data.getDownloadPerView(),
                    data.getDateCreated(), data.getLastUpdate()
            };

            model.addRow(row);
        }
        return new JTable(model);
    }
}
