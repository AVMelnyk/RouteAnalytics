package ua.pp.avmelnyk.routeanalytics.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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

    @OneToMany(mappedBy = "route")
    private List<RouteStop> routeStops;

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

    public void setRouteStops(List<RouteStop> routeStops) {
        this.routeStops = routeStops;
    }

    @Override
    public String toString(){
        return "id="+routeID+", routeNumber="+routeNumber+", RouteName="+routeName;
    }
}
