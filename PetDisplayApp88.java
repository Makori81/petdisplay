package com.mycompany.petdisplayapp88;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class PetDisplayApp88 extends JFrame {
    private JLabel displayLabel;
    private JLabel imageLabel;
    private static final String PIG_IMAGE_URL = "https://images.unsplash.com/photo-1534606067099-6fb45f4d4058?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHBpbmslMjBwaWd8ZW58MHx8MHx8fDA%3D";

    public PetDisplayApp88() {
        setTitle("Choose Your Pet");
        setSize(400, 400); // Increased height to accommodate image
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create radio buttons
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton pigButton = new JRadioButton("Pig");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(pigButton);
        group.add(rabbitButton);

        // Create display label
        displayLabel = new JLabel("Please select a pet", JLabel.CENTER);
        displayLabel.setPreferredSize(new Dimension(250, 30));

        // Create image label with pig image
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 300)); // Set preferred size for image

        try {
            URL url = new URL(PIG_IMAGE_URL);
            ImageIcon icon = new ImageIcon(url);
            Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Add action listeners to handle button clicks
        dogButton.addActionListener(new PetButtonListener("Dog", "PIG_IMAGE_URL"));
        catButton.addActionListener(new PetButtonListener("Cat", "PIG_IMAGE_URL"));
        birdButton.addActionListener(new PetButtonListener("Bird", "PIG_IMAGE_URL"));
        pigButton.addActionListener(new PetButtonListener("Pig", "PIG_IMAGE_URL" ));
        rabbitButton.addActionListener(new PetButtonListener("Rabbit", "PIG_IMAGE_URL"));

        // Create panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        JPanel petPanel = new JPanel(new GridLayout(5, 1));
        petPanel.add(birdButton);
        petPanel.add(catButton);
        petPanel.add(dogButton);
        petPanel.add(pigButton);
        petPanel.add(rabbitButton);

        panel.add(petPanel, BorderLayout.WEST);
        panel.add(displayLabel, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Add panel to frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    // ActionListener implementation to handle radio button selection
    private class PetButtonListener implements ActionListener {
        private String petType;
        private String imageUrl;

        public PetButtonListener(String type, String url) {
            petType = type;
            imageUrl = url;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            displayLabel.setText("You selected: " + petType);
            try {
                URL url = new URL(imageUrl);
                ImageIcon icon = new ImageIcon(url);
                Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PetDisplayApp88();
            }
        });
    }
}

