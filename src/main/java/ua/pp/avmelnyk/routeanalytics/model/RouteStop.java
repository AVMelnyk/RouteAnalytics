package ua.pp.avmelnyk.routeanalytics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTESTOP")
public class RouteStop {

    @Id
    @Column(name = "ROUTESTOPID")
    private int routeStopId;

    @Column(name = "ROUTESTOPNAME")
    private String routeStopName;

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

    @Override
    public String toString(){
        return "RouteStopName" + routeStopName;
    }

}
