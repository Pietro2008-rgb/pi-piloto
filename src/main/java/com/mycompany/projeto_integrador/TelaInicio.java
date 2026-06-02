/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto_integrador;

public class TelaInicio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicio.class.getName());

    public TelaInicio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnjogar = new javax.swing.JButton();
        btnperfil = new javax.swing.JButton();
        btnconfig = new javax.swing.JButton();
        Jlabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnjogar.setText(" ");
        btnjogar.setBorderPainted(false);
        btnjogar.setContentAreaFilled(false);
        btnjogar.setFocusPainted(false);
        btnjogar.addActionListener(this::btnjogarActionPerformed);
        getContentPane().add(btnjogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 290, 100));

        btnperfil.setText(" ");
        btnperfil.setBorderPainted(false);
        btnperfil.setContentAreaFilled(false);
        btnperfil.setFocusPainted(false);
        btnperfil.addActionListener(this::btnperfilActionPerformed);
        getContentPane().add(btnperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 40));

        btnconfig.setText(" ");
        btnconfig.setBorderPainted(false);
        btnconfig.setContentAreaFilled(false);
        btnconfig.setFocusPainted(false);
        btnconfig.addActionListener(this::btnconfigActionPerformed);
        getContentPane().add(btnconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 140, 40));

        Jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login (1).png"))); // NOI18N
        Jlabel1.setText("jLabel1");
        getContentPane().add(Jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnjogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjogarActionPerformed
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnjogarActionPerformed

    private void btnperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperfilActionPerformed
        TelaPerfil tela = new TelaPerfil();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnperfilActionPerformed

    private void btnconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfigActionPerformed
        TelaConfig tela = new TelaConfig();
        tela.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnconfigActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaInicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel1;
    private javax.swing.JButton btnconfig;
    private javax.swing.JButton btnjogar;
    private javax.swing.JButton btnperfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
