package ua.pp.avmelnyk.routeanalytics.model;

import java.util.Date;
import java.util.Set;

public class Survey {

    private long ID;
    private String Name;
    private User Manager;
    private Date start;
    private Date end;
    private Set<User> observers;
    private Set<Route> routes;

    public Survey() {
    }

    public Survey(String name, User manager, Date start, Date end) {
        Name = name;
        Manager = manager;
        this.start = start;
        this.end = end;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public User getManager() {
        return Manager;
    }

    public void setManager(User manager) {
        Manager = manager;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Set<User> getObservers() {
        return observers;
    }

    public void setObservers(Set<User> observers) {
        this.observers = observers;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }
}
