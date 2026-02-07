package org.example;

import java.awt.CardLayout;
import javax.swing.*;
// Import your custom button panel classes
// import DataProcessingButtons;
// import NewFunctionButtons;

public class MyDataProgram {
    private JPanel mainPanel; // Your top-level panel
    private JPanel datasetTablePanel; // Center panel with the table
    private JPanel buttonPanelContainer; // South panel using CardLayout

    private CardLayout cardLayout;

    public MyDataProgram() {
        cardLayout = (CardLayout) buttonPanelContainer.getLayout();

        // Instantiate your button panels
        DataProcessingButtons dpButtons = new DataProcessingButtons();
        NewFunctionButtons nfButtons = new NewFunctionButtons();

        // Add them to the container with unique names/keys
        buttonPanelContainer.add(dpButtons.getPanel(), "DATA_PROCESSING_VIEW");
        buttonPanelContainer.add(nfButtons.getPanel(), "NEW_FUNCTIONS_VIEW");

        // The CardLayout will respect the *preferred size* of whichever panel is currently showing.
    }

    public void showDataProcessingView() {
        cardLayout.show(buttonPanelContainer, "DATA_PROCESSING_VIEW");
        // Revalidate and repaint if you notice layout issues, though CardLayout usually handles this.
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void showNewFunctionsView() {
        cardLayout.show(buttonPanelContainer, "NEW_FUNCTIONS_VIEW");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}

