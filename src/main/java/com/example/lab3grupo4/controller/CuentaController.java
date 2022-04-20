package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.repository.CuentaRepository;
import com.example.lab3grupo4.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/contactos")
public class CuentaController {
    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = {"/lista"})
    public String listaContactos(Model model){
        model.addAttribute("listacontactos", cuentaRepository.findAll());
        return "contacto/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoContacto(@ModelAttribute("contactos") Cuenta cuenta, Model model) {

        return "contacto/formulario";
    }




}
