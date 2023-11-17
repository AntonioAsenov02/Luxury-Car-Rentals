package com.example.luxurycarrentals.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserLoginController {

    @GetMapping("/login")
    public String login() {

        return "auth-login";
    }

    @PostMapping("/login-error")
    public String onFailure(@ModelAttribute("email") String email,
                            RedirectAttributes redirectAttributes) {


            redirectAttributes.addAttribute("email", email);
            redirectAttributes.addAttribute("badCredentials", true);

        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {

        httpSession.invalidate();

        return "redirect:/";
    }
}
