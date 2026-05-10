package sv.edu.udb.servicio;

import sv.edu.udb.modelo.Asistencia;
import sv.edu.udb.repositorio.RepositorioAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAsistencia {

    @Autowired
    private RepositorioAsistencia repository;

    public List<Asistencia> listar() {
        return repository.findAll();
    }

    public void guardar(Asistencia asistencia) {
        repository.save(asistencia);
    }
}