package sv.edu.udb.servicio;

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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public List<Estudiante> searchByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Estudiante> searchByGrade(String grade) {
        return repository.findByGrade(grade);
    }

    public Estudiante getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}