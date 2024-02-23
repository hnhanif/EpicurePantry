/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package homescreen;

/**
 *
 * @author Abu Hanif
 */
public class MealPlannerPanel extends javax.swing.JPanel {

    /**
     * Creates new form MealPlannerPanel
     */
    public MealPlannerPanel() {
        initComponents();
        MyInit();
    }

    public void MyInit() {
        contentPanel.setLayout(null);
        var planner = new MealPlanner();
        planner.setBounds(0, 0, 450, 400);
        contentPanel.add(planner);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 186, 113));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Efortless meal planning for you");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        jPanel3.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 650, 50));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 100, 450));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 450));

        contentPanel.setBackground(new java.awt.Color(153, 255, 255));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 450, 400));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 40, 30));

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 450, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
