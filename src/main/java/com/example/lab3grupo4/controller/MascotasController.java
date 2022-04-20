package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Mascota;
import com.example.lab3grupo4.entity.Servicio;
import com.example.lab3grupo4.repository.MascotasRepository;
import com.example.lab3grupo4.repository.ServiciosRepository;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {
    @Autowired
    MascotasRepository mascotasRepository;

    @Autowired
    ServiciosRepository serviciosRepository;

    @GetMapping(value = "")
    public String listaMascostas(Model model){
        model.addAttribute("listaMascotas",mascotasRepository.findAll());
        return "mascotas/lista";
    }

    @GetMapping(value = "/edit")
    public String editarMascota(@ModelAttribute("mascota") Mascota mascota,@RequestParam("id") Integer id){
        return "mascotas/editar";
    }
    @GetMapping(value = "/new")
    public String nuevaMascota(@ModelAttribute("mascota") Mascota mascota){
        return "mascotas/nuevo";
    }
    @GetMapping(value = "/save")
    public String guardarMascota(@ModelAttribute("mascota") Mascota mascota){
        return "redirect:/mascotas";
    }
    @GetMapping(value = "/delete")
    public String borrarMascota(@RequestParam("id") Integer id){
        return "mascotas/nuevo";
    }

    @GetMapping(value = "/servicios")
    public String listaServiciosxMascotas(@ModelAttribute("servicio")Servicio servicio,
                                          @RequestParam("id") int mascid, Model model, RedirectAttributes attr){
        model.addAttribute("listaServiciosxMascota", serviciosRepository.listaServiciosxMascota(mascid));
        return "mascotas/lista";
    }


}
