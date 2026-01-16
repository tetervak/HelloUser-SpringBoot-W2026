package ca.tetervak.hellouser.controller;

import ca.tetervak.hellouser.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class HelloUserController {

    @GetMapping("/")
    public String input(){
        log.trace("called input()");
        return "input";
    }


    @GetMapping("/output")
    public String output(
            @RequestParam String firstName,
            @RequestParam String lastName,
            Model model
    ){

        log.trace("called output()");
        log.debug("Received data: firstName = {}, lastName= {}", firstName, lastName);

        AppUser appUser = new AppUser(firstName, lastName);
        model.addAttribute("appUser", appUser);

        return "output";
    }

}
