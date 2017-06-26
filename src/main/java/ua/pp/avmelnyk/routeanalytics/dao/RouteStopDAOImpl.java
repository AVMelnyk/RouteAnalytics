package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;
@Service
public class RouteStopDAOImpl implements RouteStopDAO{

    private Session session;

    public RouteStopDAOImpl(Session session) {
        this.session = session;
    }

    public void addRouteStop(RouteStop routeStop) {
        try {
            session.beginTransaction();
            session.save(routeStop);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        System.out.println("RouteStop added successfully "+routeStop.toString());
    }

    public void updateRouteStop(RouteStop routeStop) {
        Transaction transaction = session.beginTransaction();
        RouteStop merged;
        merged = (RouteStop) session.merge(routeStop);
        session.save(merged);
        transaction.commit();
        System.out.println("RouteStop updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<RouteStop> getAllRouteStops() {
        List<RouteStop> routeStops;
        try {
            Transaction transaction = session.beginTransaction();
            routeStops = session.createCriteria(RouteStop.class).list();
            transaction.commit();
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return routeStops;
    }

    public RouteStop getRouteStopById(int id) {
        Transaction transaction = session.beginTransaction();
        RouteStop routeStop = (RouteStop) session.load(RouteStop.class, id);
        transaction.commit();
        System.out.println("RouteStop loaded successfully");
        return routeStop;
    }

    public void removeRouteStop(int id) {
        Transaction transaction = session.beginTransaction();
        RouteStop routeStop = (RouteStop) session.load(RouteStop.class, id);
        if(null != routeStop){
            session.delete(routeStop);
            System.out.println("RouteStop removed successfully");
        }
        transaction.commit();
    }
}
