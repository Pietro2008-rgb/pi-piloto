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
                     "usuario TEXT NOT NULL UNIQUE," +
                     "email TEXT NOT NULL UNIQUE," +
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
   public static void cadastrarUsuario(
        String usuario,
        String email,
        String senha) {

    String sql = "INSERT INTO usuarios(usuario, email, senha) VALUES (?, ?, ?)";

    try (Connection conn = conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, usuario);
        pstmt.setString(2, email);
        pstmt.setString(3, senha);

        pstmt.executeUpdate();

    } catch (SQLException e) {

        System.out.println("Erro ao salvar: " + e.getMessage());

    }
}
    public static boolean validarLogin(String email, String senha) {

    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

    try (Connection conn = conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, email);
        pstmt.setString(2, senha);

        ResultSet rs = pstmt.executeQuery();

        return rs.next();

    } catch (SQLException e) {

        System.out.println("Erro no login: " + e.getMessage());

        return false;
    }
}
