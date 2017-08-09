package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;


public class RouteDAOImpl  implements RouteDAO {

    private Session session;

    public RouteDAOImpl(Session session) {
        this.session = session;
    }

    public void addRoute(Route route) {
        try {
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        System.out.println("Route added successfully "+route.toString());
    }

    public void updateRoute(Route route) {
        session.getTransaction().begin();
        Route merged =(Route) session.merge(route);
        session.saveOrUpdate(merged);
        session.getTransaction().commit();
        System.out.println("Route updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<Route> getAllRoutes() {
        List<Route> routes;
        try {
            Transaction transaction = session.beginTransaction();
            routes = session.createCriteria(Route.class).list();
            transaction.commit();
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return routes;

    }

    public Route getRouteById(int id) {
        Transaction transaction = session.beginTransaction();
        Route route = (Route) session.load(Route.class, id);
        transaction.commit();
        System.out.println("Route loaded successfully");
        return route;
    }

    public void removeRoute(int id) {
        Transaction transaction = session.beginTransaction();
        Route route = (Route) session.load(Route.class, id);
        if(null != route){
            session.delete(route);
            System.out.println("Route removed successfully");
        }
        transaction.commit();
    }
}