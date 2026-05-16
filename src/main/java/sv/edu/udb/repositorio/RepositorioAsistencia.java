package sv.edu.udb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.edu.udb.modelo.Asistencia;
import sv.edu.udb.modelo.Estudiante;

import java.time.LocalDate;
import java.util.Optional;

public interface RepositorioAsistencia
        extends JpaRepository<Asistencia, Long> {

    Optional<Asistencia> findByEstudianteAndFecha(
            Estudiante estudiante,
            LocalDate fecha
    );

    static Asistencia findByFechaAndStudent(
            LocalDate fecha,
            Estudiante student
    ) {
        return null;
    }
}