package ua.pp.avmelnyk.routeanalytics;

import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.dao.RouteServiceImpl;


public class TestPoint {

    public static void main(String[]  args) {
        RouteServiceImpl routeService = new RouteServiceImpl();
        Route route = new Route("211"," fdfsdfsf - fsdfsdfd");
        routeService.addRoute(route);
    }

}
