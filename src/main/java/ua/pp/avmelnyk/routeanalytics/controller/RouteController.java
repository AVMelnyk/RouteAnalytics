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
    public String addRoute(@ModelAttribute("route")Route route ){
        routeService.addRoute(route);
        return "redirect:/route/"+route.getId();
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public  String getRoute(@PathVariable("id")int route_id, Model model) {
        Route route = routeService.getRouteById(route_id);
        System.out.println(route);
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
        if (route.getRouteStops()!= null){
            route.getRouteStops().add(stop);
        }
        else {
            List<RouteStop> routeStopList = new ArrayList<RouteStop>();
            routeStopList.add(stop);
            route.setRouteStops(routeStopList);
        }
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
        Route route = routeService.getRouteById(id);
        Route updatedRoute = new Route(id, routeNumber,routeName);
        List<RouteStop> updatedStopList = new ArrayList<RouteStop>();
        for (RouteStop stop: route.getRouteStops()) {
            stop.setRoute(updatedRoute);
            updatedStopList.add(stop);
        }
        updatedRoute.setRouteStops(updatedStopList);
        routeService.updateRoute(updatedRoute);
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

    @RequestMapping(value = "/remove/route/{route_id}/route_stop/{stop_id}")
    public String removeRouteStop(@PathVariable("route_id") int route_id, @PathVariable("stop_id") int stop_id ){
        Route route = routeService.getRouteById(route_id);
        List<RouteStop> stopList = route.getRouteStops();
        List<RouteStop> newStopList = new ArrayList<RouteStop>();
        for (RouteStop stop: stopList) {
            if (stop_id != stop.getRouteStopId()){
                newStopList.add(stop);
            }
        }
        System.out.println(newStopList.toString());
        route.setRouteStops(newStopList);
        routeService.updateRoute(route);
        return "redirect:/route/" + route_id;
    }
}