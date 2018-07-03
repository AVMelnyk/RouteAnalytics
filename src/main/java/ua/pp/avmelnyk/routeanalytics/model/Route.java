package ua.pp.avmelnyk.routeanalytics.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = ("ROUTES"))
public class Route {

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = ("ROUTE_ID"))
    private int routeID;
    @Column(name = ("ROUTENUMBER"))
    private String routeNumber;
    @Column(name = ("ROUTENAME"))
    private String routeName;

    @OneToMany(mappedBy = "route", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RouteStop> routeStops = new ArrayList<RouteStop>();

    public Route() {
    }

    public Route(String routeNumber, String routeName) {
        this.routeNumber = routeNumber;
        this.routeName = routeName;
    }

    public Route(int routeID, String routeNumber, String routeName) {
        this.routeID = routeID;
        this.routeNumber = routeNumber;
        this.routeName = routeName;
    }

    public int getId() {
        return routeID;
    }

    public void setId(int routeID) {
        this.routeID = routeID;
    }


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

    public List<RouteStop> getRouteStops() {
        return (List<RouteStop>) routeStops;
    }

    public void setRouteStops(List<RouteStop>routeStopsList) {
        this.routeStops.addAll(routeStopsList);
    }

    @Override
    public String toString(){
        return "id="+routeID+", routeNumber="+routeNumber+", RouteName="+routeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        return routeID == route.routeID;
    }

    @Override
    public int hashCode() {
        return routeID;
    }
}
