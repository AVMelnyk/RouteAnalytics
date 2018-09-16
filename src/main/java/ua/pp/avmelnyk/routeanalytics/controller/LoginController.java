package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.avmelnyk.routeanalytics.dao.UserService;
import ua.pp.avmelnyk.routeanalytics.model.User;

@Controller
public class LoginController {

    @Autowired
    UserService service;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginPage(Model model){

        return "login";
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testPage(Model model){
        //User user = service.findByEmail("avmelnyk@gmail.com");

        User user =service.save(new User("username", "password", "fistname", "lastname","emali@gmail.com"));
        System.out.println(user.toString());
        return "login";
    }

}
