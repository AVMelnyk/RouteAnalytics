package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.dao.RouteServiceImpl;

import java.util.List;

@Controller
public class RouteController {

    private RouteServiceImpl routeService;

    public RouteController() {
        routeService = new RouteServiceImpl();
    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public void getdata(Model model) {
        List<Route> routeList =routeService.getAllRoutes();
        model.addAttribute(routeList);
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "register";
    }

    @RequestMapping(value = "/addroute", method = RequestMethod.GET)
    public String showAddRouteform(){
        return "addroute";
    }

    @RequestMapping(value = "/addroute", method = RequestMethod.POST)
    public String addRoute(@RequestParam("routenumber") String routeNumber, @RequestParam("routename") String routeName){

        routeService.addRoute(new Route(routeNumber, routeName));
        return "redirect:routes";
    }
}
