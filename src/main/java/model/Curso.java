package model;

public class Curso {
    private Integer id;
    private String nomeCurso;
    private int duracaoHoras;

    public Curso(Integer id, String nomeCurso, int duracaoHoras) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nomeCurso, int duracaoHoras) {
        this.nomeCurso = nomeCurso;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", duracaoHoras=" + duracaoHoras +
                '}';
    }
}
