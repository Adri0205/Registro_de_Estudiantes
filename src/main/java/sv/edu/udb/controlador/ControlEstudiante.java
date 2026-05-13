package sv.edu.udb.controlador;

import sv.edu.udb.modelo.Estudiante;
import sv.edu.udb.servicio.ServicioEstudiante;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControlEstudiante {

    private final ServicioEstudiante service;

    public ControlEstudiante(ServicioEstudiante service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Estudiante());
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new Estudiante());
        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Estudiante estudiante) {
        service.saveStudent(estudiante);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }

}