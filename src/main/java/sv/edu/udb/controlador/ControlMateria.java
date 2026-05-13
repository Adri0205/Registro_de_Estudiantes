package sv.edu.udb.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sv.edu.udb.modelo.Materia;
import sv.edu.udb.servicio.ServicioMateria;

@Controller
public class ControlMateria {

    private final ServicioMateria service;

    public ControlMateria(ServicioMateria service) {
        this.service = service;
    }

    /**
     * Mostramos la vista de las materias
     */
    @GetMapping("/materias")
    public String index(Model model) {
        model.addAttribute("materias", service.obtenerMaterias());
        model.addAttribute("materia", new Materia());

        return "materias";
    }

    /**
     * Guardamos las materias
     */
    @PostMapping("/materias/save")
    public String guardarMateria(@ModelAttribute Materia materia) {
        service.guardarMateria(materia);

        return "redirect:/materias";
    }
}
