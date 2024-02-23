package homescreen;

import javax.swing.*;
import java.awt.*;

public class TrendsNow extends JPanel {
    
    private JList<String> recipeList;
    private String[] trendingRecipes = {"Mediterranean Salad", "Avocado Toast", "Spicy Ramen", "Quinoa Bowl", "Vegan Buddha Bowl", "Caprese Salad", "Stir-Fried Tofu", "Pumpkin Soup", "Garlic Butter Shrimp", "Chocolate Avocado Smoothie"};
    private String[] recipeDetails = {
        "Mediterranean Salad: Healthy salad with fresh veggies and feta cheese.\n\nRating: 4.8/5\nDifficulty: Easy\nCategory: Salad\nPreparation Time: 15 mins\nCalories: 300\nVisiting Count: 5000",
        "Avocado Toast: Toasted bread with mashed avocado, topped with spices.\n\nRating: 4.5/5\nDifficulty: Easy\nCategory: Breakfast\nPreparation Time: 10 mins\nCalories: 250\nVisiting Count: 4500",
        "Spicy Ramen: Delicious ramen with a spicy broth and various toppings.\n\nRating: 4.7/5\nDifficulty: Medium\nCategory: Noodles\nPreparation Time: 20 mins\nCalories: 400\nVisiting Count: 6000",
        "Quinoa Bowl: Nutrient-rich bowl with quinoa, vegetables, and protein.\n\nRating: 4.5/5\nDifficulty: Easy\nCategory: Bowl\nPreparation Time: 15 mins\nCalories: 350\nVisiting Count: 4800",
        "Vegan Buddha Bowl: Plant-based bowl with a variety of colorful veggies and grains.\n\nRating: 4.9/5\nDifficulty: Easy\nCategory: Vegan\nPreparation Time: 20 mins\nCalories: 320\nVisiting Count: 5500",
        "Caprese Salad: Classic Italian salad with tomatoes, mozzarella, and basil.\n\nRating: 4.6/5\nDifficulty: Easy\nCategory: Salad\nPreparation Time: 12 mins\nCalories: 280\nVisiting Count: 5200",
        "Stir-Fried Tofu: Tofu stir-fried with vegetables in a flavorful sauce.\n\nRating: 4.5/5\nDifficulty: Medium\nCategory: Tofu\nPreparation Time: 18 mins\nCalories: 310\nVisiting Count: 4900",
        "Pumpkin Soup: Comforting soup with roasted pumpkin and aromatic spices.\n\nRating: 4.7/5\nDifficulty: Easy\nCategory: Soup\nPreparation Time: 25 mins\nCalories: 290\nVisiting Count: 5700",
        "Garlic Butter Shrimp: Succulent shrimp cooked in garlic-infused butter.\n\nRating: 4.9/5\nDifficulty: Medium\nCategory: Seafood\nPreparation Time: 15 mins\nCalories: 330\nVisiting Count: 5400",
        "Chocolate Avocado Smoothie: Rich and creamy chocolate smoothie with avocado.\n\nRating: 4.6/5\nDifficulty: Easy\nCategory: Smoothie\nPreparation Time: 10 mins\nCalories: 380\nVisiting Count: 5100",};
    
    public TrendsNow() {
        // Create JList with trending recipes and set default size

        recipeList = new JList<>(trendingRecipes);
        recipeList.setFixedCellHeight(50);
        recipeList.setFixedCellWidth(400);
        recipeList.setBorder(BorderFactory.createLineBorder(new Color(74, 186, 113)));
        recipeList.setSelectionBackground(Color.white);
        recipeList.setSelectionForeground(new Color(74, 186, 113));
        recipeList.setFont(new Font("Arial", Font.BOLD, 14));
        recipeList.setForeground(new Color(74, 186, 113));
        
        this.setPreferredSize(new Dimension(450, 450));
        this.setBackground(new Color(204, 255, 204));

        // Set JList cell renderer to center-align items
        DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        recipeList.setCellRenderer(centerRenderer);
        recipeList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recipeList.setBackground(new Color(204, 255, 204));

        // Add action listener for recipe selection
        recipeList.addListSelectionListener(e -> showRecipeDetails());

        // Add JList to the JPanel
        add(new JScrollPane(recipeList));
    }
    
    private void showRecipeDetails() {
        // Get selected index
        int selectedIndex = recipeList.getSelectedIndex();

        // Display enhanced recipe details using a custom-styled dialog
        if (selectedIndex >= 0 && selectedIndex < recipeDetails.length) {
            // Create a custom-styled dialog
            JTextArea detailsTextArea = new JTextArea(recipeDetails[selectedIndex]);
            detailsTextArea.setEditable(false);
            detailsTextArea.setLineWrap(true);
            detailsTextArea.setWrapStyleWord(true);

            // Customize the appearance of the text area
            detailsTextArea.setBackground(UIManager.getColor("Panel.background"));
            detailsTextArea.setFont(new Font(UIManager.getFont("Label.font").getName(), Font.PLAIN, 14));  // Adjust font size
            detailsTextArea.setForeground(UIManager.getColor("Label.foreground"));
            
            JScrollPane scrollPane = new JScrollPane(detailsTextArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));

            // Customize the JOptionPane appearance
            UIManager.put("OptionPane.background", UIManager.getColor("Panel.background"));
            UIManager.put("OptionPane.messageForeground", UIManager.getColor("Label.foreground"));

            // Center-align the JOptionPane
            JOptionPane optionPane = new JOptionPane(scrollPane, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            JDialog dialog = optionPane.createDialog("Recipe Details");
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }
    
}
