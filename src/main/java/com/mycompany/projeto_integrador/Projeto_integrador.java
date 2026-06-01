package com.mycompany.projeto_integrador;

public class Projeto_integrador {

    public static void main(String[] args) {
        // Inicializa o banco de dados antes da tela de login aparecer
        Conexao.inicializarBanco();

        // Abre a tela de login
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
