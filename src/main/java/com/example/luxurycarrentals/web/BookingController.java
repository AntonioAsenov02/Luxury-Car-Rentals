package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import com.example.luxurycarrentals.model.exceptions.ObjectNotFoundException;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ChauffeurService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;
    private final ChauffeurService chauffeurService;


    public BookingController(BookingService bookingService, CarService carService, ChauffeurService chauffeurService) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.chauffeurService = chauffeurService;
    }

    @ModelAttribute
    private BookingAddDTO bookingAddDTO() {
        return new BookingAddDTO();
    }


    @PostMapping("/add")
    public String addBooking(@Valid BookingAddDTO bookingAddDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Authentication authentication) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("bookingAddDTO", bookingAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.bookingAddDTO", bindingResult);

            return "redirect:/";
        }

        String username = authentication.getName();

        bookingService.addBooking(bookingAddDTO, username);

        return "redirect:/";
    }


    @PostMapping("/add/car/{carId}")
    private String addBookingWithCarIdFilled(@PathVariable("carId") Long carId,
                                             BookingAddDTO bookingAddDTO,
                                             RedirectAttributes redirectAttributes) {

        Car car = carService.getCarById(carId);

        if (car == null) {
            throw new ObjectNotFoundException(carId);
        }

        bookingAddDTO.setCar(car);
        redirectAttributes.addFlashAttribute("bookingAddDTO", bookingAddDTO);

        return "redirect:/";
    }


    @PostMapping("/add/chauffeur/{chauffeurId}")
    private String addBookingWithChauffeurIdFilled(@PathVariable("chauffeurId") Long chauffeurId,
                                                   BookingAddDTO bookingAddDTO,
                                                   RedirectAttributes redirectAttributes) {


        Chauffeur chauffeur = chauffeurService.getChauffeurById(chauffeurId);

        if (chauffeur == null) {
            throw new ObjectNotFoundException(chauffeurId);
        }

        bookingAddDTO.setChauffeur(chauffeur);
        redirectAttributes.addFlashAttribute("bookingAddDTO", bookingAddDTO);

        return "redirect:/";
    }
}
