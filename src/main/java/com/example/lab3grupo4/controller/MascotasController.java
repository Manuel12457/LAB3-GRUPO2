package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Mascota;
import com.example.lab3grupo4.repository.MascotasRepository;
import com.example.lab3grupo4.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {
    @Autowired
    MascotasRepository mascotasRepository;
    @Autowired
    RazaRepository razaRepository;

    @GetMapping(value = "")
    public String listaMascostas(Model model){
        model.addAttribute("listaMascotas",mascotasRepository.mascotasConRaza());
        return "mascotas/lista";
    }

    @GetMapping(value = "/edit")
    public String editarMascota(@ModelAttribute("mascota") Mascota mascota, @RequestParam("id") Integer id, Model model, RedirectAttributes attributes){
        Optional<Mascota> mascotaOptional = mascotasRepository.findById(id);
        if(mascotaOptional.isPresent()){
            mascota = mascotaOptional.get();
            model.addAttribute("mascota",mascota);
            model.addAttribute("listaRazas",razaRepository.findAll());
            return "mascotas/nuevo";
        }else{
            attributes.addFlashAttribute("msg", "No existe el objeto que quieres editar");
            return "redirect:/mascotas";
        }
    }
    @GetMapping(value = "/new")
    public String nuevaMascota(@ModelAttribute("mascota") Mascota mascota,Model model){
        model.addAttribute("listaRazas",razaRepository.findAll());
        return "mascotas/nuevo";
    }
    @PostMapping(value = "/save")
    public String guardarMascota(@ModelAttribute("mascota") Mascota mascota){
        mascotasRepository.save(mascota);
        return "redirect:/mascotas";
    }
    @GetMapping(value = "/delete")
    public String borrarMascota(@RequestParam("id") Integer id){
        mascotasRepository.deleteById(id);
        return "redirect:/mascotas";
    }
}
