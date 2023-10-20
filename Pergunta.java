// Classe para representar cada pergunta do quiz
class Pergunta {

    // Declaração de variáveis privadas para armazenar a pergunta, opções e resposta correta
    private String pergunta;
    private String[] opcoes;
    private char respostaCorreta;

    // Construtor para inicializar a pergunta, opções e resposta correta
    public Pergunta(String pergunta, String[] opcoes, char respostaCorreta) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    // Método para obter a pergunta
    public String getPergunta() {
        return pergunta;
    }

    // Método para obter as opções de resposta
    public String[] getOpcoes() {
        return opcoes;
    }

    // Método para obter a resposta correta
    public char getRespostaCorreta() {
        return respostaCorreta;
    }
}