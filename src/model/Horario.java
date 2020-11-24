// Vitor Hugo Morais Lopes da Silva - 201802380485

package model;

public class Horario {

    private int id;
    private String Horario;

    public Horario() {
    }

    public Horario(int id, String Horario) {
        this.id = id;
        this.Horario = Horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    @Override
    public String toString() {
        return this.getId() + ") " + this.getHorario();
    }
}
