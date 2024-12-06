package pe.edu.i202223807.cl2_mvc_armasdiego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmCreateDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDetailDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.entity.Language;
import pe.edu.i202223807.cl2_mvc_armasdiego.repository.LanguageRepository;
import pe.edu.i202223807.cl2_mvc_armasdiego.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDTO> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDTO filmDetailDTO = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDTO);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDTO filmDetailDTO = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDTO);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDTO film, RedirectAttributes redirectAttributes) {
        maintenanceService.updateFilm(film);
        redirectAttributes.addFlashAttribute("successMessage", "La película ha sido actualizada correctamente.");
        return "redirect:/maintenance/start";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("filmCreateDTO", new FilmCreateDTO(null, "", "",
                null, null, null, null, null, null,
                "", null, new Date()));
        Iterable<Language> languagesIterable = languageRepository.findAll();
        List<Language> languages = StreamSupport.stream(languagesIterable.spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("languages", languages);
        return "maintenance-create";
    }


    @PostMapping("/create-confirm")
    public String createConfirm(@ModelAttribute FilmCreateDTO filmDTO, Model model) {
        if (maintenanceService.createFilm(filmDTO)) {
            model.addAttribute("mensaje", "La Pelicula se ha añadida exitosamente");
        } else {
            model.addAttribute("errorMensaje", "Hubo un error al intentar agregar la pelicula");
        }
        return "redirect:/maintenance/start";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        boolean eliminar = maintenanceService.deleteFilm(id);
        if (eliminar) {
            model.addAttribute("mensaje", "La pelicula se ha eliminado correctamente");
        }else{
            model.addAttribute("errorMensaje", "Hubo un error al eliminar la pelicula");
        }
        return "redirect:/maintenance/start";
    }

}
