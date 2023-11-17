package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.service.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String allCars(Model model,
                            @PageableDefault(
                                    sort = "rating",
                                    direction = Sort.Direction.ASC,
                                    page = 0,
                                    size = 3) Pageable pageable) {

        model.addAttribute("allCars", carService.getAllOffers(pageable));

        return "car";
    }
}
