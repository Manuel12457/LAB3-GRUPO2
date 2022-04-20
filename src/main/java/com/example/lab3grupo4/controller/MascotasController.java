package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.Mascota;
import com.example.lab3grupo4.entity.OpcionServicio;
import com.example.lab3grupo4.entity.Servicio;
import com.example.lab3grupo4.repository.*;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.DateFormatter;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {

    @Autowired
    OpcionRepository opcionRepository;
    @Autowired
    OpcionServicioRepository opcionServicioRepository;
    @Autowired
    MascotasRepository mascotasRepository;
    @Autowired
    RazaRepository razaRepository;
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    ServiciosRepository serviciosRepository;
    @Autowired
    ResponsableRepository responsableRepository;

    @GetMapping(value = "")
    public String listaMascostas(Model model){
        model.addAttribute("listaMascotas",mascotasRepository.mascotasConRaza());
        return "mascotas/lista";
    }

    @GetMapping(value = {"/search"})
    public String listaMascotas(Model model, @RequestParam("search") String search){
        model.addAttribute("search", search);
        System.out.println("search: "+search);
        model.addAttribute("listaMascotas", mascotasRepository.listarMascotasSearch(search.toLowerCase()));
        System.out.println("size: "+ mascotasRepository.listarMascotasSearch(search.toLowerCase()).size());
        return "mascotas/lista";
    }

    @GetMapping(value = "/edit")
    public String editarMascota(@RequestParam("id") Integer id, Model model, RedirectAttributes attributes){
        Optional<Mascota> mascotaOptional = mascotasRepository.findById(id);
        if(mascotaOptional.isPresent()){
            model.addAttribute("mascota",mascotaOptional.get());
            model.addAttribute("listaRazas",razaRepository.findAll());
            return "mascotas/edit";
        }else{
            attributes.addFlashAttribute("msg", "No existe el objeto que quieres editar");
            return "redirect:/mascotas";
        }
    }
    @GetMapping(value = "/new")
    public String nuevaMascota(Model model){
        model.addAttribute("listaRazas",razaRepository.findAll());
        return "mascotas/nuevo";
    }
    @PostMapping(value = "/save")
    public String guardarMascota(Mascota mascota){
        mascotasRepository.save(mascota);
        return "redirect:/mascotas";
    }
    @GetMapping(value = "/delete")
    public String borrarMascota(@RequestParam("id") Integer id){
        mascotasRepository.deleteById(id);
        return "redirect:/mascotas";
    }
    @GetMapping(value = "/newService")
    public String nuevoservicioMascota(@RequestParam("id") Integer id,Model model){
        Optional<Mascota> mascota = mascotasRepository.findById(id);
        if(mascota.isPresent()){
            model.addAttribute("listaCuentas",cuentaRepository.findAll());
            model.addAttribute("listaResponsables",responsableRepository.findAll());
            model.addAttribute("opcion",opcionRepository.findAll());
            model.addAttribute("mascota",mascota.get());
        }else{
            model.addAttribute("msg","No se puede agregar un servicio a una mascota inexistente");
        }
        return "mascotas/nuevoServicio";
    }

    @PostMapping(value = "/newService/save")
    public String guardarnuevoservicioMascota(Servicio servicio, @RequestParam("horaInicioStr") String horaInicio,@RequestParam("opcion") Integer idopcion) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = dtf.format(LocalDate.now()) +" "+ horaInicio + ":00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
        servicio.setHoraInicio(dateTime);
        OpcionServicio opcionServicio = new OpcionServicio();
        serviciosRepository.save(servicio);
        System.out.println("id= " + servicio.getId());
        opcionServicio.setOpcionIdopcion(opcionRepository.getById(idopcion));
        opcionServicio.setServicioIdservicio(servicio);
        opcionServicioRepository.save(opcionServicio);

        return "redirect:/mascotas/info?id=" + servicio.getMascotaIdmascota().getIdmascota();
    }

    @GetMapping(value = "/info")
    public String listaServiciosxMascotas(@RequestParam("id") int mascid, Model model){
        model.addAttribute("listaServiciosxMascota", serviciosRepository.listaServiciosxMascota(mascid));
        return "mascotas/servicios";
    }

    @PostMapping("/search")
    public String buscar (@RequestParam("name") String name, Model model){
        List<Mascota> mascotaOpt = mascotasRepository.listarMascotasxNombre(name);
        model.addAttribute("listaMascotas",mascotaOpt);
        return "mascotas/lista";
    }

}
