package homescreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MealPlanner extends JPanel {

    private JComboBox<String> recipeComboBox;
    private DefaultListModel<String> mealListModel;
    private JLabel preparationTimeLabel;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/epicure";
    private static final String USER = "root";
    private static final String PASSWORD = "root1234";

    private Map<String, Long> mealTimeMap = new HashMap<>();

    public MealPlanner() {
        setLayout(new BorderLayout());
        var font = new Font("Arial", Font.BOLD, 12);

        // Initialize JComboBox for recipe selection
        recipeComboBox = new JComboBox<>();
        recipeComboBox.setFont(font);
        recipeComboBox.setBackground(new Color(204, 255, 204));
        recipeComboBox.setForeground(new Color(74, 186, 113));
        recipeComboBox.setOpaque(false);
        recipeComboBox.setFocusable(false);
        recipeComboBox.setBorder(null);
        recipeComboBox.setRenderer(new CenteredTextRenderer());
        recipeComboBox.setPreferredSize(new Dimension(150, 30));
        recipeComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recipeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePreparationTimeLabel();
            }
        });

        // Add a label above the JComboBox
        JLabel chooseMealLabel = new JLabel("Choose Meal:");
        chooseMealLabel.setForeground(new Color(74, 186, 113));

        chooseMealLabel.setFont(font);

        // Panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(204, 255, 204));
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(chooseMealLabel);
        inputPanel.add(recipeComboBox);

        // Label for preparation time
        preparationTimeLabel = new JLabel("Est.Time: ");
        preparationTimeLabel.setFont(font);
        preparationTimeLabel.setForeground(new Color(74, 186, 113));

        // Add the label directly to the inputPanel
        inputPanel.add(preparationTimeLabel);

        // Initialize DefaultListModel and JList for displaying meal plan
        mealListModel = new DefaultListModel<>();
        JList<String> mealList = new JList<>(mealListModel);
        mealList.setBackground(new Color(204, 255, 204));
        mealList.setCellRenderer(new CustomListCellRenderer());
        mealList.setBorder(BorderFactory.createLineBorder(new Color(74, 186, 113)));
        mealList.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mealList.setFont(font);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(204, 255, 204));
        buttonPanel.setLayout(new FlowLayout());

        // Button for adding meals
        JButton addMealButton = new JButton("Add Meal");
        addMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRecipe = (String) recipeComboBox.getSelectedItem();

                if (selectedRecipe != null) {
                    long currentTime = System.currentTimeMillis();
                    addMealToDatabase(selectedRecipe, currentTime);
                    loadMealsFromDatabase();
                } else {
                    JOptionPane.showMessageDialog(null, "No item selected.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Button for marking a meal as complete
        JButton markCompleteButton = new JButton("Mark as Complete");
        // Inside the "Mark as Complete" button action listener
        markCompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = mealList.getSelectedIndex();

                if (selectedIndex != -1) {
                    String selectedMeal = mealListModel.getElementAt(selectedIndex);
                    String[] mealParts = selectedMeal.split(" - ");
                    String recipeName = mealParts[0];

                    int option = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete \"" + selectedMeal + "\"?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        removeMealFromDatabase(recipeName);
                        loadMealsFromDatabase();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No item selected.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addMealButton.setPreferredSize(new Dimension(150, 30));
        addMealButton.setFont(font);
        addMealButton.setBorder(null);
        addMealButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMealButton.setFocusPainted(false);
        addMealButton.setBackground(new Color(74, 186, 113));
        addMealButton.setForeground(Color.WHITE);

        markCompleteButton.setPreferredSize(new Dimension(150, 30));
        markCompleteButton.setFont(font);
        markCompleteButton.setBorder(null);
        markCompleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        markCompleteButton.setFocusPainted(false);
        markCompleteButton.setBackground(new Color(255, 165, 0));
        markCompleteButton.setForeground(Color.WHITE);

        // Add components to the button panel
        buttonPanel.add(addMealButton);
        buttonPanel.add(markCompleteButton);

        // Add components to the panel
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(mealList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ensure the preparationTimeLabel is properly initialized before calling loadRecipes
        loadRecipes();  // Load recipes from the database
        loadMealsFromDatabase(); // Load meals from the database
    }

    private void updatePreparationTimeLabel() {
        String selectedRecipe = (String) recipeComboBox.getSelectedItem();
        if (selectedRecipe != null) {
            Long preparationTime = getPreparationTime(selectedRecipe);
            if (preparationTime != null) {
                preparationTimeLabel.setText("Est.Time: " + preparationTime + " minutes");
            } else {
                preparationTimeLabel.setText("Est.Time: N/A");
            }
        } else {
            preparationTimeLabel.setText("Est.Time: N/A");
        }
    }

    private Long getPreparationTime(String recipeName) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT preparation_time FROM recipe WHERE recipe_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, recipeName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getLong("preparation_time");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String calculatePreparationTime(long mealTime) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - mealTime;

        long minutes = elapsedTime / (60 * 1000);
        long hours = elapsedTime / (60 * 60 * 1000);
        long days = elapsedTime / (24 * 60 * 60 * 1000);

        if (minutes < 1) {
            return "just now";
        } else if (minutes < 60) {
            return minutes + " minute" + (minutes > 1 ? "s" : "") + " ago";
        } else if (hours < 24) {
            return hours + " hour" + (hours > 1 ? "s" : "") + " ago";
        } else {
            return days + " day" + (days > 1 ? "s" : "") + " ago";
        }
    }

    private void addMealToDatabase(String recipeName, long mealTime) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "INSERT INTO meals (recipe_name, meal_time) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, recipeName);
                statement.setTimestamp(2, new Timestamp(mealTime));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeMealFromDatabase(int mealId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "DELETE FROM meals WHERE meal_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, mealId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeMealFromDatabase(Object identifier) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query;
            if (identifier instanceof Integer) {
                query = "DELETE FROM meals WHERE meal_id = ?";
            } else if (identifier instanceof String) {
                query = "DELETE FROM meals WHERE recipe_name = ?";
            } else {
                throw new IllegalArgumentException("Invalid identifier type");
            }

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, identifier);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadMealsFromDatabase() {
        mealListModel.clear();
        mealTimeMap.clear();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT recipe_name, meal_time FROM meals ORDER BY meal_time DESC";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String recipeName = resultSet.getString("recipe_name");
                    Timestamp mealTimestamp = resultSet.getTimestamp("meal_time");
                    long mealTime = mealTimestamp.getTime();

                    mealTimeMap.put(recipeName, mealTime);

                    mealListModel.addElement(recipeName + " - " + calculatePreparationTime(mealTime));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadRecipes() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT recipe_name FROM recipe ORDER BY recipe_name DESC";
            try (PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String recipeName = resultSet.getString("recipe_name");
                    recipeComboBox.addItem(recipeName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class CenteredTextRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setHorizontalAlignment(SwingConstants.CENTER);
            return this;
        }
    }

    class CustomListCellRenderer extends DefaultListCellRenderer {

        private static final int DEFAULT_HEIGHT = 30;
        private static final Color SELECTED_COLOR = new Color(255, 255, 255);

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            setPreferredSize(new Dimension(getWidth(), DEFAULT_HEIGHT));
            setHorizontalAlignment(SwingConstants.CENTER);

            if (isSelected) {
                setBackground(SELECTED_COLOR);
                setForeground(new Color(74, 186, 113));
            } else {
                setBackground(list.getBackground());
                setForeground(new Color(74, 186, 113));
            }

            return this;
        }
    }
}
