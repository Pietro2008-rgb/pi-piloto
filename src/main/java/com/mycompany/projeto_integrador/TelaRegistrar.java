/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto_integrador;

import javax.swing.JOptionPane;

public class TelaRegistrar extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaRegistrar.class.getName());

    public TelaRegistrar() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtemail = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        btnvoltarparalogin = new java.awt.Button();
        btncriarconta = new java.awt.Button();
        txtsenha = new javax.swing.JTextField();
        txtconfirmarsenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtemail.setText("");
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 260, -1));

        txtusuario.setText("");
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 260, -1));

        btnvoltarparalogin.setLabel("Voltar para Login");
        btnvoltarparalogin.addActionListener(this::btnvoltarparaloginActionPerformed);
        getContentPane().add(btnvoltarparalogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 300, 40));

        btncriarconta.setLabel("Criar Conta");
        btncriarconta.addActionListener(this::btncriarcontaActionPerformed);
        getContentPane().add(btncriarconta, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 320, 50));

        txtsenha.setText("");
        getContentPane().add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 450, 240, -1));

        txtconfirmarsenha.setText("");
        txtconfirmarsenha.addActionListener(this::txtconfirmarsenhaActionPerformed);
        getContentPane().add(txtconfirmarsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 240, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registre.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 1056, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtconfirmarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmarsenhaActionPerformed
        // não utilizado
    }//GEN-LAST:event_txtconfirmarsenhaActionPerformed

    private void btncriarcontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriarcontaActionPerformed
        String usuario = txtusuario.getText().trim();
        String email = txtemail.getText().trim();
        String senha = txtsenha.getText();
        String confirmar = txtconfirmarsenha.getText();

        if (usuario.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        if (senha.equals(confirmar)) {
            Conexao.cadastrarUsuario(usuario, email, senha);
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
            TelaLogin tela = new TelaLogin();
            tela.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
        }
    }//GEN-LAST:event_btncriarcontaActionPerformed

    private void btnvoltarparaloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarparaloginActionPerformed
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnvoltarparaloginActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new TelaRegistrar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btncriarconta;
    private java.awt.Button btnvoltarparalogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtconfirmarsenha;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
