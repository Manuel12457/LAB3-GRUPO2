package com.example.lab3grupo4.controller;

import com.example.lab3grupo4.entity.*;
import com.example.lab3grupo4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/servicios", method = RequestMethod.GET)
public class ServiciosController {

    @Autowired
    OpcionServicioRepository opcionServicioRepository;

    @Autowired
    ResponsablesRepository responsablesRepository;

    @Autowired
    OpcionRepository opcionRepository;

    @Autowired
    ServiciosRepository serviciosRepository;

    @Autowired
    MascotasRepository mascotasRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping("")
    public String listaServicios(Model model) {

        model.addAttribute("listaOpcionServicio",opcionServicioRepository.findAll());
        return "/servicio/lista";
    }

    @GetMapping("/nuevo")
    public String newform(Model model) {

        model.addAttribute("listaOpciones", opcionRepository.findAll());
        model.addAttribute("listaResponsables", responsablesRepository.findAll());
        model.addAttribute("listaMascotas", mascotasRepository.findAll());
        model.addAttribute("listaCuentas", cuentaRepository.findAll());
        return "/servicio/new";
    }

    @GetMapping("/editar")
    public String editarForm(@RequestParam("id") Integer id, Model model, RedirectAttributes a) {
        Optional<OpcionServicio> optionalOpcionServicio = opcionServicioRepository.findById(id);
        if (optionalOpcionServicio.isPresent()) {
            OpcionServicio opcionServicio = optionalOpcionServicio.get();

            Servicio servicio = opcionServicio.getServicioIdservicio();
            Opcion opcion = opcionServicio.getOpcionIdopcion();

            model.addAttribute("servicio", servicio);
            model.addAttribute("opcion", opcion);
            model.addAttribute("listaResponsables", responsablesRepository.findAll());
            return "servicio/editForm";
        } else {
            a.addFlashAttribute("msg", -1); //Ocurrio un error al momento de querer editar
            return "redirect:/servicios";
        }
    }

    @PostMapping("/save")
    public String updateOpcionServicio(@RequestParam("precioOpcion") Double precioOpcion, @RequestParam("idOpcion") Integer idOpcion, @RequestParam("idServicio") Integer idServicio, @RequestParam("idResponsable") Integer idResponsable,RedirectAttributes a) {

        Opcion opcion = opcionRepository.findById(idOpcion).get();
        opcion.setPrecio(precioOpcion);

        Servicio servicio = serviciosRepository.findById(idServicio).get();

        List<Responsable> listaResponsables = responsablesRepository.findAll();
        for (Responsable r : listaResponsables) {
            if (r.getId() == idResponsable) {
                servicio.setResponsableIdresponsable(r);
            }
        }

        opcionRepository.save(opcion);
        serviciosRepository.save(servicio);
        a.addFlashAttribute("msg", "1");
        return "redirect:/servicios";
    }

    @PostMapping("/saveService")
    public String saveNuevoOpcionServicio(@RequestParam("opcionIdopcion") Integer opcion,
                                          @RequestParam("mascotaIdmascota") Integer mascota,
                                          @RequestParam("cuentaIdcuenta") Integer cuenta,
                                          @RequestParam("horaInicio") String horaInicio,
                                          @RequestParam("entrega") String entrega,
                                          @RequestParam("duracion") Integer duracion,
                                          @RequestParam("responsableIdresponsable") Integer responsable,
                                          RedirectAttributes a) {

        OpcionServicio opcionServicio = new OpcionServicio();
        opcionServicio.setOpcionIdopcion(opcionRepository.findById(opcion).get());

        Servicio servicio = new Servicio();
        servicio.setMascotaIdmascota(mascotasRepository.findById(mascota).get());
        servicio.setCuentaIdcuenta(cuentaRepository.findById(cuenta).get());

        String[] parts = horaInicio.split("T");
        String part1 = parts[0];
        String part2 = parts[1] + ":00";
        String b = part1 + " " + part2;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        LocalDateTime dateTime = LocalDateTime.parse(b, formatter);
        servicio.setHoraInicio(dateTime);
        servicio.setDuracion(duracion);
        servicio.setEntrega(entrega);
        servicio.setResponsableIdresponsable(responsablesRepository.findById(responsable).get());
        opcionServicio.setServicioIdservicio(servicio);

        serviciosRepository.save(servicio);
        opcionServicioRepository.save(opcionServicio);
        a.addFlashAttribute("msg", "0");
        return "redirect:/servicios";
    }


}
