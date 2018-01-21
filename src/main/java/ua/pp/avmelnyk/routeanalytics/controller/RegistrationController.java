package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String postRegistrationForm(@ModelAttribute("userDto") @Valid UserDto accountDto) {
        System.out.println(accountDto.toString());
        return "registration";
    }

}
