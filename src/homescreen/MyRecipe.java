package homescreen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MyRecipe extends JPanel {

    private JList<String> recipeList;
    private DefaultListModel<String> listModel;
    private JButton viewButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton searchButton;
    private JTextField searchField;
    private Dashboard dashboard;

    public MyRecipe(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
    }

    private void initComponents() {
        recipeList = new JList<>();
        listModel = new DefaultListModel<>();

        var handCursor = new Cursor(Cursor.HAND_CURSOR);
        var btnFont = new Font("Arial", Font.BOLD, 14);

        // Initialize your buttons
        viewButton = new JButton("View");
        viewButton.setPreferredSize(new Dimension(100, 30));
        viewButton.setBorder(null);
        viewButton.setFocusPainted(false);
        viewButton.setCursor(handCursor);
        viewButton.setBackground(new Color(74, 186, 113));
        viewButton.setForeground(Color.WHITE);
        viewButton.setFont(btnFont);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 30));
        editButton.setBorder(null);
        editButton.setFocusPainted(false);
        editButton.setCursor(handCursor);
        editButton.setBackground(new Color(173, 216, 230));
        editButton.setForeground(new Color(74, 186, 113));
        editButton.setFont(btnFont);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 30));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(255, 165, 0));
        deleteButton.setCursor(handCursor);
        deleteButton.setBorder(null);
        deleteButton.setFocusPainted(false);
        deleteButton.setFont(btnFont);

        // Initialize Add button with image
        ImageIcon addIcon = new ImageIcon("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\add.png"); // Replace with your image file
        addButton = new JButton(addIcon);
        addButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setBorder(null);
        addButton.setFocusPainted(false);
        addButton.setBackground(new Color(74, 186, 113));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        searchButton = new JButton("Search");
        searchField = new JTextField(15);

        Dimension searchFieldDimension = new Dimension(200, 30); // Adjust the height as needed
        searchField.setPreferredSize(searchFieldDimension);
        searchField.setForeground(new Color(74, 186, 113)); // Set text color
        searchField.setBorder(BorderFactory.createLineBorder(new Color(74, 186, 113))); // Set border color
        searchField.setCaretColor(new Color(74, 186, 113));

        setBackground(new Color(204, 255, 204));

        // Set button dimensions
        Dimension buttonDimension = new Dimension(100, 40); // Adjust dimensions as needed
        addButton.setPreferredSize(buttonDimension);

        searchButton.setPreferredSize(new Dimension(80, 30));
        searchButton.setBorder(null);
        searchButton.setFocusPainted(false);
        searchButton.setCursor(handCursor);
        searchButton.setBackground(new Color(255, 255, 255));  // RGB for light blue color
        searchButton.setFont(new Font("Arial", Font.PLAIN, 12));
        searchButton.setForeground(new Color(74, 186, 113));

        // Set layout manager (GridBagLayout for precise control)
        setLayout(new GridBagLayout());

        // Add "Add New" Button
        GridBagConstraints addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 0;
        addButtonConstraints.weightx = 0.5;
        addButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(addButton, addButtonConstraints);

        // Add Search Button and Text Field
        GridBagConstraints searchPanelConstraints = new GridBagConstraints();
        searchPanelConstraints.gridx = 2;
        searchPanelConstraints.gridy = 0;
        searchPanelConstraints.weightx = 0.5;
        searchPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchPanel.setBackground(new Color(204, 255, 204));

        var searchLabel = new JLabel("Search Recipe: ");
        searchLabel.setForeground(new Color(74, 186, 113));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, searchPanelConstraints);

        // Add your JList to the panel
        GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
        scrollPaneConstraints.gridx = 0;
        scrollPaneConstraints.gridy = 1;
        scrollPaneConstraints.gridwidth = 3;
        scrollPaneConstraints.weighty = 1.0;
        scrollPaneConstraints.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(recipeList);
        add(scrollPane, scrollPaneConstraints);

        // Add buttons to the panel
        GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 2;
        buttonPanelConstraints.gridwidth = 3;
        buttonPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(204, 255, 204));
        buttonPanel.add(viewButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, buttonPanelConstraints);

        // Set up your JDBC connection
        setupJDBCConnection(); // Replace this with your actual JDBC connection code

        // Style the JList
        var cursor = new Cursor(Cursor.HAND_CURSOR);
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        recipeList.setSelectionBackground(Color.WHITE);
        recipeList.setSelectionForeground(new Color(74, 186, 113));
        recipeList.setCursor(cursor);
        recipeList.setBackground(new Color(204, 255, 204));

        // Set a custom cell renderer for centering and styling the text
        recipeList.setCellRenderer(new RecipeListRenderer());
        recipeList.setBorder(BorderFactory.createLineBorder(new Color(74, 186, 113)));

        // Add a ListSelectionListener to the JList
        recipeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check if the selection is not empty
                if (!recipeList.isSelectionEmpty()) {
                    // Make the buttons visible
                    viewButton.setVisible(true);
                    editButton.setVisible(true);
                    deleteButton.setVisible(true);
                } else {
                    // If no selection, make the buttons invisible
                    viewButton.setVisible(false);
                    editButton.setVisible(false);
                    deleteButton.setVisible(false);
                }
            }
        });

        // Add ActionListener to the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.getCardLayout().show(dashboard.getContent(), "addRecipe");
            }
        });

        // Add ActionListener to the Search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform search when the button is clicked
                performSearch();
            }
        });

        // Add ActionListener to the View button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve and display all data for the selected recipe
                int selectedIndex = recipeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    // Extract the recipe name without the prefix
                    String selectedRecipe = listModel.getElementAt(selectedIndex);
                    String recipeName = selectedRecipe.substring(2);

                    // Call a method to fetch and display all data for the selected recipe
                    String[] selectedData = selectedRecipeData(recipeName);
                    dashboard.showRecipeDetailsPanel(selectedData);

                } else {
                    JOptionPane.showMessageDialog(null, "No recipe is selected");
                }
            }
        });

        // Add ActionListener to the Edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = -1;

                try {
                    selectedIndex = recipeList.getSelectedIndex();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Update first");

                }
                if (selectedIndex != -1) {
                    // Extract the recipe name without the prefix
                    String selectedRecipe = listModel.getElementAt(selectedIndex);
                    String recipeName = selectedRecipe.substring(2);

                    // Call a method to fetch and display all data for the selected recipe
                    String[] selectedData = selectedRecipeData(recipeName);
                    dashboard.showEditRecipePanel(selectedData);

                } else {
                    JOptionPane.showMessageDialog(null, "No recipe is selected");
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = recipeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    // Extract the recipe name without the prefix
                    String selectedRecipe = listModel.getElementAt(selectedIndex);
                    String recipeName = selectedRecipe.substring(2);

                    // Show a confirmation dialog before deleting
                    int dialogResult = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete the recipe \"" + recipeName + "\"?", "Confirmation",
                            JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION) {
                        // Call a method to delete the selected recipe
                        deleteSelectedRecipe(recipeName);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No recipe is selected");
                }
            }
        });

        // Set default visibility for buttons
        viewButton.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);

        // Set the list model to your JList
        recipeList.setModel(listModel);
    }

    private void setupJDBCConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epicure", "root", "root1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT recipe_name FROM recipe");

            while (resultSet.next()) {
                listModel.addElement("# " + resultSet.getString("recipe_name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void performSearch() {
        String query = searchField.getText().trim().toLowerCase();

        // Check if the search query is empty
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a recipe name to search.", "Empty Search", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if any recipe matches the search query
        boolean matchFound = false;
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.getElementAt(i).toLowerCase().contains(query)) {
                recipeList.setSelectedIndex(i);
                matchFound = true;
                break;
            }
        }

        // Display a message if no matches are found
        if (!matchFound) {
            JOptionPane.showMessageDialog(this, "No matching recipes found.", "No Match", JOptionPane.INFORMATION_MESSAGE);
            // Reset the selection in the JList and show all recipes
            recipeList.clearSelection();
        }
    }

    private String[] selectedRecipeData(String recipeName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epicure", "root", "root1234");
            String query = "SELECT * FROM recipe WHERE recipe_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, recipeName);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Display all data for the selected recipe
            while (resultSet.next()) {

                String recipeTitle = resultSet.getString("recipe_name");
                String ingredients = resultSet.getString("ingredients");
                String instruction = resultSet.getString("instruction");
                String category = resultSet.getString("category");
                String preparationTime = resultSet.getString("preparation_time");
                String difficulty = resultSet.getString("difficulty");

                String[] data = {recipeTitle, ingredients, instruction, category, preparationTime, difficulty};

                // Now you can use recipeDataArray as needed (e.g., display in a dialog)
                return data;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    // Custom renderer for styling
    class RecipeListRenderer extends DefaultListCellRenderer {

        private static final int DEFAULT_HEIGHT = 40; // Set the default height

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 14)); // Customize font style
            label.setForeground(new Color(74, 186, 113));
            label.setPreferredSize(new Dimension(label.getWidth(), DEFAULT_HEIGHT)); // Set the default height

            return label;
        }
    }

    public void refreshRecipeList() {
        // Clear the existing list model
        listModel.clear();

        // Fetch and add recipes from the database
        setupJDBCConnection();

        // Reset selection and visibility of buttons
        recipeList.clearSelection();
        viewButton.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
    }

    private void deleteSelectedRecipe(String recipeName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epicure", "root", "root1234");
            String query = "DELETE FROM recipe WHERE recipe_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, recipeName);
                preparedStatement.executeUpdate();
            }

            // Inform the user about the successful deletion
            playNotificationSound();

            // Refresh the recipe list after deletion
            refreshRecipeList();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exception or display an error message
            JOptionPane.showMessageDialog(null, "Error deleting recipe. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void playNotificationSound() {
        try {
            File soundFile = new File("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\markAsComplete.wav"); // Replace with your sound file path
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

}
