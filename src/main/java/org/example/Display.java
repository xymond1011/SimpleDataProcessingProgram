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
        frame.setPreferredSize(new Dimension(350, 500));
        frame.setVisible(true);
    }

    //main menu to be shown as the program runs.
    public void mainMenu() {
        String[] menuChoices = {
                "Sort", "Filter",
                "Search", "Cluster"
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
        ArrayList<JButton> menuButtons = addButtons(buttonNames);
        GridLayout buttonLayout = new GridLayout(buttonNames.length, 2);
        buttonLayout.setVgap(15);
        buttonLayout.setHgap(15);

        if (buttonNames.length > 6) {
            if (buttonNames.length % 2 == 0) {
                buttonLayout = buttonLayout(
                        "vertical",
                        buttonNames.length / 2, 2
                );
            } else if (buttonNames.length % 3 == 0) {
                buttonLayout = buttonLayout(
                        "horizontal",
                        3, buttonNames.length / 2
                );
            } else {
               buttonLayout = buttonLayout(
                        "horizontal",
                        5, buttonNames.length / 5
                );
            }
        }

        JPanel panel = new JPanel(buttonLayout);
        for (JButton button : menuButtons) {
            panel.add(button);
        }

        return addWrapper(panel);
    }

    //displays tabular form of the dataset
    //TODO: change to cater database.
    public JPanel displayDatasetTable(String[] header, ArrayList<Dataset> dataset, String labelTxt) {
        String[] buttonNames = {
                "Back", "Something"
        };
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTable dataTable = initializeTable(header, dataset);
        ArrayList<JButton> buttons = addButtons(buttonNames);
        JPanel buttonPanel = new JPanel(buttonLayout("horizontal", 1, buttons.size()));
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        JTable someTable = new JTable(new DefaultTableModel(header, 10));
        JLabel label = new JLabel(labelTxt);
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(someTable, BorderLayout.CENTER);
        mainPanel.add(addWrapper(buttonPanel), BorderLayout.SOUTH);
        Container pane = frame.getContentPane();
        pane.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
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

    //DISPLAY UTILITIES//
    /*
    The methods below are the utilities used for the different components of the display.
    That's why it is set to private.
     */

    /**
     * This method creates a button array to be used in different parts of the program.
     * @param buttonNames String array of names for the buttons to be created.
     * @return ArrayList of buttons to be used in a certain UI parts.
     */
    private ArrayList<JButton> addButtons(String[] buttonNames) {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setPreferredSize(new Dimension(144, 60));
            buttonList.add(button);
        }

        return buttonList;
    }

    /**
     * Creates a Gridlayout for the buttons
     * @param orientation horizontal or vertical.
     * @return GridLayout to be used in button JPanels.
     */
    private GridLayout buttonLayout(String orientation, int rows, int columns) {
        GridLayout buttonLayout = new GridLayout();
        if (orientation.equalsIgnoreCase("vertical")) {
            buttonLayout.setRows(columns);
            buttonLayout.setColumns(rows);
        } else if (orientation.equalsIgnoreCase("horizontal")) {
            buttonLayout.setRows(rows);
            buttonLayout.setColumns(columns);
        }

        buttonLayout.setVgap(15);
        buttonLayout.setHgap(15);

        return buttonLayout;
    }
    /**
     * Used for wrapping JPanels in a FlowLayout Panel to have a properly sized components inside the BorderLayout.
     * @param panel JPanel Components that needed to be wrapped.
     * @return JPanel with FlowLayout
     */
    private JPanel addWrapper(JPanel panel) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        wrapper.add(panel);

        return wrapper;
    }
}
