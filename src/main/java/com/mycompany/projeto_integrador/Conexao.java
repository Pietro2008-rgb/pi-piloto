package com.mycompany.projeto_integrador;

import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:sqlite:usuarios_jogo.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "login TEXT NOT NULL UNIQUE," +
                     "senha TEXT NOT NULL)";
        
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            
            // Verifica se o banco está vazio para criar um login inicial de teste
            String check = "SELECT count(*) FROM usuarios";
            ResultSet rs = stmt.executeQuery(check);
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.execute("INSERT INTO usuarios (login, senha) VALUES ('admin@etec', '2026etec')");
                System.out.println("Usuário padrão 'admin' criado!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar SQLite: " + e.getMessage());
        }
    }
    public static void cadastrarUsuario(String login, String senha) {
    String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
    try (Connection conn = conectar(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, login);
        pstmt.setString(2, senha);
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        System.out.println("Erro ao salvar: " + e.getMessage());
    }
}
