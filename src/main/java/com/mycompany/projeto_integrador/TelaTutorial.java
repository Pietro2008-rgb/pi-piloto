/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto_integrador;
    
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaTutorial extends JFrame {

    private final JLabel titulo;
    private JTextArea textoTutorial;
    private JButton btnProximo;
    private final JButton btnFechar;

    private int etapa = 0;

    // Conteúdo do tutorial
    private String[] textos = {
        "Bem-vindo ao sistema!\n\nEste tutorial vai ensinar como usar o programa.",
        
        "Passo 1:\n\nClique no menu principal para acessar as funções.",
        
        "Passo 2:\n\nPreencha os campos corretamente antes de salvar.",
        
        "Tutorial finalizado!\n\nAgora você já pode utilizar o sistema."
    };

    public TelaTutorial() {

        setTitle("Tutorial do Sistema");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        titulo = new JLabel("Tutorial", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        // Área de texto
        textoTutorial = new JTextArea();
        textoTutorial.setEditable(false);
        textoTutorial.setFont(new Font("Arial", Font.PLAIN, 16));
        textoTutorial.setLineWrap(true);
        textoTutorial.setWrapStyleWord(true);
        textoTutorial.setText(textos[etapa]);

        JScrollPane scroll = new JScrollPane(textoTutorial);

        // Botões
        btnProximo = new JButton("Próximo");
        btnFechar = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnProximo);
        painelBotoes.add(btnFechar);

        // Eventos
        btnProximo.addActionListener((ActionEvent e) -> {
            etapa++;
            
            if (etapa < textos.length) {
                textoTutorial.setText(textos[etapa]);
            }
            
            if (etapa == textos.length - 1) {
                btnProximo.setText("Finalizar");
            }
            
            if (etapa >= textos.length) {
                dispose();
            }
        });

        btnFechar.addActionListener((ActionEvent e) -> {
            dispose();
        });

        // Adicionando componentes
        add(titulo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaTutorial().setVisible(true);
        });
    }
}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

