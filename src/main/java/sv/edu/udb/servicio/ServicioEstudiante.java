package sv.edu.udb.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.repositorio.RepositorioEstudiante;

import org.springframework.stereotype.Service;

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

    public void saveStudent(Estudiante estudiante) {
        repository.save(estudiante);
    }

    public Estudiante findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        return repository.findByNameContaining(nombre);
    }

    public List<Estudiante> buscarPorGradeYSection(
            String grade,
            String section
    ) {

        return repositorioEstudiante
                .findByGradeAndSection(
                        grade,
                        section
                );
    }

    public Estudiante getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Autowired
    private RepositorioEstudiante repositorioEstudiante;
}