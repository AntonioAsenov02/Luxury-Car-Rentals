package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.CarAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;
import com.example.luxurycarrentals.model.exceptions.ObjectNotFoundException;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ReviewService reviewService;


    public CarController(CarService carService, ReviewService reviewService) {
        this.carService = carService;
        this.reviewService = reviewService;
    }

    @ModelAttribute
    public CarAddDTO carAddDTO() {
        return new CarAddDTO();
    }

    @GetMapping("/all")
    public String allCars(Model model,
                            @PageableDefault(
                                    sort = "specifications.perDayPrice",
                                    direction = Sort.Direction.ASC,
                                    page = 0,
                                    size = 3) Pageable pageable) {

        model.addAttribute("allCars", carService.getAllCars(pageable));

        return "car";
    }


    @GetMapping("/details/{id}")
    public String getCarDetails(@PathVariable("id") Long id,
                                Model model) {

        if (carService.findCarById(id) == null) {
            throw new ObjectNotFoundException(id);
        }

        model.addAttribute("car", carService.findCarById(id));

        return "car-details";
    }

    // This endpoint is used by the JavaScript in your Thymeleaf template to fetch reviews via FetchApi
    @GetMapping("/details/api/reviews/{carId}")
    @ResponseBody
    public ResponseEntity<List<ReviewInfoDTO>> getReviewsByCarId(@PathVariable("carId") Long carId) {

        return ResponseEntity.ok(reviewService.getReviewsByCarId(carId));
    }


    @GetMapping("/add")
    public String addCar() {

        return "add-car";
    }


    @PostMapping("/add")
    public String confirmAddCar(@Valid CarAddDTO carAddDTO,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("carAddDTO", carAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.carAddDTO", bindingResult);

            return "redirect:add";
        }

        carService.addCar(carAddDTO);

        return "redirect:/";
    }

    @PostMapping("/delete/{carId}")
    public String deleteCar(@PathVariable("carId") Long carId) {

        carService.deleteCarById(carId);

        return "redirect:/cars/all";
    }


    @GetMapping("/pricing")
    private String carsPricing() {

        return "pricing";
    }

    @GetMapping("/details/api/pricing")
    @ResponseBody
    public ResponseEntity<List<CarDetailsDTO>> getCarsPricing() {

        return ResponseEntity.ok(carService.getAllCars());
    }
}
