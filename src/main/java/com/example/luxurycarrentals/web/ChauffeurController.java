package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.service.ChauffeurService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/chauffeurs")
public class ChauffeurController {

    private final ChauffeurService chauffeurService;


    public ChauffeurController(ChauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }


    @ModelAttribute
    public ChauffeurAddDTO chauffeurAddDTO() {
        return new ChauffeurAddDTO();
    }

    @GetMapping("/all")
    public String allChauffeurs(Model model) {

        List<ChauffeurDetailsDTO> allChauffeurs = chauffeurService.findAllChauffeurs();

        model.addAttribute("allChauffeurs", allChauffeurs);

        return "chauffeur";
    }

    @GetMapping("/add")
    public String addChauffeur() {

        return "add-chauffeur";
    }


    @PostMapping("/add")
    public String confirmAddChauffeur(@Valid ChauffeurAddDTO chauffeurAddDTO,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("chauffeurAddDTO", chauffeurAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.chauffeurAddDTO", bindingResult);

            return "redirect:add";
        }

        chauffeurService.addChauffeur(chauffeurAddDTO);

        return "redirect:/";
    }


    @PostMapping("/delete/{chauffeurId}")
    public String deleteCar(@PathVariable("chauffeurId") Long chauffeurId) {

        chauffeurService.deleteChauffeurById(chauffeurId);

        return "redirect:/chauffeurs/all";
    }
}
