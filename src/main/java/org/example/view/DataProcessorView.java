package org.example.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DataProcessorView {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel sortingProcessesPanel;
    private JTable datasetTable;
    private JButton sortButton;
    private JButton searchButton;
    private JButton filterButton;
    private JButton clusterButton;
    private JButton quitButton;
    private JButton byTitleButton;
    private JButton byUsabilityButton;
    private JButton byCreationDateButton;
    private JButton backToMainMenuButton;
    private JButton byLastUpdateButton;
    private JTable sortTable;
    private JLabel sortTableTitleLabel;


    public DataProcessorView() {
        JFrame frame = new JFrame("Data Processing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getDatasetTable() {
        return datasetTable;
    }
    public JTable getSortTable() {
        return sortTable;
    }

    public JLabel getSortTableTitleLabel() {
        return sortTableTitleLabel;
    }

    //mainMenu card buttons
    public JButton getSortBtn() {
        return sortButton;
    }
    public JButton getSearchBtn() {
        return searchButton;
    }
    public JButton getFilterBtn() {
        return filterButton;
    }
    public JButton getClusterBtn() {
        return clusterButton;
    }
    public JButton getQuitBtn() {
        return quitButton;
    }

    //sortingProcesses card buttons
    public JButton getByTitleBtn() {
        return byTitleButton;
    }
    public JButton getByUsabilityBtn() {
        return byUsabilityButton;
    }
    public JButton getByCreationDateBtn() {
        return byCreationDateButton;
    }
    public JButton getBackToMainMenuBtn() {
        return backToMainMenuButton;
    }
    public JButton getByLastUpdateBtn() {
        return byLastUpdateButton;
    }

    public void setButtonListener(JButton button, ActionListener actionListener) {
        button.addActionListener(actionListener);
    }
}
