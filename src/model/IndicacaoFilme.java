// Vitor Hugo Morais Lopes da Silva - 201802380485

package model;

public class IndicacaoFilme {

    private Filme filme;
    private Indicacao indicacao;

    public IndicacaoFilme() {
    }

    public IndicacaoFilme(Filme filme, Indicacao indicacao) {
        this.filme = filme;
        this.indicacao = indicacao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Indicacao getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(Indicacao indicacao) {
        this.indicacao = indicacao;
    }
}
