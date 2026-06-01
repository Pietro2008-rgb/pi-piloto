/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto_integrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// FIX: código morto que estava fora da classe foi removido (initComponents duplicado e GEN-BEGIN/END soltos)
public class TelaTutorial extends JFrame {

    private final JLabel titulo;
    private JTextArea textoTutorial;
    private JButton btnProximo;
    private final JButton btnFechar;

    private int etapa = 0;

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        titulo = new JLabel("Tutorial", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        textoTutorial = new JTextArea();
        textoTutorial.setEditable(false);
        textoTutorial.setFont(new Font("Arial", Font.PLAIN, 16));
        textoTutorial.setLineWrap(true);
        textoTutorial.setWrapStyleWord(true);
        textoTutorial.setText(textos[etapa]);

        JScrollPane scroll = new JScrollPane(textoTutorial);

        btnProximo = new JButton("Próximo");
        btnFechar = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnProximo);
        painelBotoes.add(btnFechar);

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

        btnFechar.addActionListener((ActionEvent e) -> dispose());

        add(titulo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaTutorial().setVisible(true));
    }
}
