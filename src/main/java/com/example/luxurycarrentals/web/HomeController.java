package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ChauffeurService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;
    private final ChauffeurService chauffeurService;


    public HomeController(CarService carService, ChauffeurService chauffeurService) {
        this.carService = carService;
        this.chauffeurService = chauffeurService;
    }

    @ModelAttribute
    public BookingAddDTO bookingAddDTO() {
        return new BookingAddDTO();
    }


    @GetMapping("/")
    public String home(Model model, Authentication authentication) {

        List<CarDetailsDTO> topFiveBestRated = carService.findAllByRatingDescending();
        List<CarDetailsDTO> carBrands = carService.getAllCarsOrderedByBrandAndModel();
        List<ChauffeurDetailsDTO> chauffeurs = chauffeurService.getAllChauffeursByName();

        model.addAttribute("bestRated", topFiveBestRated);
        model.addAttribute("cars", carBrands);
        model.addAttribute("chauffeurs", chauffeurs);


        if (authentication != null && authentication.isAuthenticated()) {
            return "home";
        }

        return "index";
    }
}
