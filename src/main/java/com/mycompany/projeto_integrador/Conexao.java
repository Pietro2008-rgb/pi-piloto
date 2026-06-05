package com.mycompany.projeto_integrador;

import java.sql.*;

public class Conexao {
    private static final String URL =   "jdbc:mysql://localhost:3306/quimicando";  
    private static final String USER = "root";
    private static final String PASSWORD = "tinCTrom";
    public static String usuarioLogado;

    public static Connection conectar() throws SQLException {
         return DriverManager.getConnection(
            URL,
            USER,
            PASSWORD
    );
    }

    public static void inicializarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "usuario VARCHAR(50) NOT NULL UNIQUE," +
                     "email VARCHAR(100) NOT NULL UNIQUE," +
                     "senha VARCHAR(255) NOT NULL," +
                     "apelido VARCHAR(50)," +
                     "Pontos INT DEFAULT 0," +
                     "quiz_feitos INT DEFAULT 0," +
                     "sequencia_dias INT DEFAULT 0)";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            // Executa a criação da tabela se ela não existir
            stmt.execute(sql);

            // Verifica se a tabela está vazia para criar o administrador padrão
            String check = "SELECT count(*) FROM usuarios";
            ResultSet rs = stmt.executeQuery(check);
            if (rs.next() && rs.getInt(1) == 0) {
                // Ao inserir o admin, o MySQL usará o valor padrão (0) para as novas colunas numéricas
                stmt.execute("INSERT INTO usuarios (usuario, email, senha) VALUES ('admin', 'admin@etec', '2026etec')");
                System.out.println("Usuário padrão 'admin' criado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar MySQL: " + e.getMessage());
        }
    }
    public static void cadastrarUsuario(String usuario, String email, String senha) {
        // Mantemos a inserção apenas de usuario, email e senha.
        // As colunas de pontos e quiz iniciarão automaticamente em 0 devido ao DEFAULT do banco.
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
    
    public static ResultSet buscarPerguntaAleatoria(String nivelDificuldade) {
    // Seleciona uma pergunta aleatória que corresponda ao nível filtrado ('Fácil' ou 'Difícil')
    String sql = "SELECT * FROM perguntas WHERE dificuldade = ? ORDER BY RAND() LIMIT 1";
    
    try {
        // Estabelece a conexão e prepara a query
        Connection conn = conectar();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nivelDificuldade);
        
        // Retorna o resultado da busca para ser usado na tela do quiz
        return pstmt.executeQuery(); 
    } catch (SQLException e) {
        System.out.println("Erro ao filtrar pergunta no banco: " + e.getMessage());
        return null;
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
