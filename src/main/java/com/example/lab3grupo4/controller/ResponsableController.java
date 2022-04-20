package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Responsable;
import com.example.lab3grupo4.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/responsables")
public class ResponsableController {

    @Autowired
    ResponsableRepository responsableRepository;

    @GetMapping(value = "/listar")
    public String listaResponsables(Model model){
        List<Responsable> responsableList = responsableRepository.findAll();

        model.addAttribute("responsableList", responsableList);
        return "responsables/lista";
    }

    @GetMapping("/newform")
    public String nuevoResponsable(Model model) {
        return "responsables/newform";
    }

    @PostMapping("/save")
    public String saveResponsable(RedirectAttributes a, Responsable responsable) {
        responsableRepository.save(responsable);
        return "redirect:/responsables/listar";
    }

}