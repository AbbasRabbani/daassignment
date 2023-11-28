package com.firstdaproject.demo;
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.stereotype.Controller; // For marking a class as a Spring MVC controller
import org.springframework.web.bind.annotation.GetMapping; // For handling GET requests
import org.springframework.web.bind.annotation.PostMapping; // For handling POST requests
import org.springframework.web.bind.annotation.ModelAttribute; // For binding form data to an object
import org.springframework.web.bind.annotation.PathVariable; // For extracting path variables
import org.springframework.ui.Model; // For working with the Thymeleaf template engine

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User newUser) {
        userRepository.save(newUser);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}

 //"Abbas Abbas"
   //      "Matrikulation nummer: 1458950"
     //    "created: 03.11.2023"