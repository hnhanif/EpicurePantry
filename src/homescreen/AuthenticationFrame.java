package homescreen;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AuthenticationFrame extends javax.swing.JFrame {

    private HomeScreen app;
    public static String rememberedEmail;
    public static String rememberedPassword;

    public AuthenticationFrame(HomeScreen app) {
        this.app = app;
        initComponents();
    }

    public void resetPassField() {
        passField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        copyRightLabel = new javax.swing.JLabel();
        leftPanel1 = new javax.swing.JPanel();
        emailField = new javax.swing.JTextField();
        sginUpBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        imgPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(204, 255, 204));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(74, 186, 113));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome Back, Chef!");
        topPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        bottomPanel.setBackground(new java.awt.Color(204, 255, 204));
        bottomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyRightLabel.setBackground(new java.awt.Color(204, 255, 204));
        copyRightLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        copyRightLabel.setForeground(new java.awt.Color(74, 186, 113));
        copyRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightLabel.setText("copyright ©2024");
        bottomPanel.add(copyRightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 50));

        getContentPane().add(bottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 800, 100));

        leftPanel1.setBackground(new java.awt.Color(204, 255, 204));
        leftPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailField.setForeground(new java.awt.Color(74, 186, 113));
        emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailField.setToolTipText("Enter your email address");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        emailField.setCaretColor(new java.awt.Color(74, 186, 113));
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        leftPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 300, 40));

        sginUpBtn.setBackground(new java.awt.Color(204, 255, 204));
        sginUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/button_signup.png"))); // NOI18N
        sginUpBtn.setBorder(null);
        sginUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sginUpBtn.setFocusable(false);
        sginUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sginUpBtnActionPerformed(evt);
            }
        });
        leftPanel1.add(sginUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 150, 60));

        loginBtn.setBackground(new java.awt.Color(204, 255, 204));
        loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/button_login.png"))); // NOI18N
        loginBtn.setBorder(null);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.setFocusable(false);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        leftPanel1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 60));

        passField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passField.setForeground(new java.awt.Color(74, 186, 113));
        passField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passField.setToolTipText("Enter your password");
        passField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 186, 113), 2, true));
        passField.setCaretColor(new java.awt.Color(74, 186, 113));
        passField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFieldFocusLost(evt);
            }
        });
        leftPanel1.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 40));

        getContentPane().add(leftPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, 400));

        imgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homescreen/wc.png"))); // NOI18N
        imgPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(imgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sginUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sginUpBtnActionPerformed
        // TODO add your handling code here:
        app.getCardLayout().show(app.cardPanel, "SignUp");
    }//GEN-LAST:event_sginUpBtnActionPerformed

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if (emailField.getText().equals("Enter Email")) {
            emailField.setText("");
            emailField.setForeground(new Color(74, 186, 113));
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (emailField.getText().equals("")) {
            emailField.setText("Enter Email");
            emailField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFieldFocusGained
        if (String.valueOf(passField.getPassword()).equals("Enter Password")) {
            passField.setText("");
            passField.setForeground(new Color(74, 186, 113));
        }
    }//GEN-LAST:event_passFieldFocusGained

    private void passFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFieldFocusLost
        if (String.valueOf(passField.getPassword()).equals("")) {
            passField.setText("Enter Password");
            passField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passFieldFocusLost

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        String loginEmail = emailField.getText();
        char[] loginPasswordChars = passField.getPassword();
        String loginPassword = new String(loginPasswordChars);

        // Check login credentials
        if (isLoginValid(loginEmail, loginPassword)) {
            rememberCredentials(loginEmail, loginPassword);
            playNotificationSound();
            app.getCardLayout().show(app.cardPanel, "dashboard");
            // Add code to navigate to the homepage or perform any other actions
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login credentials. Please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            // Add code to handle invalid login attempt
        }

        // Clear the password field for security
        resetPassField();
    }//GEN-LAST:event_loginBtnActionPerformed

    private boolean isLoginValid(String email, String password) {
        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Check if a result is returned
            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
        }
        return false; // Invalid login
    }

    private void rememberCredentials(String email, String password) {
        rememberedEmail = email;
        rememberedPassword = password;
    }

    // Add a method to get remembered username
    public static String getRememberedEmail() {
        return "admin@email.com";
    }

    // Add a method to get remembered password
    public static String getRememberedPassword() {
        return "root1234";
    }

    private void playNotificationSound() {
        try {
            File soundFile = new File("F:\\CODE\\JAVA\\netBeans\\HomeScreen\\src\\homescreen\\login.wav"); // Replace with your sound file path
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel copyRightLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel imgPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel leftPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passField;
    private javax.swing.JButton sginUpBtn;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
