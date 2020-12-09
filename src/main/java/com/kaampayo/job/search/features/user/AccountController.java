package com.kaampayo.job.search.features.user;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class AccountController {

    private  static final Logger log = LoggerFactory.getLogger(AccountController.class);


    @GetMapping("register")
    public String register(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        return "register";
    }
    @PostMapping("/register")
    public void save(UserDTO userDTO){
        log.info(">> userDTO : {}", userDTO.toString());


    }
}
