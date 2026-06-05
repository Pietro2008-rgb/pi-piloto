package com.mycompany.projeto_integrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class TelaQuiz extends javax.swing.JFrame {

    // Classe interna auxiliar para organizar as perguntas na memória
    class Pergunta {
        String enunciado, a, b, c, d, correta;
        Pergunta(String enun, String a, String b, String c, String d, String corr) {
            this.enunciado = enun; 
            this.a = a; 
            this.b = b; 
            this.c = c; 
            this.d = d; 
            this.correta = corr;
        }
    }

    // Variáveis globais do jogo unificadas
    private List<Pergunta> listaPerguntas = new ArrayList<>();
    private int indiceAtual = 0;
    private int acertos = 0;
    private int erros = 0; 
    private String dificuldadeEscolhida;
    private circular graficoProgresso; // Seu gráfico circular customizado

    // CONSTRUTOR PRINCIPAL: Recebe a dificuldade escolhida pelo usuário
    public TelaQuiz(String dificuldade) {
        initComponents();
        this.dificuldadeEscolhida = dificuldade;
        
        // Inicializa e posiciona o gráfico circular por cima do layout absoluto
        graficoProgresso = new circular();
        graficoProgresso.setBounds(730, 150, 180, 180); 
        this.add(graficoProgresso);
        this.setComponentZOrder(graficoProgresso, 0); // Mantém o gráfico à frente da imagem de fundo
        graficoProgresso.setProgress(0);

        // Define os textos dos placares com 0 no início do jogo
        lblProgressoTexto.setText("0");
        lblAcertos.setText("0");
        lblErros.setText("0");

        // Carrega o banco e inicia o fluxo de exibição
        carregarPerguntasDoBanco();
        exibirPergunta();
    }

    // Construtor padrão vazio (exigido pelo editor do NetBeans)
    public TelaQuiz() {
        initComponents();
    }
    
    // Método responsável por atualizar a interface gráfica com os dados da pergunta
    private void exibirPergunta() {
        // Verifica se ainda existem perguntas não respondidas na lista
        if (indiceAtual < listaPerguntas.size()) {
            Pergunta p = listaPerguntas.get(indiceAtual);
            
            // Injeta as informações vindas do MySQL nos componentes da tela
            lblEnunciado.setText("<html><body style='width: 450px;'>" + p.enunciado + "</body></html>");
            rbAlternativaA.setText(p.a);
            rbAlternativaB.setText(p.b);
            rbAlternativaC.setText(p.c);
            rbAlternativaD.setText(p.d);
            
            // Desmarca qualquer alternativa que tenha ficado selecionada da questão anterior
            buttonGroup1.clearSelection();
            
            // Atualiza o círculo principal com o número exato da questão (Começa em 0)
            lblProgressoTexto.setText(String.valueOf(indiceAtual)); 
            
            // Mantém a atualização em background do componente circular gráfico
            int progressoPorcentagem = indiceAtual * 10;
            graficoProgresso.setProgress(progressoPorcentagem);
            
        } else {
            // Quando chega ao fim da lista, crava o número 10 e fecha o jogo
            lblProgressoTexto.setText("10"); 
            graficoProgresso.setProgress(100);
            
            JOptionPane.showMessageDialog(this, "Quiz Concluído! Você acertou " + acertos + " de " + listaPerguntas.size());
            
            // Redireciona o usuário para a Tela Final carregando os dados obtidos
            TelaFinalQuiz telaFinal = new TelaFinalQuiz();
            telaFinal.setVisible(true);
            this.dispose();
        }
    }
    
    // Método de conexão e captura de dados do MySQL
    private void carregarPerguntasDoBanco() {
        String url = "jdbc:mysql://localhost:3306/quimicando";
        String usuario = "root";
        String senha = "tinCTrom";
        String sql = "SELECT * FROM tb_perguntas WHERE dificuldade = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dificuldadeEscolhida);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listaPerguntas.add(new Pergunta(
                    rs.getString("enunciado"),
                    rs.getString("alternativa_a"),
                    rs.getString("alternativa_b"),
                    rs.getString("alternativa_c"),
                    rs.getString("alternativa_d"),
                    rs.getString("correta")
                ));
            }

            if (listaPerguntas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma pergunta encontrada para esta dificuldade.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + e.getMessage());
        }
    } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnProxima = new javax.swing.JButton();
        lblEnunciado = new javax.swing.JLabel();
        rbAlternativaA = new javax.swing.JRadioButton();
        rbAlternativaB = new javax.swing.JRadioButton();
        rbAlternativaC = new javax.swing.JRadioButton();
        rbAlternativaD = new javax.swing.JRadioButton();
        lblProgressoTexto = new javax.swing.JLabel();
        lblAcertos = new javax.swing.JLabel();
        lblErros = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProxima.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        btnProxima.setForeground(new java.awt.Color(255, 255, 255));
        btnProxima.setText("Próxima");
        btnProxima.setToolTipText("");
        btnProxima.setBorderPainted(false);
        btnProxima.setContentAreaFilled(false);
        btnProxima.setFocusPainted(false);
        btnProxima.addActionListener(this::btnProximaActionPerformed);
        getContentPane().add(btnProxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 180, 60));

        lblEnunciado.setFont(new java.awt.Font("Stylus BT", 0, 12)); // NOI18N
        lblEnunciado.setText("jLabel2");
        getContentPane().add(lblEnunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 450, 50));

        buttonGroup1.add(rbAlternativaA);
        rbAlternativaA.setText("jRadioButton1");
        getContentPane().add(rbAlternativaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 291, 400, 60));

        buttonGroup1.add(rbAlternativaB);
        rbAlternativaB.setText("jRadioButton1");
        getContentPane().add(rbAlternativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 361, 410, 50));

        buttonGroup1.add(rbAlternativaC);
        rbAlternativaC.setText("jRadioButton1");
        getContentPane().add(rbAlternativaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 431, 400, 50));

        buttonGroup1.add(rbAlternativaD);
        rbAlternativaD.setText("jRadioButton1");
        getContentPane().add(rbAlternativaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 501, 400, 50));

        lblProgressoTexto.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblProgressoTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgressoTexto.setText("0");
        lblProgressoTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblProgressoTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 100, 100));

        lblAcertos.setFont(new java.awt.Font("SWIsop1", 0, 36)); // NOI18N
        lblAcertos.setForeground(new java.awt.Color(0, 153, 0));
        lblAcertos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcertos.setText("0");
        getContentPane().add(lblAcertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 70, 60));

        lblErros.setFont(new java.awt.Font("SWIsop1", 0, 36)); // NOI18N
        lblErros.setForeground(new java.awt.Color(153, 0, 51));
        lblErros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErros.setText("0");
        getContentPane().add(lblErros, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 50, 60));

        lblTexto.setFont(new java.awt.Font("SWIsop1", 0, 18)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(51, 153, 0));
        lblTexto.setText("Acertos");
        getContentPane().add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 70, 20));

        jLabel5.setFont(new java.awt.Font("SWIsop1", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("Erros");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, 60, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de tela 2026-06-01 095439.png"))); // NOI18N
        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de tela 2026-06-01 095439.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, 50, 50));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ultimo_quiz.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1600, 900));
        jLabel1.setMinimumSize(new java.awt.Dimension(1600, 900));
        jLabel1.setPreferredSize(new java.awt.Dimension(1600, 900));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, -30, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaActionPerformed
        // 1. Obriga o usuário a escolher uma alternativa antes de avançar
        if (buttonGroup1.getSelection() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione uma alternativa antes de continuar!");
            return;
        }

        // 2. Captura a letra correspondente à opção que o usuário marcou
        String opcaoEscolhida = "";
        if (rbAlternativaA.isSelected()) {
            opcaoEscolhida = "A";
        } else if (rbAlternativaB.isSelected()) {
            opcaoEscolhida = "B";
        } else if (rbAlternativaC.isSelected()) {
            opcaoEscolhida = "C";
        } else if (rbAlternativaD.isSelected()) {
            opcaoEscolhida = "D";
        }

        // 3. Pega a pergunta atual da lista usando as suas variáveis
        Pergunta p = listaPerguntas.get(indiceAtual);

        // 4. SISTEMA DE PLACAR: Compara a escolha com a resposta correta
        if (opcaoEscolhida.equalsIgnoreCase(p.correta)) {
            acertos++; // Soma nos seus acertos
            lblAcertos.setText(String.valueOf(acertos)); // Atualiza o placar VERDE
        } else {
            erros++; // Soma nos seus erros
            lblErros.setText(String.valueOf(erros)); // Atualiza o placar VERMELHO
        }

        // 5. Avança para a próxima pergunta e recarrega a tela
        indiceAtual++;
        exibirPergunta();
    }      // TODO add your handling code here:
    }//GEN-LAST:event_btnProximaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProxima;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAcertos;
    private javax.swing.JLabel lblEnunciado;
    private javax.swing.JLabel lblErros;
    private javax.swing.JLabel lblProgressoTexto;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JRadioButton rbAlternativaA;
    private javax.swing.JRadioButton rbAlternativaB;
    private javax.swing.JRadioButton rbAlternativaC;
    private javax.swing.JRadioButton rbAlternativaD;
    // End of variables declaration//GEN-END:variables

