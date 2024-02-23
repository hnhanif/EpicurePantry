package homescreen;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JOptionPane;

public class AddRecipePanel extends javax.swing.JPanel {

    private Dashboard dashboard;
    private MyRecipePanel myRecipe;

    public AddRecipePanel(Dashboard dashboard, MyRecipePanel myRecipe) {
        this.dashboard = dashboard;
        this.myRecipe = myRecipe;
        initComponents();
        myInit();
    }

    public void myInit() {
        difficultyCombo.setRenderer(new CustomizeCupboardBoxRenderer());
        categoryCombo.setRenderer(new CustomizeCupboardBoxRenderer());

    }

    public void saveRecipe(String recipeName, String ingredients, String instruction, String category, int preparationTime, String difficulty) {
        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Recipe (recipe_name, ingredients, instruction, category, preparation_time, difficulty) VALUES (?, ?, ?, ?, ?, ?)"
        )) {

            preparedStatement.setString(1, recipeName);
            preparedStatement.setString(2, ingredients);
            preparedStatement.setString(3, instruction);
            preparedStatement.setString(4, category);
            preparedStatement.setInt(5, preparationTime);
            preparedStatement.setString(6, difficulty);

            preparedStatement.executeUpdate();
            // Add any additional logic or UI updates as needed
            playNotificationSound();
            clearRecipeFields();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private void clearRecipeFields() {
        recipeNameField.setText("");
        ingredientsAreaField.setText("");
        instructionsAreaField.setText("");
        categoryCombo.setSelectedIndex(0); // Assuming the first item is a default or empty value
        preparationTimeField.setText("");
        difficultyCombo.setSelectedIndex(0); // Assuming the first item is a default or empty value
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        recipeLabel = new javax.swing.JLabel();
        preparationTimeField = new javax.swing.JTextField();
        recipeLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionsAreaField = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ingredientsAreaField = new javax.swing.JTextArea();
        recipeLabel2 = new javax.swing.JLabel();
        recipeLabel3 = new javax.swing.JLabel();
        difficultyCombo = new javax.swing.JComboBox<>();
        recipeLabel4 = new javax.swing.JLabel();
        recipeNameField = new javax.swing.JTextField();
        recipeLabel5 = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        jPanel1.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 100));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 100, 75, 400));

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel.setText("Preparation Time:");
        jPanel6.add(recipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 150, 40));

        preparationTimeField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        preparationTimeField.setForeground(new java.awt.Color(74, 186, 113));
        preparationTimeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        preparationTimeField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        preparationTimeField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel6.add(preparationTimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 250, 40));

        recipeLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel1.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel1.setText("Recipe Name:");
        jPanel6.add(recipeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        instructionsAreaField.setColumns(10);
        instructionsAreaField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        instructionsAreaField.setForeground(new java.awt.Color(74, 186, 113));
        instructionsAreaField.setLineWrap(true);
        instructionsAreaField.setRows(2);
        instructionsAreaField.setWrapStyleWord(true);
        instructionsAreaField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        instructionsAreaField.setCaretColor(new java.awt.Color(74, 186, 113));
        jScrollPane2.setViewportView(instructionsAreaField);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 250, 60));

        ingredientsAreaField.setColumns(10);
        ingredientsAreaField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ingredientsAreaField.setForeground(new java.awt.Color(74, 186, 113));
        ingredientsAreaField.setLineWrap(true);
        ingredientsAreaField.setRows(2);
        ingredientsAreaField.setWrapStyleWord(true);
        ingredientsAreaField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        ingredientsAreaField.setCaretColor(new java.awt.Color(74, 186, 113));
        jScrollPane3.setViewportView(ingredientsAreaField);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 250, 60));

        recipeLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel2.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel2.setText("Ingredients:");
        jPanel6.add(recipeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        recipeLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel3.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel3.setText("Instructions:");
        jPanel6.add(recipeLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, 40));

        difficultyCombo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        difficultyCombo.setForeground(new java.awt.Color(74, 186, 113));
        difficultyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));
        difficultyCombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        jPanel6.add(difficultyCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 250, 40));

        recipeLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel4.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel4.setText("Difficulty:");
        jPanel6.add(recipeLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 150, 40));

        recipeNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeNameField.setForeground(new java.awt.Color(74, 186, 113));
        recipeNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recipeNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        recipeNameField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel6.add(recipeNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 250, 40));

        recipeLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recipeLabel5.setForeground(new java.awt.Color(74, 186, 113));
        recipeLabel5.setText("Category:");
        jPanel6.add(recipeLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 150, 40));

        categoryCombo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryCombo.setForeground(new java.awt.Color(74, 186, 113));
        categoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dessert", "Main Course", "Appetizer", "Side Dish", "Beverage" }));
        categoryCombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        jPanel6.add(categoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 250, 40));

        jButton1.setBackground(new java.awt.Color(74, 186, 113));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 450, 40));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 100, 500, 400));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 75, 400));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 186, 113));
        jLabel2.setText("Add New Recipe");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 470, 100));

        BackBtn.setBackground(new java.awt.Color(204, 255, 204));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/button_back.png"))); // NOI18N
        BackBtn.setBorder(null);
        BackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackBtn.setFocusPainted(false);
        BackBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        jPanel2.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 60));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String recipe = recipeNameField.getText();
        String ingredients = ingredientsAreaField.getText();
        String instructions = instructionsAreaField.getText();
        String category = getCategory();
        int preparationTime = Integer.parseInt(preparationTimeField.getText());
        String difficulty = getDifficulty();
        if (isAnyFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "fill up all fields");
        } else {
            saveRecipe(recipe, ingredients, instructions, category, preparationTime, difficulty);

            dashboard.getCardLayout().show(dashboard.getContent(), "recipes");
//            myRecipe.reloadRecipeData();

        }
        myRecipe.recipePanel.refreshRecipeList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        dashboard.getCardLayout().show(dashboard.getContent(), "recipes");

    }//GEN-LAST:event_BackBtnActionPerformed

    private boolean isAnyFieldEmpty() {
        return recipeNameField.getText().isEmpty() || ingredientsAreaField.getText().isEmpty() || instructionsAreaField.getText().isEmpty() || categoryCombo.getSelectedItem() == null || preparationTimeField.getText().isEmpty() || difficultyCombo.getSelectedItem() == null;
    }

    private String getCategory() {
        switch (categoryCombo.getSelectedIndex()) {
            case 1 -> {
                return "Main Course";
            }
            case 2 -> {
                return "Appetizer";
            }
            case 3 -> {
                return "Side Dish";
            }
            case 4 -> {
                return "Beverage";
            }
            default -> {
                return "Dessert";

            }
        }
    }

    private String getDifficulty() {
        if (difficultyCombo.getSelectedIndex() == 1) {
            return "Medium";
        } else if (difficultyCombo.getSelectedIndex() == 2) {
            return "Hard";
        }
        return "Easy";
    }

    private void playNotificationSound() {
        try {
            File soundFile = new File("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\addNew.wav"); // Replace with your sound file path
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JComboBox<String> difficultyCombo;
    private javax.swing.JTextArea ingredientsAreaField;
    private javax.swing.JTextArea instructionsAreaField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField preparationTimeField;
    private javax.swing.JLabel recipeLabel;
    private javax.swing.JLabel recipeLabel1;
    private javax.swing.JLabel recipeLabel2;
    private javax.swing.JLabel recipeLabel3;
    private javax.swing.JLabel recipeLabel4;
    private javax.swing.JLabel recipeLabel5;
    private javax.swing.JTextField recipeNameField;
    // End of variables declaration//GEN-END:variables
}
