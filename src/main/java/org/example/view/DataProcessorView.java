package org.example.view;

import org.example.Main;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DataProcessorView {
    private JPanel MainPanel;
    private JTable DatasetTable;
    private JButton sortBtn;
    private JButton quitBtn;
    private JButton filterBtn;
    private JButton clusterBtn;
    private JButton searchBtn;

    public DataProcessorView() {
        initialize();
    }

    public void initialize() {
        JFrame frame = new JFrame("Data Processing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(MainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JTable getDatasetTable() {
        return DatasetTable;
    }

    public JButton getSortBtn() {
        return sortBtn;
    }
    public JButton getSearchBtn() {
        return searchBtn;
    }
    public JButton getFilterBtn() {
        return filterBtn;
    }
    public JButton getClusterBtn() {
        return clusterBtn;
    }
    public JButton getQuitBtn() {
        return quitBtn;
    }

    public void setButtonListener(JButton button, ActionListener actionListener) {
        button.addActionListener(actionListener);
    }
}
