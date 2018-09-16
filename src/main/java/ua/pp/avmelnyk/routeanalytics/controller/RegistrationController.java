package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.avmelnyk.routeanalytics.dao.UserService;
import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.validation.EmailExistsException;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    final
    UserService service;

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView postRegistrationForm(@ModelAttribute(value = "userDto") @Valid UserDto accountDto,
                                       BindingResult bindingResult,WebRequest request, Errors errors) {
        User registered = new User();
        if (!bindingResult.hasErrors()){
            registered = createUserAccount(accountDto, bindingResult);
        }
        if (registered == null) {
            bindingResult.rejectValue("email", "message.regError");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            User user = createUserAccount(accountDto,  bindingResult);
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }


    private User createUserAccount(UserDto accountDto, BindingResult result){
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }

    @RequestMapping(value = "/Acces_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model){
        model.addAttribute("user", "Username");
        return "accessDenied";
    }
}
