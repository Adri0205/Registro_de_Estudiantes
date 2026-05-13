package sv.edu.udb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sv.edu.udb.modelo.Asistencia;
import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.servicio.ServicioAsistencia;
import sv.edu.udb.servicio.ServicioEstudiante;

import java.time.LocalDate;

@Controller
public class ControlAsistencia {

    @Autowired
    private ServicioAsistencia asistenciaService;

    @Autowired
    private ServicioEstudiante estudianteService;

    @GetMapping("/asistencia")
    public String asistencia(Model model) {

        model.addAttribute("students",
                estudianteService.getAllStudents());

        return "asistencia";
    }

    @GetMapping("/lista-asistencia")
    public String listaAsistencias(Model model) {
        model.addAttribute("asistencias", asistenciaService.listar());
        return "lista-asistencia";
    }

    @PostMapping("/guardarAsistencia")
    public String guardarAsistencia(
            @RequestParam(required = false) Long estudianteId,
            @RequestParam String estado) {

        if (estudianteId == null) {
            return "redirect:/asistencia";
        }

        Estudiante estudiante = estudianteService.getById(estudianteId);

        Asistencia asistencia = new Asistencia();

        asistencia.setEstudiante(estudiante);
        asistencia.setEstado(estado);
        asistencia.setFecha(LocalDate.now());

        asistenciaService.guardar(asistencia);

        return "redirect:/lista-asistencia";
    }

    @GetMapping("/lista-asistencia")
    public String lista(Model model) {

        model.addAttribute("asistencias",
                asistenciaService.listar());

        return "lista-asistencia";
    }

}