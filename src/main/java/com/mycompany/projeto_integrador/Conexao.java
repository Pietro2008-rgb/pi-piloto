package com.mycompany.projeto_integrador;

import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:sqlite:usuarios_jogo.db";

    public static String usuarioLogado;

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializarBanco() {
        // FIX 1: vírgula adicionada antes de "apelido TEXT"
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "usuario TEXT NOT NULL UNIQUE," +
                     "email TEXT NOT NULL UNIQUE," +
                     "senha TEXT NOT NULL," +
                     "apelido TEXT)";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            try {
                stmt.execute("ALTER TABLE usuarios ADD COLUMN apelido TEXT");
                System.out.println("Coluna apelido criada!");
            } catch (SQLException e) {
                // A coluna provavelmente já existe
            }

            // FIX 2: colunas corrigidas (era "login, senha", agora "usuario, email, senha")
            String check = "SELECT count(*) FROM usuarios";
            ResultSet rs = stmt.executeQuery(check);
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.execute("INSERT INTO usuarios (usuario, email, senha) VALUES ('admin', 'admin@etec', '2026etec')");
                System.out.println("Usuário padrão 'admin' criado!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar SQLite: " + e.getMessage());
        }
    }

    public static void cadastrarUsuario(String usuario, String email, String senha) {
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
    } // FIX 3: chave de fechamento de validarLogin que estava faltando

    public static void atualizarApelido(String email, String novoApelido) {
        String sql = "UPDATE usuarios SET apelido = ? WHERE email = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoApelido);
            pstmt.setString(2, email);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar apelido: " + e.getMessage());
        }
    }

    public static String buscarApelido(String email) {
        String sql = "SELECT apelido FROM usuarios WHERE email = ?";

        try (Connection conn = conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("apelido");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar apelido: " + e.getMessage());
        }

        return "";
    }
}
