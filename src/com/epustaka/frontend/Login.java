/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.epustaka.frontend;

import com.epustaka.Main;
import com.epustaka.backend.Config;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author mazhn
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        tbLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ePustaka | Login");
        setMinimumSize(new java.awt.Dimension(430, 460));
        setPreferredSize(new java.awt.Dimension(430, 460));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel2.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel2.setText("ePustaka");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setText("Email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, -1));

        txtEmail.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 240, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, -1));

        txtPassword.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 240, -1));

        tbLogin.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tbLogin.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        tbLogin.setForeground(new java.awt.Color(255, 255, 255));
        tbLogin.setText("Login");
        tbLogin.setToolTipText("Menu Peminjaman");
        tbLogin.setBorder(null);
        tbLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbLogin.setMaximumSize(new java.awt.Dimension(32, 18));
        tbLogin.setMinimumSize(new java.awt.Dimension(32, 18));
        tbLogin.setPreferredSize(new java.awt.Dimension(72, 64));
        tbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtbLoginActionPerformed(evt);
            }
        });
        getContentPane().add(tbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 280, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void tbtbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtbLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            String sql = "SELECT * FROM pustakawan WHERE email = '" + email + "' AND password = '" + password + "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()) {
                Main.admin = res.getBoolean("admin");

                Buku bukuFrame = new Buku();
                bukuFrame.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah.", "Pemberitahuan", 0);
//                Main.admin = true;
//
//                Buku bukuFrame = new Buku();
//                bukuFrame.show();
//                dispose();
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_tbtbLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton tbLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
