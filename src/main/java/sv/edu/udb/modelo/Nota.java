package sv.edu.udb.modelo;

import jakarta.persistence.*;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double promedio;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    /**
     * Constructor
     */
    public Nota() {
        this.estudiante = new Estudiante();
        this.materia = new Materia();
    }

    public void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3) / 3;
    }

    /**
     * GETTERS Y SETTERS
     */
    public Long getId() {
        return id;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getPromedio() {
        return promedio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
