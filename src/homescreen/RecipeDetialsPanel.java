package homescreen;

public class RecipeDetialsPanel extends javax.swing.JPanel {

    private Dashboard dashboard;

    public RecipeDetialsPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();

    }

    public void setData(String[] data) {
        recipeTitleLabel.setText(data[0]);
        ingredientsLabel.setText(data[1]);
        instructionsLabel.setText(data[2]);
        categoryLabel.setText(data[3]);
        preparationTimeLabel.setText(data[4]);
        difficultyLabel.setText(data[5]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recipeTitleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ingredientsLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        instructionsLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        preparationTimeLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        difficultyLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(recipeTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingredientsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(ingredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 650, 100));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(instructionsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 650, 100));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 650, 100));

        jPanel5.setBackground(new java.awt.Color(255, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preparationTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(preparationTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 650, 100));

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        difficultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(difficultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 100));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel difficultyLabel;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel preparationTimeLabel;
    private javax.swing.JLabel recipeTitleLabel;
    // End of variables declaration//GEN-END:variables
}
