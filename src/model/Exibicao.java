// Vitor Hugo Morais Lopes da Silva - 201802380485

package model;

public class Exibicao {

    private int id;
    private Filme filme;
    private Funcionario funcionario;
    private Horario horario;
    private Funcao funcao;
    private Sala sala;

    public Exibicao() {
    }

    public Exibicao(int id, Filme filme, Funcionario funcionario, Horario horario, Funcao funcao, Sala sala) {
        this.id = id;
        this.filme = filme;
        this.funcionario = funcionario;
        this.horario = horario;
        this.funcao = funcao;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
