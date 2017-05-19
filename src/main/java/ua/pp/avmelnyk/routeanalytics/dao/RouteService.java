package ua.pp.avmelnyk.routeanalytics.dao;


import ua.pp.avmelnyk.routeanalytics.model.Route;

import java.util.List;

public interface RouteService {
    public void addRoute(Route route);
    public void updateRoute(Route route);
    public List<Route> getAllRoutes();
    public Route getRouteById(int id);
    public void removeRoute(int id);
}
