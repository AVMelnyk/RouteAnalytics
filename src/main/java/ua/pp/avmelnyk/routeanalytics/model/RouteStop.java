package ua.pp.avmelnyk.routeanalytics.model;

import javax.persistence.*;

@Entity
@Table(name = "ROUTESTOP")
public class RouteStop {

    @Id
    @Column(name = "ROUTESTOPID")
    private int routeStopId;

    @Column(name = "ROUTESTOPNAME")
    private String routeStopName;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Route route;

    public RouteStop(int routeStopId, String routeStopName, Route route) {
        this.routeStopId = routeStopId;
        this.routeStopName = routeStopName;
        this.route = route;
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

    @Override
    public String toString(){
        return "RouteStopName" + routeStopName;
    }

}
