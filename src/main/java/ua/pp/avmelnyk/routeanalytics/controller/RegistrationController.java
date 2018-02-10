package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class RegistrationController {
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String postRegistrationForm(@ModelAttribute(value = "userDto") @Valid UserDto accountDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){

            System.out.println(accountDto.toString());
        }
        return "registration";
    }

}
