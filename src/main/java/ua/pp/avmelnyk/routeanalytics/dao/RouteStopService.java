package ua.pp.avmelnyk.routeanalytics.dao;

import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;

public interface RouteStopService {
    void addRouteStop(RouteStop routeStop);
    void updateRouteStop(RouteStop  routeStop);
    List<RouteStop> getAllRouteStops();
    RouteStop getRouteStopById(int id);
    void removeRouteStop(int id);
}
