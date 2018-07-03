package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.avmelnyk.routeanalytics.model.Route;

import java.util.List;

@Repository
public class RouteDAOImpl  implements RouteDAO {

    private  SessionFactory sessionFactory;

    @Autowired
    public RouteDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public void addRoute(Route route) {
        getCurrentSession().persist(route);
        System.out.println("Route added successfully "+route.toString());
    }

    public void updateRoute(Route route) {
        getCurrentSession().saveOrUpdate(route);
        System.out.println("Route updated successfully");
    }

    @SuppressWarnings("unchecked")
    public List<Route> getAllRoutes() {
        List<Route> routes;
        routes = getCurrentSession().createCriteria(Route.class).list();
        return routes;
    }

    public Route getRouteById(int id) {
        Route route = (Route) getCurrentSession().load(Route.class, id);
        System.out.println("Route loaded successfully");
        return route;
    }

    public void removeRoute(int id) {
        Route route = (Route) getCurrentSession().load(Route.class, id);
        if(null != route){
            getCurrentSession().delete(route);
            System.out.println("Route removed successfully");
        }
    }
}