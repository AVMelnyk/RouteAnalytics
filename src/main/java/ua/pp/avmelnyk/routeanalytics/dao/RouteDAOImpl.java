package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import java.util.List;


public class RouteDAOImpl  implements RouteDAO {

    private Session session;

    public RouteDAOImpl(Session session) {
        this.session = session;
    }

    public void addRoute(Route route) {
        Transaction transaction = session.beginTransaction();
        session.save(route);
        transaction.commit();
        System.out.println("Route added successfully "+route.toString());
    }

    public void updateRoute(Route route) {
        Transaction transaction = session.beginTransaction();
        session.update(route);
        transaction.commit();
        System.out.println("Route updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<Route> getAllRoutes() {
        Query query = session.createQuery("from Route ");
        List<Route> routes = query.list();
        System.out.println("Routes list");
        return routes;
    }

    public Route getRouteById(int id) {
        Route route = (Route) session.load(Route.class, new Integer(id));
        System.out.println("Route loaded successfully");
        return route;
    }

    public void removeRoute(int id) {
        Transaction transaction = session.beginTransaction();
        Route route = (Route) session.load(Route.class, new Integer(id));
        if(null != route){
            session.delete(route);
            System.out.println("Route removed successfully");
        }
        transaction.commit();


    }
}