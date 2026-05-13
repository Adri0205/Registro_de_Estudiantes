package sv.edu.udb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.edu.udb.modelo.Nota;

public interface RepositorioNota extends JpaRepository<Nota, Long> {
    
}
