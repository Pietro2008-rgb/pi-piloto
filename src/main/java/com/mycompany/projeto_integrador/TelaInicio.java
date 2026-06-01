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

        btnjogar = new javax.swing.JButton();
        btnperfil = new javax.swing.JButton();
        Jlabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnjogar.setText("Jogar");
        btnjogar.addActionListener(this::btnjogarActionPerformed);
        getContentPane().add(btnjogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 290, 90));

        btnperfil.setText("Perfil");
        btnperfil.addActionListener(this::btnperfilActionPerformed);
        getContentPane().add(btnperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 40));

        Jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela_inicio (1).png"))); // NOI18N
        Jlabel1.setText("jLabel1");
        getContentPane().add(Jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1030, 610));

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
    private javax.swing.JButton btnjogar;
    private javax.swing.JButton btnperfil;
    // End of variables declaration//GEN-END:variables
}
