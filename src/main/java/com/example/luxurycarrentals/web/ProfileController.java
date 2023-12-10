package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;
import com.example.luxurycarrentals.model.dto.ProfileDetailsDTO;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;
    private final BookingService bookingService;


    public ProfileController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }


    @GetMapping("")
    public String profile(Model model, ProfileDetailsDTO profileDetailsDTO,
                          Authentication authentication) {


        ProfileDetailsDTO user = userService.getByEmail(profileDetailsDTO ,authentication.getName());
        List<BookingDetailsDTO> bookings = bookingService.findByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("bookings", bookings);

        return "profile";
    }

//    @PostMapping("/profile/edit")
//    public String confirmAddReview(@Valid ReviewAddDTO reviewAddDTO,
//                                   BindingResult bindingResult,
//                                   RedirectAttributes redirectAttributes,
//                                   Authentication authentication) {
//
//
//        if (bindingResult.hasErrors()) {
//
//            redirectAttributes
//                    .addFlashAttribute("reviewAddDTO", reviewAddDTO)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.reviewAddDTO", bindingResult);
//
//            return "redirect:profile";
//        }
//
//        // Accessing the current authenticated user's username
//        String username = authentication.getName();
//
//        return "redirect:profile";
//    }
}
