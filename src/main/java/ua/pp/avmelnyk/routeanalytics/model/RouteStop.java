package ua.pp.avmelnyk.routeanalytics.model;


public class RouteStop {

    private String routeStopName;

    public RouteStop(String routeStopName) {
        this.routeStopName = routeStopName;
    }

    public String getRouteStopName() {
        return routeStopName;
    }

    public void setRouteStopName(String routeStopName) {
        this.routeStopName = routeStopName;
    }
}
