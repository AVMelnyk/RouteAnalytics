package ua.pp.avmelnyk.routeanalytics.model;

import java.util.ArrayList;

public class Route {
    private String routeNumber;
    private String routeName;
    private ArrayList<RouteStop> routeStops;

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public ArrayList getRouteStops() {
        return routeStops;
    }

    public void setRouteStops(ArrayList routeStops) {
        this.routeStops = routeStops;
    }
}
