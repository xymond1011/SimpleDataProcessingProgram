package org.example.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DataProcessorView {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel reusablePanel;
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
    private JTable reusableTable;
    private JLabel reusableTableTitleLabel;
    private JPanel wrapperPanel;
    private JScrollPane scrollWrapper;
    private JLabel reusableInstructionLabel;
    private JButton filterMedalButton;
    private JButton filterFileTypeButton;
    private JButton filterDateButton;
    private JTable filterTable;
    private JLabel filterTableLabel;


    public DataProcessorView() {
        JFrame frame = new JFrame("Data Processing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

        createUIComponents(); //creates reusable components.
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getDatasetTable() {
        return datasetTable;
    }
    public JTable getSortTable() {
        return reusableTable;
    }
    public JTable getFilterTable() {
        return filterTable;
    }

    public JLabel getSortTableTitleLabel() {
        return reusableTableTitleLabel;
    }
    public JLabel getFilterTableLabel() {
        return filterTableLabel;
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

    //filteringProcesses card buttons
    public JButton getFilterMedalButton() {
        return filterMedalButton;
    }
    public JButton getFilterFileTypeButton() {
        return filterFileTypeButton;
    }
    public JButton getFilterDateButton() {
        return filterDateButton;
    }

    public void setButtonListener(JButton button, ActionListener actionListener) {
        button.addActionListener(actionListener);
    }

    //reusable components
    private void createUIComponents() {
        reusablePanel = new JPanel();
        reusableTable = new JTable();
        reusableInstructionLabel = new JLabel("Please Select an Option Below.");
        reusableTableTitleLabel = new JLabel();
        wrapperPanel = new JPanel();
        scrollWrapper = new JScrollPane();

        backToMainMenuButton = new JButton("Back to Main Menu");
    }
}
