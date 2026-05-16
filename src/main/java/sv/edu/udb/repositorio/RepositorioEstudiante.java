package sv.edu.udb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.modelo.Estudiante;

import java.util.List;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByGrade(String grade);

    List<Estudiante> findBySection(String section);

    List<Estudiante> findByGradeAndSection(String grade, String section);

    List<Estudiante> findByNameContaining(String name);

}