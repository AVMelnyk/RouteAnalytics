package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.avmelnyk.routeanalytics.TestPoint;

@Controller
public class RouteController {

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ModelAndView getdata() {
        ModelAndView model = new ModelAndView("routes");
        model.addObject(TestPoint.getRoutes());
        return model;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "register";
    }



}
