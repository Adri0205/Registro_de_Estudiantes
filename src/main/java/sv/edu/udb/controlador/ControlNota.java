package sv.edu.udb.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.modelo.Materia;
import sv.edu.udb.modelo.Nota;
import sv.edu.udb.servicio.ServicioEstudiante;
import sv.edu.udb.servicio.ServicioMateria;
import sv.edu.udb.servicio.ServicioNota;

@Controller
public class ControlNota {
    private final ServicioNota notaService;
    private final ServicioEstudiante estudianteService;
    private final ServicioMateria materiaService;

    public ControlNota(ServicioNota notaService, ServicioEstudiante estudianteService, ServicioMateria materiaService) {
        this.notaService = notaService;
        this.estudianteService = estudianteService;
        this.materiaService = materiaService;
    }

    /**
     * Mostramos el formulario de notas
     */
    @GetMapping("/notas")
    public String index(Model model) {
        model.addAttribute("notas", notaService.obtenerNota());
        model.addAttribute("nota", new Nota());

        model.addAttribute("students", estudianteService.getAllStudents());
        model.addAttribute("materias", materiaService.obtenerMaterias());

        return "notas";
    }

    /**
     * Accion para guardar las notas en sistema
     */
    @PostMapping("/notas/save")
    public String guardarNotas(
            @ModelAttribute Nota nota,
            @RequestParam("estudianteId") Long estudianteId,
            @RequestParam("materiaId") Long materiaId) {

        /**
         * Buscamos las entidades reales por ID
         */
        Estudiante estudiante = estudianteService.findById(estudianteId);
        Materia materia = materiaService.findById(materiaId);

        nota.setEstudiante(estudiante);
        nota.setMateria(materia);

        notaService.guardarNota(nota);
        return "redirect:/notas";
    }
}
