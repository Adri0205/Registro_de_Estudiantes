package sv.edu.udb.servicio;

import org.springframework.stereotype.Service;
import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.repositorio.RepositorioEstudiante;

import java.util.List;

@Service
public class ServicioEstudiante {

    private final RepositorioEstudiante repository;

    public ServicioEstudiante(RepositorioEstudiante repository) {
        this.repository = repository;
    }

    public List<Estudiante> getAllStudents() {
        return repository.findAll();
    }

    public void save(Estudiante estudiante) {
        repository.save(estudiante);
    }

    public Estudiante findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        return repository.findByNameContaining(nombre);
    }

    public List<Estudiante> buscarPorGradeYSection(
            String grade,
            String section
    ) {
        return repository.findByGradeAndSection(
                grade,
                section
        );
    }

    public Estudiante getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}