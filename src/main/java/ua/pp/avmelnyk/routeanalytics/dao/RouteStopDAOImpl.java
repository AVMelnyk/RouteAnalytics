package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;

public class RouteStopDAOImpl implements RouteStopDAO{

    private Session session;

    public RouteStopDAOImpl(Session session) {
        this.session = session;
    }

    public void addRouteStop(RouteStop routeStop) {
        try {
            session.beginTransaction();
            session.save(routeStop);
            session.flush();
            session.getTransaction().commit();
            System.out.println("RouteStop added successfully "+routeStop.toString());
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
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
        RouteStop routeStop;
       try{
           session.getTransaction().begin();
           routeStop = (RouteStop) session.load(RouteStop.class, id);
           session.getTransaction().commit();
           System.out.println("RouteStop loaded successfully");
       }
       catch (RuntimeException e){
           session.getTransaction().rollback();
           throw e;
       }

        return routeStop;
    }

    public void removeRouteStop(RouteStop routeStop) {
        try {
            session.getTransaction().begin();
                session.delete(routeStop);
                session.flush();
                System.out.println("RouteStop removed successfully");
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
            throw e;
        }

    }
}
