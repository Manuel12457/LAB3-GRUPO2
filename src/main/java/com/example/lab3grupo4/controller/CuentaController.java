package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Mascota;
import com.example.lab3grupo4.repository.CuentaRepository;
import com.example.lab3grupo4.entity.Cuenta;
import com.example.lab3grupo4.repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/contactos")
public class CuentaController {
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MascotasRepository mascotaRepository;



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
    public String guardarContacto(Cuenta cuenta,RedirectAttributes attr){
        cuentaRepository.save(cuenta);
        attr.addFlashAttribute("msg1", "Contacto guardado exitosamente");
        return "redirect:/contactos/lista";

    }


    @GetMapping("/editar")
    public String editarForm(@RequestParam("id") int id,
                             RedirectAttributes attr, Model model) {

        Optional<Cuenta> optionalShipper = cuentaRepository.findById(id);
        if (optionalShipper.isPresent()) {
            Cuenta cuenta = optionalShipper.get();
            model.addAttribute("cuenta",cuenta);

            List<Mascota> mascotas = mascotaRepository.listarMascota(id);
            model.addAttribute("mascotas", mascotas);
            attr.addFlashAttribute("msg2", "Contacto editado exitosamente");

            return "contacto/editar";
        } else {
            return "redirect:/contactos/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrarContacto(@RequestParam("id") Integer id,RedirectAttributes attr){
        Optional<Cuenta> oCuenta = cuentaRepository.findById(id);
        if(oCuenta.isPresent()) {
            attr.addFlashAttribute("msg3", "Contacto borrado exitosamente");
            cuentaRepository.delete(oCuenta.get());
        }
        return "redirect:/contactos/lista";

    }

    @GetMapping("/borrarMascota")
    public String borrarMascota(@RequestParam("id") Integer id,RedirectAttributes attr){
        Optional<Mascota> oMascota = mascotaRepository.findById(id);
        if(oMascota.isPresent()) {
            mascotaRepository.delete(oMascota.get());
            attr.addFlashAttribute("msg4", "Mascota borrada exitosamente");
        }
        return "redirect:/contactos/lista";

    }

    @GetMapping("/verMascota")
    public String verMascota(@RequestParam("id") int id, Model model) {

            List<Mascota> mascotas = mascotaRepository.listarMascota(id);
            model.addAttribute("mascotas", mascotas);

            return "contacto/vermascotas";

    }




}
