package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.ReviewAddDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.exceptions.ObjectNotFoundException;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final CarService carService;

    public ReviewController(ReviewService reviewService, CarService carService) {
        this.reviewService = reviewService;
        this.carService = carService;
    }

    @ModelAttribute
    public ReviewAddDTO reviewAddDTO() {
        return new ReviewAddDTO();
    }


    @GetMapping("/add/{carId}")
    public String addReview(@PathVariable Long carId, Model model) {
        // Load the car details based on carId and pass it to the view
        Car car = carService.getCarById(carId);

        if (car == null) {
            throw new ObjectNotFoundException(carId);
        }

        model.addAttribute("car", car);

        return "add-review";
    }


    @PostMapping("/add/{carId}")
    public String confirmAddReview(@PathVariable("carId") Long carId,
                                   @Valid ReviewAddDTO reviewAddDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Authentication authentication) {


        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("reviewAddDTO", reviewAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.reviewAddDTO", bindingResult);

            return "redirect:add";
        }

        // Accessing the current authenticated user's username
        String username = authentication.getName();

        reviewService.addReview(reviewAddDTO, carId, username);

        return "redirect:/cars/all";
    }
}
