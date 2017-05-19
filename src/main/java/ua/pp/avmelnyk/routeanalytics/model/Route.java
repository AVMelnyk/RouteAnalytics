package ua.pp.avmelnyk.routeanalytics.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
;

@Entity
@Table(name = ("ROUTES"))
public class Route {
    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = ("ID"))
    private int id;
    @Column(name = ("ROUTENUMBER"))
    private String routeNumber;
    @Column(name = ("ROUTENAME"))
    private String routeName;
    //private ArrayList<RouteStop> routeStops;
    public Route() {
    }

    public Route(String routeNumber, String routeName) {
        this.routeNumber = routeNumber;
        this.routeName = routeName;
    }

    public Route(int id, String routeNumber, String routeName) {
        this.id = id;
        this.routeNumber = routeNumber;
        this.routeName = routeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    /*
    public ArrayList<RouteStop> getRouteStops() {
        return routeStops;
    }

    public void setRouteStops(ArrayList<RouteStop> routeStops) {
        this.routeStops = routeStops;
    }
    */
    @Override
    public String toString(){
        return "id="+id+", routeNumber="+routeNumber+", RouteName="+routeName;
    }
}
