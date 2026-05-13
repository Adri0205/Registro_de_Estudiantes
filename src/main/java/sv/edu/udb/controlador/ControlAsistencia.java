package sv.edu.udb.controlador;

import sv.edu.udb.modelo.Asistencia;
import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.servicio.ServicioAsistencia;
import sv.edu.udb.servicio.ServicioEstudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ControlAsistencia {

    @Autowired
    private ServicioAsistencia asistenciaService;

    @Autowired
    private ServicioEstudiante estudianteService;

    @GetMapping("/asistencia")
    public String mostrarFormulario(Model model) {

        model.addAttribute("students", estudianteService.getAllStudents());
        model.addAttribute("asistencia", new Asistencia());

        return "asistencia";
    }

    @PostMapping("/guardarAsistencia")
    public String guardarAsistencia(
            @RequestParam Long estudianteId,
            @RequestParam String estado
    ) {

        Estudiante estudiante = estudianteService.getById(estudianteId);

        Asistencia asistencia = new Asistencia();

        asistencia.setEstudiante(estudiante);
        asistencia.setEstado(estado);
        asistencia.setFecha(LocalDate.now());

        asistenciaService.guardar(asistencia);

        return "lista-asistencia";
    }
}