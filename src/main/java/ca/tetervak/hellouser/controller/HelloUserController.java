package ca.tetervak.hellouser.controller;

import ca.tetervak.hellouser.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@Slf4j
public class HelloUserController {

    @GetMapping("/")
    public String input(Model model){
        log.trace("called input()");
        model.addAttribute("appUser", new AppUser());
        return "input";
    }


    @GetMapping("/output")
    public String output(
            @Validated @ModelAttribute AppUser appUser,
            BindingResult bindingResult,
            Model model){

        log.trace("called output()");
        log.debug("Received data: user = {}", appUser);

        model.addAttribute("appUser", appUser);

        if(bindingResult.hasErrors()){
            return "input";
        }

        return "output";
    }

}
