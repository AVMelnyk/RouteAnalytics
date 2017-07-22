package ua.pp.avmelnyk.routeanalytics;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.routeanalytics.dao.*;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;
import ua.pp.avmelnyk.routeanalytics.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;


public class TestPoint {

    public static void main(String[]  args) {
        RouteService routeService = new RouteServiceImpl();
        Route route = routeService.getRouteById(4);
        RouteStopService routeStopService = new RouteStopServiceImpl();
        RouteStop routeStop = new RouteStop( "23dasf");
        routeStop.setRoute(route);
        routeStopService.addRouteStop(routeStop);

    }

}
