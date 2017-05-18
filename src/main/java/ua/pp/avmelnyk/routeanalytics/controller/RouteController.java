package ua.pp.avmelnyk.routeanalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.pp.avmelnyk.routeanalytics.TestPoint;
import ua.pp.avmelnyk.routeanalytics.model.Route;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RouteController {

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public ModelAndView getdata() {

        List<Route> list = new ArrayList<Route>();
        list.add(new Route("45","Метро Дарниця - Пр.П.Григоренка"));
        list.add(new Route("63","Метро Чернігівська - Метро Червоний Хутір"));
        list.add(new Route("51","Метро Червоний Хутір - Метро Либідська"));
        ModelAndView model = new ModelAndView("routes");
        model.addObject(TestPoint.getRoutes());

        return model;

    }



}
