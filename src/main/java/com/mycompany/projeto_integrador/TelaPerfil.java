/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto_integrador;

import javax.swing.JOptionPane; // FIX: import que estava faltando

public class TelaPerfil extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPerfil.class.getName());

    public TelaPerfil() {
        initComponents();
        setLocationRelativeTo(null);

        // Carrega o apelido salvo do usuário logado ao abrir a tela
        String apelido = Conexao.buscarApelido(Conexao.usuarioLogado);
        if (apelido != null && !apelido.isEmpty()) {
            lblNomeUsuario.setText(apelido);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnvoltar = new javax.swing.JButton();
        lblNomeUsuario = new javax.swing.JLabel();
        ranking_numero = new javax.swing.JLabel();
        sequencia_label = new javax.swing.JLabel();
        quiz_feitos = new javax.swing.JLabel();
        pontos = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEditarNome = new javax.swing.JButton();
        BarraDeProgresso = new javax.swing.JProgressBar();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvoltar.setText("jButton1");
        btnvoltar.addActionListener(this::btnvoltarActionPerformed);
        getContentPane().add(btnvoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 40));

        lblNomeUsuario.setBackground(new java.awt.Color(0, 0, 0));
        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNomeUsuario.setText("Quimicando123");
        getContentPane().add(lblNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 160, 40));

        ranking_numero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ranking_numero.setText(" 0");
        getContentPane().add(ranking_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 80, 30));

        sequencia_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sequencia_label.setText("0");
        getContentPane().add(sequencia_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 30));

        quiz_feitos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quiz_feitos.setText("       0");
        getContentPane().add(quiz_feitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 80, 30));

        pontos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pontos.setText("       0");
        getContentPane().add(pontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 80, 30));

        nivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nivel.setText("0");
        getContentPane().add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 10, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de tela 2026-06-01 095439.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/0b92493b-ed34-4044-bebb-8546ae12.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1017, 619));

        btnEditarNome.setText(" ");
        btnEditarNome.addActionListener(this::btnEditarNomeActionPerformed);
        getContentPane().add(btnEditarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 30, 30));
        getContentPane().add(BarraDeProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 220, 320, 10));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("0");
        getContentPane().add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarActionPerformed
        TelaInicio inicio = new TelaInicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvoltarActionPerformed

    private void btnEditarNomeActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String novoNome = JOptionPane.showInputDialog(
            this,
            "Digite seu novo apelido:"
        );

        if (novoNome != null && !novoNome.trim().isEmpty()) {
            lblNomeUsuario.setText(novoNome);

            // FIX: era "emailUsuarioLogado" (variável inexistente), corrigido para Conexao.usuarioLogado
            Conexao.atualizarApelido(Conexao.usuarioLogado, novoNome);

            JOptionPane.showMessageDialog(
                this,
                "Apelido alterado com sucesso!"
            );
        }
    }                                                                           

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

        java.awt.EventQueue.invokeLater(() -> new TelaPerfil().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraDeProgresso;
    private javax.swing.JButton btnEditarNome;
    private javax.swing.JButton btnvoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel pontos;
    private javax.swing.JLabel quiz_feitos;
    private javax.swing.JLabel ranking_numero;
    private javax.swing.JLabel sequencia_label;
    // End of variables declaration//GEN-END:variables
}
