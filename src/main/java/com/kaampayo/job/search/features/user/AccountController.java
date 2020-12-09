package com.kaampayo.job.search.features.user;

import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class AccountController {

    private  static final Logger log = LoggerFactory.getLogger(AccountController.class);

@InitBinder
public void initBinder(WebDataBinder dataBinder){
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
}
    @GetMapping("register")
    public String register(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        return "register";
    }
    @PostMapping("/register")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
    log.info(">> userDTO : {}", userDTO.toString());
return "redirect:/login";

    }
}
