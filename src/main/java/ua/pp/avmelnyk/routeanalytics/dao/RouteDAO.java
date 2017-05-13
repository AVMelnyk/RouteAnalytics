package ua.pp.avmelnyk.routeanalytics.dao;

import ua.pp.avmelnyk.routeanalytics.model.Route;
import java.util.List;

public interface RouteDAO {

    public void addRoute(Route route);
    public void updateRoute(Route route);
    public List<Route> listRoutes();
    public Route getRouteById(int id);
    public void removeRoute(int id);

}
