package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.pp.avmelnyk.routeanalytics.dao.RouteStopService;
import ua.pp.avmelnyk.routeanalytics.dao.RouteStopServiceImpl;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.dao.RouteServiceImpl;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RouteController {

    private RouteServiceImpl routeService;
    private RouteStopServiceImpl routeStopService;

    @Autowired
    public RouteController(RouteServiceImpl routeService, RouteStopServiceImpl routeStopService) {
        this.routeService = routeService;
        this.routeStopService = routeStopService;
    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public void getData(Model model) {
        List<Route> routeList = routeService.getAllRoutes();
        model.addAttribute(routeList);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegistrationForm(Model model) {
        model.addAttribute("errorMsg", "Registration form doesn't work temporarily.\n" +
                "You can log in using:\n" +
                "Login - user;\n" +
                "Password  - userpassword;");
        return "register";
    }

    @RequestMapping(value = "/addroute", method = RequestMethod.GET)
    public String showAddRouteform(Model model){
        Route route = new Route();
        model.addAttribute("route", route);
        return "addroute";
    }

    @RequestMapping(value = "/addroute", method = RequestMethod.POST)
    public String addRoute(Model model, @ModelAttribute ("route") Route route ){
        model.addAttribute("route", route);
        routeService.addRoute(route);
        return "redirect:/route/"+route.getId();
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public  String getRoute(@PathVariable("id") int route_id, Model model) {
        Route route = routeService.getRouteById(route_id);
        List<RouteStop>routeStopList = route.getRouteStops();
        model.addAttribute(routeStopList);
        model.addAttribute(route);
        return "route";
    }

    @RequestMapping(value = "/addroutestop/{id}", method = RequestMethod.GET)
    public String addRouteWithStops(@PathVariable("id") int route_id, Model model){
        Route route = routeService.getRouteById(route_id);
        RouteStop routeStop = new RouteStop("");
        model.addAttribute(route);
        model.addAttribute(routeStop);
        return "addroutestop";
    }

    @RequestMapping(value = "/addroutestop/{id}", method = RequestMethod.POST)
    public String processingAddRouteWithStops(@PathVariable("id") int route_id, @ModelAttribute ("routeStop") RouteStop stop ){
        Route route = routeService.getRouteById(route_id);
        stop.setRoute(route);
        route.getRouteStops().add(stop);
        routeService.updateRoute(route);
        return "redirect:/route/"+route_id;
    }

    @RequestMapping(value = "/editroute", method = RequestMethod.GET)
    public String showEditRouteform(){
        return "editroute";
    }

    @RequestMapping(value = "/editroute/{id}", method = RequestMethod.GET)
    public String editRoute(@PathVariable("id") int id, Model model){
        model.addAttribute("route", routeService.getRouteById(id));
        return "editroute";
    }

    @RequestMapping(value="/editroute/{id}", method = RequestMethod.POST)
    public String editRoutePost(@PathVariable("id") int id, @RequestParam("routenumber") String routeNumber, @RequestParam("routename") String routeName){
        routeService.updateRoute(new Route(id, routeNumber,routeName));
        return "redirect:/routes";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeRoute(@PathVariable("id") int id){
        routeService.removeRoute(id);
        return "redirect:/routes";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String showcontacts() {
        return "contacts";
    }
}