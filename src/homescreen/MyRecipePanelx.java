package homescreen;

import java.util.List;
import javax.swing.JOptionPane;

import java.sql.SQLException;

public class MyRecipePanelx extends javax.swing.JPanel {

    private Dashboard dashboard;
    private EditableTableModel tableModel;

    public MyRecipePanelx(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        myInit();

    }

    public void reloadRecipeData() {
        loadRecipeData();
        viewBtn.setVisible(false);
        deleteBtn.setVisible(false);
        editBtn.setVisible(false);
    }

    public void myInit() {
        // Initialize table model
        tableModel = new EditableTableModel(List.of(), List.of("Recipe Name", "Ingredients", "Instructions", "Category", "Preparation Time", "Difficulty"));

        loadRecipeData();
        viewBtn.setVisible(false);
        deleteBtn.setVisible(false);
        editBtn.setVisible(false);

        // Allow cells in the table to be editable
        table.setModel(tableModel);

        // Add key listener to the table for Enter key
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    viewBtn.setVisible(true);
                    deleteBtn.setVisible(true);
                    editBtn.setVisible(true);
                } else {
                    viewBtn.setVisible(false);
                    deleteBtn.setVisible(false);
                    editBtn.setVisible(false);
                }
            }
        });
    }

    private void loadRecipeData() {
        try {
            List<String[]> recipes = DatabaseManager.fetchAllRecipes(); // Replace with your method to fetch data from the database

            tableModel.setRowCount(0); // Clear existing rows

            for (String[] data : recipes) {
                tableModel.addRow(data);
            }

            // Set the non-editable property after adding data
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    tableModel.setValueAt(tableModel.getValueAt(i, j), i, j);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addnewBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2023");
        jPanel1.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 100));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addnewBtn.setText("Add New");
        addnewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addnewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBackground(new java.awt.Color(246, 246, 246));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        table.setForeground(new java.awt.Color(74, 186, 113));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe Name", "Ingredientes", "Instructions", "Category", "Preparation Time", "Difficulty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 630, 330));

        deleteBtn.setBackground(new java.awt.Color(217, 83, 79));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(null);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setFocusPainted(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel5.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 200, 40));

        viewBtn.setBackground(new java.awt.Color(74, 186, 113));
        viewBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("View");
        viewBtn.setBorder(null);
        viewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewBtn.setFocusPainted(false);
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });
        jPanel5.add(viewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 340, 200, 40));

        editBtn.setBackground(new java.awt.Color(240, 173, 78));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.setBorder(null);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.setFocusPainted(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel5.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 170, 40));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 650, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int columnCount = table.getColumnCount();
            String[] selectedDetails = new String[columnCount];

            for (int i = 0; i < columnCount; i++) {
                Object value = table.getValueAt(selectedRow, i);
                selectedDetails[i] = (value != null) ? value.toString() : "";
            }

            dashboard.showRecipeDetailsPanel(selectedDetails);
        } else {
            JOptionPane.showMessageDialog(null, "No row is selected");
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (confirmDialog == JOptionPane.YES_OPTION) {
                try {
                    String recipeName = table.getValueAt(selectedRow, 0).toString();
                    DatabaseManager.deleteRecipe(recipeName); // Replace with your method to delete data from the database
                    reloadRecipeData();
                    JOptionPane.showMessageDialog(null, "Recipe deleted successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting recipe");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row is selected");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addnewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewBtnActionPerformed
        // TODO add your handling code here:
        dashboard.getCardLayout().show(dashboard.getContent(), "addRecipe");
    }//GEN-LAST:event_addnewBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int columnCount = table.getColumnCount();
            String[] selectedDetails = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                Object value = table.getValueAt(selectedRow, i);
                selectedDetails[i] = (value != null) ? value.toString() : "";
            }
            dashboard.showEditRecipePanel(selectedDetails);
        } else {
            JOptionPane.showMessageDialog(null, "No row is selected");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnewBtn;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
