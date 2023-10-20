// Importações necessárias para componentes gráficos e eventos do Swing
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceQuiz { // Classe principal que cria a interface gráfica para o quiz

    private Pergunta[] perguntas; // Chamando Array para armazenar as perguntas do quiz

    public InterfaceQuiz(Pergunta[] perguntas) { // Construtor da classe que recebe as perguntas como parâmetro
        this.perguntas = perguntas;
        exibirInterface(); // Chama o método para exibir a interface gráfica
    }

    private void exibirInterface() { // Método para exibir a interface gráfica
        JFrame frame = new JFrame("Quiz Interface"); // Criação da janela principal e do painel para conter os componentes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for (int i = 0; i < perguntas.length; i++) { // Loop para percorrer todas as perguntas e adicioná-las à interface
            Pergunta pergunta = perguntas[i];

            // Criação dos rótulos das perguntas e adição ao painel
            JLabel labelNumeroPergunta = new JLabel((i + 1) + "- ");
            JLabel labelPergunta = new JLabel(pergunta.getPergunta());
            panel.add(labelNumeroPergunta);
            panel.add(labelPergunta);

            // Criação dos botões de opção e adição ao painel
            ButtonGroup group = new ButtonGroup();
            for (String opcao : pergunta.getOpcoes()) {
                JRadioButton radioButton = new JRadioButton(opcao);
                group.add(radioButton);
                panel.add(radioButton);
            }

            // Criação do botão de resposta e da área de resposta, junto com um ActionListener para verificar a resposta selecionada
            JButton button = new JButton("Responder");
            JLabel labelResposta = new JLabel();

            final int finalI = i; // Use uma variável final para armazenar o valor
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (java.awt.Component component : panel.getComponents()) {
                        if (component instanceof JRadioButton) {
                            JRadioButton radioButton = (JRadioButton) component;
                            if (radioButton.isSelected()) {
                                if (radioButton.getText().charAt(0) == perguntas[finalI].getRespostaCorreta()) {
                                    labelResposta.setText((finalI + 1) +"- Resposta correta! A resposta é: " + perguntas[finalI].getRespostaCorreta());
                                } else {
                                    labelResposta.setText((finalI + 1) +"- Resposta incorreta. A resposta correta é: " + perguntas[finalI].getRespostaCorreta());
                                }
                            }
                        }
                    }
                    panel.add(labelResposta);
                    frame.revalidate();
                    frame.repaint();
                }
            });

            panel.add(button);  // Adiciona o botão de resposta ao painel
        }

        // Adiciona o painel a um JScrollPane para permitir a rolagem e exibe a janela
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    // Método main para executar o programa
    public static void main(String[] args) { // Array de perguntas e respostas para o quiz
        // Sua lista de perguntas e respostas
        Pergunta[] perguntas = {
                // Sua lista de perguntas e respostas
                new Pergunta("O que é uma estrutura de dados homogênea?",
                        new String[]{"A) Uma estrutura de dados com tipos de dados diferentes.", "B) Uma estrutura de dados com tipos de dados semelhantes.", "C) Uma estrutura de dados com apenas um tipo de dado.", "D) Uma estrutura de dados que não contém dados."}, 'B'),

                new Pergunta("Qual é a diferença entre matriz e vetor?",
                        new String[]{"A) Uma matriz é unidimensional, enquanto um vetor é bidimensional.", "B) Uma matriz é uma coleção de vetores.", "C) Um vetor é unidimensional, enquanto uma matriz é bidimensional.", "D) Matriz e vetor são termos intercambiáveis."}, 'C'),

                new Pergunta("O que a propriedade `.length` representa em arrays em Java?",
                        new String[]{"A)  O número de elementos no array.", "B) O tamanho físico do array na memória.", "C) O tamanho máximo permitido para o array.", "D) A capacidade do array para crescimento dinâmico."}, 'A'),

                new Pergunta("Pergunta: Quais são alguns métodos comuns em ArrayList (java Collections)?",
                        new String[]{"A) add(), remove(), size(), get()", "B) push(), pop(), length(), retrieve()", "C) insert(), delete(), length(), fetch()", "D) append(), discard(), count(), retrieve()"}, 'A'),

                new Pergunta("O que é garbage collection em Java?",
                        new String[]{"A) Um método para alocar memória manualmente.", "B) Um processo automático de gerenciamento de memória.", "C) Um tipo de coleção de dados em Java.", "D) Um método para liberar a memória ocupada pelo sistema operacional."}, 'B'),

                new Pergunta("Qual é o objetivo principal de um construtor em programação orientada a objetos?",
                        new String[]{"A) Definir variáveis locais", "B) Inicializar objetos.", "C) Realizar operações matemáticas.", "D) Manipular exceções."}, 'B'),

                new Pergunta("O que é um diagrama de classe?",
                        new String[]{"A) Um gráfico de barras representando classes em um programa", "B) Uma lista de métodos de classe.", "C) Uma estrutura de dados para armazenar informações sobre classes.", "D) Uma representação visual das classes em um sistema e seus relacionamentos."}, 'D'),

                new Pergunta("O que é um SSD em computação?",
                        new String[]{"A) ", "B) Uma estrutura de dados para armazenar informações sobre classes.", "C) Uma lista de métodos de classe.", "D) Uma representação visual das classes em um sistema e seus relacionamentos."}, 'D'),

                new Pergunta("Qual é o princípio de uma pilha (LIFO) em estruturas de dados?",
                        new String[]{"A) Os elementos são removidos em ordem alfabética.", "B) Os elementos são removidos aleatoriamente.", "C) O último elemento inserido é o primeiro a ser removido.", "D) O primeiro elemento inserido é o primeiro a ser removido."}, 'C'),

                new Pergunta("Quais são alguns métodos comuns usados em uma pilha?",
                        new String[]{"A) add(), remove(), size()", "B) insert(), delete(), retrieve()", "C) push(), pop(), peek()", "D) append(), discard(), count()"}, 'C'),

                new Pergunta("O que a classe Stack do Java é usada para?",
                        new String[]{"A) Representar uma pilha de elementos", "B) Realizar operações matemáticas complexas.", "C) Ordenar elementos em ordem alfabética.", "D) Gerar números aleatórios."}, 'A'),

                new Pergunta("O que é uma classe deque?",
                        new String[]{"A) Uma classe para criar diagramas de classe.", "B) Uma classe para ordenar elementos em ordem crescente", "C) Uma classe para criar matrizes bidimensionais.", "D) Uma estrutura de dados que permite a inserção e remoção de elementos em ambas as extremidades"}, 'D'),

                new Pergunta("O que é uma estrutura do tipo fila em programação?",
                        new String[]{"A) Uma estrutura de dados que armazena elementos em ordem aleatória.", "B) Uma estrutura de dados que armazena elementos em ordem alfabética.", "C) Uma estrutura de dados que segue o princípio FIFO (First-In-First-Out).", "D) Uma estrutura de dados que segue o princípio LIFO (Last-In-First-Out)."}, 'C'),

                new Pergunta("Em programação, o que é um 'for' e qual é o seu propósito principal?",
                        new String[]{"A) Um 'for' é uma estrutura de controle usada para realizar operações matemáticas complexas", "B) Um 'for' é usado para definir classes em Java.", "C) Um 'for' é uma estrutura de repetição usada para iterar sobre uma sequência de instruções um número específico de vezes.", "D) Um 'for' é uma estrutura de dados para armazenar elementos em ordem crescente."}, 'C'),

                new Pergunta("Qual é a diferença entre uma matriz e um ArrayList em Java?",
                        new String[]{"A) Uma matriz é uma estrutura de dados dinâmica, enquanto um ArrayList é uma estrutura de dados estática.", "B) Uma matriz pode armazenar diferentes tipos de objetos, enquanto um ArrayList armazena apenas objetos do mesmo tipo.", "C) Uma matriz é uma estrutura de dados unidimensional, enquanto um ArrayList é bidimensional.", "D) Uma matriz tem um tamanho fixo, enquanto um ArrayList pode crescer dinamicamente."}, 'D'),

        };
          // A classe SwingUtilities é usada para lidar com a criação da interface gráfica de forma segura em aplicativos Swing.
         // O método invokeLater() é usado para garantir que a criação da interface gráfica seja realizada de forma assíncrona no thread de despacho de eventos.
        // Uma expressão lambda é utilizada para criar uma instância da classe InterfaceQuiz e iniciar o aplicativo de quiz com as perguntas fornecidas.
        SwingUtilities.invokeLater(() -> {
            InterfaceQuiz interfaceQuiz = new InterfaceQuiz(perguntas);
        });
    }
}
