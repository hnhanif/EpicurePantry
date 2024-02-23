package homescreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SingUpForm extends javax.swing.JFrame {

    private HomeScreen app;

    public SingUpForm(HomeScreen app) {
        this.app = app;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderOption = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        genderLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        notToSayRadio = new javax.swing.JRadioButton();
        femaleOption = new javax.swing.JRadioButton();
        maleOption = new javax.swing.JRadioButton();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        BackBtn = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        jPanel2.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 800, 100));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setBackground(new java.awt.Color(204, 255, 204));
        titleLabel.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(74, 186, 113));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Please Fill UP The Given Form");
        titleLabel.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        genderLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(74, 186, 113));
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender:");
        jPanel4.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 100, 40));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(74, 186, 113));
        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstNameLabel.setText("First Name:");
        jPanel4.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 40));

        firstNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(74, 186, 113));
        firstNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        firstNameField.setCaretColor(new java.awt.Color(74, 186, 113));
        firstNameField.setOpaque(true);
        jPanel4.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 460, 40));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(74, 186, 113));
        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastNameLabel.setText("Last Name:");
        jPanel4.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 55, 100, 40));

        lastNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(74, 186, 113));
        lastNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        lastNameField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel4.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 55, 460, 40));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(74, 186, 113));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email:");
        jPanel4.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 115, 100, 40));

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailField.setForeground(new java.awt.Color(74, 186, 113));
        emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        emailField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel4.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 115, 460, 40));

        passLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(74, 186, 113));
        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("Password:");
        jPanel4.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 285, 100, 40));

        notToSayRadio.setBackground(new java.awt.Color(204, 255, 204));
        genderOption.add(notToSayRadio);
        notToSayRadio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        notToSayRadio.setForeground(new java.awt.Color(74, 186, 113));
        notToSayRadio.setText("Not To Say");
        notToSayRadio.setBorder(null);
        notToSayRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notToSayRadio.setFocusPainted(false);
        notToSayRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(notToSayRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 120, 40));

        femaleOption.setBackground(new java.awt.Color(204, 255, 204));
        genderOption.add(femaleOption);
        femaleOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        femaleOption.setForeground(new java.awt.Color(74, 186, 113));
        femaleOption.setText("Female");
        femaleOption.setBorder(null);
        femaleOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        femaleOption.setFocusPainted(false);
        femaleOption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(femaleOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 90, 40));

        maleOption.setBackground(new java.awt.Color(204, 255, 204));
        genderOption.add(maleOption);
        maleOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maleOption.setForeground(new java.awt.Color(74, 186, 113));
        maleOption.setText("Male");
        maleOption.setBorder(null);
        maleOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maleOption.setFocusPainted(false);
        maleOption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(maleOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 80, 40));

        phoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(74, 186, 113));
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone:");
        jPanel4.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 175, 100, 40));

        phoneField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneField.setForeground(new java.awt.Color(74, 186, 113));
        phoneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        phoneField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel4.add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 175, 460, 40));

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
        jPanel4.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 170, 60));

        passField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passField.setForeground(new java.awt.Color(74, 186, 113));
        passField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        passField.setCaretColor(new java.awt.Color(74, 186, 113));
        jPanel4.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 285, 460, 40));

        submitBtn.setBackground(new java.awt.Color(204, 255, 204));
        submitBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/button_submit.png"))); // NOI18N
        submitBtn.setBorder(null);
        submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn.setFocusPainted(false);
        submitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel4.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 220, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        app.getCardLayout().show(app.cardPanel, "SignIn");

    }//GEN-LAST:event_BackBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String gender = getGender();
        char[] passChars = passField.getPassword();
        String password = new String(passChars);

        boolean isValid = writeUserData(firstName, lastName, email, gender, password);

        resetDataField();

        if (isValid) {
            app.getCardLayout().show(app.cardPanel, "SignIn");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private String getGender() {
        String gender = "";
        if (maleOption.isSelected()) {
            gender = "Male";
        } else if (femaleOption.isSelected()) {
            gender = "Female";
        } else {
            gender = "Not To Say";
        }

        return gender;
    }

    private void resetDataField() {
        genderOption.clearSelection();
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        passField.setText("");
    }

    private boolean isEmailAlreadyRegistered(String email) {
        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Check if a result is returned
            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
            return false;
        }
    }

    private boolean writeUserData(String firstName, String lastName, String email, String gender, String password) {
        if (firstName.length() == 0 || lastName.length() == 0 || email.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Fill up the field");
            return false;
        }

        if (isEmailAlreadyRegistered(email)) {
            JOptionPane.showMessageDialog(null, "Email already registered. Choose another email.");
            return false; // Prevent writing duplicate entries
        }

        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users (first_name, last_name, email, gender, password) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, password);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            JOptionPane.showMessageDialog(null, "Registration Failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton femaleOption;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.ButtonGroup genderOption;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JRadioButton maleOption;
    private javax.swing.JRadioButton notToSayRadio;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
