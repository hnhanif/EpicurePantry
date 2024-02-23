package homescreen;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateRecipePanel extends javax.swing.JPanel {

    private Dashboard dashboard;
    private String[] originalRecipeDetails;
    private MyRecipePanel myRecipePanel;

//    private MyRecipePanel myRecipePanel;
    public UpdateRecipePanel(Dashboard dashboard, MyRecipePanel myRecipePanel, String[] originalRecipeDetails) {
        this.dashboard = dashboard;
        this.myRecipePanel = myRecipePanel;
        this.originalRecipeDetails = originalRecipeDetails;
        initComponents();
        myInit();
    }

    public void myInit() {
        initFields(originalRecipeDetails);
        difficultyCombo.setRenderer(new CustomizeCupboardBoxRenderer());
        categoryCombo.setRenderer(new CustomizeCupboardBoxRenderer());

    }

    public void setRecipeDetails(String[] recipeDetails) {
        // Update fields with the new recipe details

        recipeNameField.setText(recipeDetails[0]);
        ingredientsAreaField.setText(recipeDetails[1]);
        instructionsAreaField.setText(recipeDetails[2]);
        categoryCombo.setSelectedItem(recipeDetails[3]);
        preparationTimeField.setText(recipeDetails[4]);
        difficultyCombo.setSelectedItem(recipeDetails[5]);

    }

    private void initFields(String[] recipeDetails) {
        // Initialize fields with the original recipe details
        recipeNameField.setText(recipeDetails[0]);
        ingredientsAreaField.setText(recipeDetails[1]);
        instructionsAreaField.setText(recipeDetails[2]);
        categoryCombo.setSelectedItem(recipeDetails[3]);
        preparationTimeField.setText(recipeDetails[4]);
        difficultyCombo.setSelectedItem(recipeDetails[5]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
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
        saveBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 186, 113));
        jLabel2.setText("Update Recipe Data");
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

        saveBtn.setBackground(new java.awt.Color(74, 186, 113));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Update");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel6.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 450, 40));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 100, 500, 400));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 100, 75, 400));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        jPanel1.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 100));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 75, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        dashboard.getCardLayout().show(dashboard.getContent(), "recipes");
    }//GEN-LAST:event_BackBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        String newRecipeName = recipeNameField.getText();
        String newIngredients = ingredientsAreaField.getText();
        String newInstructions = instructionsAreaField.getText();
        String newCategory = categoryCombo.getSelectedItem().toString();
        String newPreparationTime = preparationTimeField.getText();
        String newDifficulty = difficultyCombo.getSelectedItem().toString();

        if (isAnyFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields first.");
        } else {
            try {
                DatabaseManager.updateRecipe(originalRecipeDetails[0], newRecipeName, newIngredients, newInstructions, newCategory, newPreparationTime, newDifficulty);
                JOptionPane.showMessageDialog(null, "Recipe updated successfully");

                // Call the callback to notify the update
                // Navigate back to the recipes panel
                myRecipePanel.recipePanel.refreshRecipeList();
                dashboard.getCardLayout().show(dashboard.getContent(), "recipes");
            } catch (SQLException ex) {
                Logger.getLogger(UpdateRecipePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private boolean isAnyFieldEmpty() {
        return recipeNameField.getText().isEmpty()
                || ingredientsAreaField.getText().isEmpty()
                || instructionsAreaField.getText().isEmpty()
                || categoryCombo.getSelectedItem().toString().isEmpty()
                || preparationTimeField.getText().isEmpty()
                || difficultyCombo.getSelectedItem().toString().isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JComboBox<String> difficultyCombo;
    private javax.swing.JTextArea ingredientsAreaField;
    private javax.swing.JTextArea instructionsAreaField;
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
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
