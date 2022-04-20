package com.example.lab3grupo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {

    @GetMapping(value = "/")
    public String listaMascostas(){
        return "index";
    }
}
