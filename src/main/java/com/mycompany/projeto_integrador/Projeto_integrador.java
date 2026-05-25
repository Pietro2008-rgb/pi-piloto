/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_integrador;

public class Projeto_integrador {

    public static void main(String[] args) {
    // .db e tabela antes da tela de login aparecer
    Conexao.inicializarBanco(); 
    
    // tela de login
    java.awt.EventQueue.invokeLater(() -> {
        new TelaLogin().setVisible(true);
    });
   }
}
