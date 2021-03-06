package com.example.germes.controller;

import com.example.germes.entity.User;
import com.example.germes.entity.dto.UserDto;
import com.example.germes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm() {
        User user = new User();
        ModelAndView mav = new ModelAndView("auth/registration");
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        UserDto user = new UserDto();
        ModelAndView mav = new ModelAndView("auth/login");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/registration")
    public ModelAndView processLogForm(@ModelAttribute("user") UserDto userDto){
        System.out.println(userDto);
        User existingUser = userService.findUserByUsername(userDto.getUsername());
        if(existingUser != null){
            ModelAndView mav = new ModelAndView("auth/registration");
            mav.addObject("existingUsername", userDto.getUsername());
            return mav;
        } else {
            System.out.println(userService.save(userDto));
            ModelAndView mav = new ModelAndView("auth/login");
            return mav;
        }
    }

}
