package sv.edu.udb.repositorio;

import sv.edu.udb.modelo.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByNameContaining(String name);

    List<Estudiante> findByGrade(String grade);

    List<Estudiante> findBySection(String section);

}