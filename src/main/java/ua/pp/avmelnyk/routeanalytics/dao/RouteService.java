package ua.pp.avmelnyk.routeanalytics.dao;


import ua.pp.avmelnyk.routeanalytics.model.Route;

import java.util.List;

public interface RouteService {
    void addRoute(Route route);
    void updateRoute(Route route);
    List<Route> getAllRoutes();
    Route getRouteById(int id);
    void removeRoute(int id);
}
