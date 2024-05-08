package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Treino {

    Random gerador = new Random();
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer id;
    private LocalDate data;
    private Turno turno;
    private String idAluno;
    private List<entities.Equipamento> equipamentos;

    public Treino() {
    }

    public Treino(LocalDate data, Turno turno, String idAluno) {
        id = gerador.nextInt(10000);
        this.data = data;
        this.turno = turno;
        this.idAluno = idAluno;
        equipamentos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treino treino)) return false;
        return Objects.equals(getId(), treino.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public List<entities.Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void salvarTreino() {
        for (entities.Equipamento e : equipamentos) {
            e.setStatus(true);
        }
    }

    public void addEquipamento(entities.Equipamento e) {
        if (e.isStatus() == true) {
            System.out.println("Equipamento indisponível");
        } else {
            equipamentos.add(e);
        }
    }

    public void consultarTreino() {
        System.out.println("Data do treino: " + data.format(dtf) + "\nTurno: " + turno.name() + "\nAlunoCPF: "
                + idAluno + "\nEquipamentos: " + equipamentos);
    }

    @Override
    public String toString() {
        return id +
                "," + data +
                "," + turno +
                "," + idAluno +
                "," + equipamentos;
    }
}
