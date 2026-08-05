package br.com.marcosrnf.cadastroDeNinjas.Missoes;

public enum Rank {
    D("Nível fácil", 1),
    C("Nível moderado", 2),
    B("Nível Médio", 3),
    A("Nível difícil", 4),
    S("Nível Muito Díficil", 5);

    private final String descricao;
    private final int dificuldade;

    Rank(String descricao, int dificuldade) {
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDificuldade() {
        return dificuldade;
    }

}
