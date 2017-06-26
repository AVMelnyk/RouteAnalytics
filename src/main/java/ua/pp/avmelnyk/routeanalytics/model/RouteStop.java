package ua.pp.avmelnyk.routeanalytics.model;

import javax.persistence.*;

@Entity
@Table(name = "ROUTESTOPS")
public class RouteStop {

    @Id
    @Column(name = "routestop_id")
    private int routeStopId;

    @Column(name = "ROUTESTOPNAME")
    private String routeStopName;

    @ManyToOne
    @JoinColumn(name = "ROUTE_ID")
    private Route route;

    public RouteStop(int routeStopId, String routeStopName) {
        this.routeStopId = routeStopId;
        this.routeStopName = routeStopName;
    }

    public RouteStop() {
    }

    public int getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(int routeStopId) {
        this.routeStopId = routeStopId;
    }

    public String getRouteStopName() {
        return routeStopName;
    }

    public void setRouteStopName(String routeStopName) {
        this.routeStopName = routeStopName;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "RouteStop{" +
                "routeStopId=" + routeStopId +
                ", routeStopName='" + routeStopName + '\'' +
                ", route=" + route +
                '}';
    }
}
