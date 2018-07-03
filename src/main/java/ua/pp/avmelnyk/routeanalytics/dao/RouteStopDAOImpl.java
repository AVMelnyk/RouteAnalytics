package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;

@Repository
public class RouteStopDAOImpl implements RouteStopDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public RouteStopDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public void addRouteStop(RouteStop routeStop) {
            getCurrentSession().save(routeStop);
            System.out.println("RouteStop added successfully "+routeStop.toString());
    }

    public void updateRouteStop(RouteStop routeStop) {
        getCurrentSession().update(routeStop);
        System.out.println("RouteStop updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<RouteStop> getAllRouteStops() {
        List<RouteStop> routeStops = getCurrentSession().createCriteria(RouteStop.class).list();
        return routeStops;
    }

    public RouteStop getRouteStopById(int id) {
        RouteStop routeStop= (RouteStop) getCurrentSession().load(RouteStop.class, id);
        System.out.println("RouteStop loaded successfully");
        return routeStop;
    }

    public void removeRouteStop(RouteStop routeStop) {
        getCurrentSession().delete(routeStop);
        getCurrentSession().flush();
        System.out.println("RouteStop removed successfully");

    }
}
