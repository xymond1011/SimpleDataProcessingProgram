package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SortingProcessesView {
    private JButton titleButton;
    private JButton usabilityButton;
    private JButton lastUpdateButton;
    private JButton fileSizeButton;
    private JButton creationDateButton;
    private JPanel SortButtonPanel;
    private JButton backToMainMenuButton;

    public void initialize() {
        JFrame frame = new JFrame("Sorting Processes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setLocationRelativeTo(null);
        frame.add(SortButtonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getButtonPanel() {
        return SortButtonPanel;
    }
    public JButton getTitleButton() {
        return titleButton;
    }
    public JButton getUsabilityButton() {
        return usabilityButton;
    }
    public JButton getLastUpdateButton() {
        return lastUpdateButton;
    }
    public JButton getFileSizeButton() {
        return fileSizeButton;
    }
    public JButton getCreationDateButton() {
        return creationDateButton;
    }
    public JButton getBackToMainMenuButton() {
        return backToMainMenuButton;
    }
    public void setButtonListener(JButton button, ActionListener actionListener) {
        button.addActionListener(actionListener);
    }
}
