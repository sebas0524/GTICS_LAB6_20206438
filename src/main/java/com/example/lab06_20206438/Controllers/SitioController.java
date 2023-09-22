package com.example.lab06_20206438.Controllers;


import com.example.lab06_20206438.Entity.Sitio;
import com.example.lab06_20206438.Repository.LocationRepository;
import com.example.lab06_20206438.Repository.SitioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
@Controller
@RequestMapping("/sitios")
public class SitioController {
    final
    LocationRepository locationRepository;
    final
    SitioRepository sitioRepository;

    public SitioController(LocationRepository locationRepository, SitioRepository sitioRepository) {
        this.locationRepository = locationRepository;
        this.sitioRepository = sitioRepository;
    }

    @GetMapping(value={"/lista",""})
    public String listaSitios(Model model){
        model.addAttribute("listaSitios",sitioRepository.findAll());
        return "sitios/lista";
    }
    @GetMapping("/nuevoSitio")
    public String nuevoSitio(Model model){
        model.addAttribute("listaSitio",locationRepository.findAll());
        model.addAttribute("listaLocation",sitioRepository.findAll());
        return "sitios/nuevoSitio";
    }
    @PostMapping("/guardar")
    public String registrarSitio(Sitio sitio, RedirectAttributes attributes){
        String estado = sitio.getSiteId() == null ? "creado" : "actualizado";
        attributes.addFlashAttribute("msg", "Sitio " + estado + " correctamente");

        sitioRepository.save(sitio);
        return "redirect:/sitios/lista";
    }
    @GetMapping("/editar")
    public String editarSitio(Model model,@RequestParam("id") int id){
        Optional<Sitio> employeeOptional=sitioRepository.findById(id);
        if(employeeOptional.isPresent()){
            Sitio sitio=employeeOptional.get();
            model.addAttribute("sitio",sitio);
            model.addAttribute("listaSitios",sitioRepository.findAll());
            model.addAttribute("listaLocaciones",locationRepository.findAll());
            return "sitios/editarSitio";
        }else{
            return "redirect:/sitio";
        }
    }


    @GetMapping("/borrar")
    public String borrarSitio(Model model,@RequestParam("id") int id,
                                 RedirectAttributes attributes){
        Optional<Sitio> employeeOptional=sitioRepository.findById(id);
        if(employeeOptional.isPresent()){
            sitioRepository.deleteById(id);
            attributes.addFlashAttribute("mensaje","Empleado borrado exitosamente");
        }
        return "redirect:/employee";

    }

}


