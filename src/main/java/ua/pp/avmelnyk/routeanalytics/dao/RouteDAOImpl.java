package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import java.util.List;

@Repository
public class RouteDAOImpl implements RouteDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public void addRoute(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(route);
        System.out.println("Route saved successfully");
    }

    public void updateRoute(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(route);
        System.out.println("Route updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<Route> listRoutes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Route> routes = session.createQuery("from Route ").list();
        System.out.println("Routes list");
        return routes;
    }

    public Route getRouteById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = (Route) session.load(Route.class, new Integer(id));
        System.out.println("Route loaded successfully");
        return route;
    }

    public void removeRoute(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Route route = (Route) session.load(Route.class, new Integer(id));
        if(null != route){
            session.delete(route);
        }

    }
}
