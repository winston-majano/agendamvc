package com.agenda.controller;

import com.agenda.model.Contacto;
import com.agenda.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

    //TODO: creamos una instancia de nuestro repositorio
    private final ContactoRepository repository;

    //TODO: generamos su respectivo contructor con parametros
    public ContactoController(ContactoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("contactos", repository.listarContacto());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        if (contacto.getId() == 0) {
            repository.guardarContacto(contacto);
        } else {
            repository.actualizarContacto(contacto);
        }
        return "redirect:/contactos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Contacto c = repository.buscarPorId(id);
        model.addAttribute("contacto", c);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        repository.eliminarContacto(id);
        return "redirect:/contactos";
    }


}
