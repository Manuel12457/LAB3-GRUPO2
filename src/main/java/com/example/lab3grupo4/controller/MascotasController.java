package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Mascota;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {

    @GetMapping(value = "/")
    public String listaMascostas(){
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
}
