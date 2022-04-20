package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.repository.CuentaRepository;
import com.example.lab3grupo4.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


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
    public String nuevoContacto() {
        return "contacto/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarContacto(Cuenta cuenta){
        cuentaRepository.save(cuenta);
        return "redirect:/contactos/lista";

    }


    @GetMapping("/editar")
    public String editarForm(@RequestParam("id") int id, Model model) {
        Optional<Cuenta> optionalShipper = cuentaRepository.findById(id);
        if (optionalShipper.isPresent()) {
            Cuenta cuenta1 = optionalShipper.get();
            model.addAttribute("cuenta",cuenta1);
            return "contacto/editar";
        } else {
            return "redirect:/contactos/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrarContacto(@RequestParam("id") Integer id){
        Optional<Cuenta> oCuenta = cuentaRepository.findById(id);
        if(oCuenta.isPresent()) {
            cuentaRepository.delete(oCuenta.get());
        }
        return "redirect:/contactos/lista";

    }



}
