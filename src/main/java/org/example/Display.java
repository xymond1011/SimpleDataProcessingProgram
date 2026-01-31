package org.example;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Display {
    private JFrame frame;

    public Display() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("Simple Data Preprocessing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //main menu to be shown as the program runs.
    public void mainMenu() {
        String[] menuChoices = {
                "",
                "",
                "",
                "",
                "",
                ""
        };
        JPanel panel = new JPanel();
        JLabel greetings = new JLabel("Welcome to My Program!\n Please Select an Option.");
        panel.setLayout(new BorderLayout());
        panel.add(greetings, BorderLayout.NORTH);
        panel.add(menuButtonPanel(menuChoices),BorderLayout.CENTER); //item to be displayed
        Container pane = frame.getContentPane();
        pane.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    private JPanel menuButtonPanel(String[] buttonNames) {
        ArrayList<JButton> menuButtons = addButtons(buttonNames.length, buttonNames);
        JPanel panel = new JPanel(new GridLayout(buttonNames.length, 0));
        for (JButton button : menuButtons) {
            panel.add(button);
        }
        return panel;
    }
    //displays tabular form of the dataset
    public JPanel displayDatasetTable(String[] header, ArrayList<Dataset> dataset) {
        String[] buttonNames = {
                "Back", "Something"
        };
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTable dataTable = initializeTable(header, dataset);
        ArrayList<JButton> buttons = addButtons(buttonNames.length, buttonNames);
        JPanel buttonPanel = new JPanel(new GridLayout(0, buttons.size()));
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }
        JLabel label = new JLabel("Something to test");
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(dataTable, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    private static JTable initializeTable(String[] columns, ArrayList<Dataset> contentList) {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Dataset content : contentList) {
            Object[] row = {
                    content.getTitle(), content.getUsability(),
                    content.getNumOfFiles(), content.getTypeOfFiles(),
                    content.getFileSize(), content.getVoteCounts(),
                    content.getMedal(), content.getUrlReference(),
                    content.getNumOfColumns(), content.getViews(),
                    content.getDownloads(), content.getDownloadPerView(),
                    content.getDateCreated(), content.getLastUpdate()
            };
            model.addRow(row);
        }
        return new JTable(model);
    }

    //returns a list of buttons to be used in a certain UI parts.
    private ArrayList<JButton> addButtons(int count, String[] buttonNames) {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            JButton button = new JButton(buttonNames[i]);
            button.setPreferredSize(new Dimension(144, 60));
            buttonList.add(button);
        }

        return buttonList;
    }
}
