/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package homescreen;

/**
 *
 * @author Abu Hanif
 */
public class DetailsPanel extends javax.swing.JPanel {

    private Dashboard dashboard;

    /**
     * Creates new form DetailsPanel
     */
    public DetailsPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
    }

    public void setData(String[] data) {
        recipeTitleLabel.setText(data[0]);
        ingredientsLabel.setText(data[1]);
        instructionsLabel.setText(data[2]);
        categoryLabel.setText(data[3]);
        anything.setText(data[4]);
        difficultyLabel.setText(data[5]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        recipeTitleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        anything = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        difficultyLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        preparationTimeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        instructionsLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ingredientsLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipeTitleLabel.setFont(new java.awt.Font("Segoe Script", 1, 30)); // NOI18N
        recipeTitleLabel.setForeground(new java.awt.Color(74, 186, 113));
        recipeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(recipeTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        jPanel2.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 50));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 650, 50));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/recipe.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 0, 295, 225));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 186, 113));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Preparation Time:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 280, 150, 40));

        anything.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        anything.setForeground(new java.awt.Color(74, 186, 113));
        anything.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(anything, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 60, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 186, 113));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Category:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 330, 100, 40));

        categoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        categoryLabel.setForeground(new java.awt.Color(74, 186, 113));
        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 165, 40));

        difficultyLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        difficultyLabel.setForeground(new java.awt.Color(74, 186, 113));
        difficultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(difficultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 165, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 186, 113));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Difficulty:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 380, 100, 40));

        preparationTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        preparationTimeLabel.setForeground(new java.awt.Color(74, 186, 113));
        preparationTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preparationTimeLabel.setText("minutes");
        jPanel3.add(preparationTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 60, 40));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 305, 450));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructionsLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        instructionsLabel.setForeground(new java.awt.Color(74, 186, 113));
        jPanel5.add(instructionsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 55, 260, 170));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 186, 113));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Instructions:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 310, 225));

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingredientsLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ingredientsLabel.setForeground(new java.awt.Color(74, 186, 113));
        jPanel6.add(ingredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 55, 250, 170));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(74, 186, 113));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ingredients:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 0, 290, 225));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(74, 186, 113));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel5");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 165, 225));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(74, 186, 113));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ingredients:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 0, 310, 225));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 100, 310, 450));

        jPanel9.setBackground(new java.awt.Color(255, 255, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/line.png"))); // NOI18N
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 450));

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 100, 40, 450));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anything;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JLabel difficultyLabel;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel preparationTimeLabel;
    private javax.swing.JLabel recipeTitleLabel;
    // End of variables declaration//GEN-END:variables
}
