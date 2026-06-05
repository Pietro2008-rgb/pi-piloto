/*
xx' * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.projeto_integrador;

import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    private boolean senhaVisivel = false;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaLogin.class.getName());

    public TelaLogin() {
        initComponents();
        txtsenha.setEchoChar('*');
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnlogar = new java.awt.Button();
        btnOlho = new javax.swing.JButton();
        txtlogin = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        txtsenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnregistrar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogar.setLabel("button1");
        btnlogar.addActionListener(this::btnlogarActionPerformed);
        getContentPane().add(btnlogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 280, 50));

        btnOlho.setText("jButton1");
        btnOlho.setBorderPainted(false);
        btnOlho.setContentAreaFilled(false);
        btnOlho.setFocusPainted(false);
        btnOlho.addActionListener(this::btnOlhoActionPerformed);
        getContentPane().add(btnOlho, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 30, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        txtlogin.setViewportView(jTextArea2);

        getContentPane().add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 240, 30));

        txtsenha.setText("jPasswordField1");
        getContentPane().add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 200, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/592e7107-7100-4b61-82e7-df407124.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 1110, 700));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        btnregistrar.setLabel("button1");
        btnregistrar.addActionListener(this::btnregistrarActionPerformed);
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 280, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogarActionPerformed
        // CORREÇÃO: Buscando o texto do componente correto (jTextArea2)
        String email = jTextArea2.getText().trim();
        String senha = new String(txtsenha.getPassword());

        boolean usuarioExiste = Conexao.validarLogin(email, senha);

        if (usuarioExiste) {
            Conexao.usuarioLogado = email;
            JOptionPane.showMessageDialog(null, "Login realizado!");
            TelaInicio tela = new TelaInicio();
            tela.setVisible(true);
            dispose();
        } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Usuário não encontrado!\nFaça o cadastro.");
        TelaRegistrar tela = new TelaRegistrar();
        tela.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnlogarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        TelaRegistrar tela = new TelaRegistrar();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnOlhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlhoActionPerformed
        if (senhaVisivel) {
            txtsenha.setEchoChar('*');
            senhaVisivel = false;
        } else {
            txtsenha.setEchoChar((char) 0);
            senhaVisivel = true;
        }
    }//GEN-LAST:event_btnOlhoActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOlho;
    private java.awt.Button btnlogar;
    private java.awt.Button btnregistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JScrollPane txtlogin;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
