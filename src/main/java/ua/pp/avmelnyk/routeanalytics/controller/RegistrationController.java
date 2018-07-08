package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.validation.EmailExistsException;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

import javax.validation.Valid;

//import ua.pp.avmelnyk.routeanalytics.model.User;


@Controller
public class RegistrationController {
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String postRegistrationForm(@ModelAttribute(value = "userDto") @Valid UserDto accountDto,
                                       BindingResult bindingResult,WebRequest request, Errors errors) {
        User registered = new User();
        if (!bindingResult.hasErrors()){
            registered = createUserAccount(accountDto, bindingResult);
        }
        else
            System.out.println("There are errors");

        return "registration";
    }


    private User createUserAccount(UserDto accountDto, BindingResult result){
        User registered = null;
        try {
            //registered = service.registerNewUserAccount(accountDto);
        }catch (EmailExistsException e){
            return null;
        }
        return registered;
    }
}
