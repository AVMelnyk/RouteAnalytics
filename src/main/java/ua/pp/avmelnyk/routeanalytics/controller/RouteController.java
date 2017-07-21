package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
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

    @RequestMapping(value = "/editroute", method = RequestMethod.GET)
    public String showEditRouteform(){
        return "editroute";
    }

    @RequestMapping(value = "/addroute", method = RequestMethod.POST)
    public String addRoute(Model model, @ModelAttribute ("route") Route route,
                                 @RequestParam("numberofstops") Integer NumberOfStops){
        List<RouteStop>stopList = new ArrayList<RouteStop>(NumberOfStops);
        for (int i = 1; i <= NumberOfStops; i++ ){
            stopList.add(new RouteStop(i, ""));
        }
        route.setRouteStops(stopList);
        model.addAttribute("stopList", stopList);
        model.addAttribute("route", route);
        System.out.println(NumberOfStops);
        routeService.addRoute(route);
        return "/route";
    }

    @RequestMapping(value = "/addroutestops", method = RequestMethod.GET)
    public String addRouteWithStops(Model model){
        return "addroutestops";
    }


    @RequestMapping(value = "/addstops", method = RequestMethod.POST)
    public String processingAddRouteWithStops( @RequestParam("route_id") int RouteID, @RequestParam("stoplistsize") int listsize, WebRequest request){
        Route route = routeService.getRouteById(RouteID);
        List<RouteStop> stopList = new ArrayList<RouteStop>();
        for (int i = 1; i <= listsize; i++ ){
            RouteStop routeStop = new RouteStop(i,request.getParameter("stopname/"+i));
            stopList.add(routeStop);
            System.out.println(request.getParameter("stopname/"+i));
        }
        for (RouteStop stop: stopList) {
            stop.setRoute(route);
            routeStopService.updateRouteStop(stop);
        }
        return "redirect:/route";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeRoute(@PathVariable("id") int id){
        routeService.removeRoute(id);
        return "redirect:/routes";
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

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String showcontacts() {
        return "contacts";
    }
}