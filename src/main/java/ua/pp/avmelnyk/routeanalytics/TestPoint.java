package ua.pp.avmelnyk.routeanalytics;

import org.hibernate.Session;

import ua.pp.avmelnyk.routeanalytics.dao.RouteDAOImpl;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.persistence.HibernateUtil;
import java.util.List;

public class TestPoint {

    public static void main(String[]  args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RouteDAOImpl routeDAO = new RouteDAOImpl(session);
        List<Route> routes = routeDAO.listRoutes();
        for (Route routea: routes
             ) {
            System.out.println(routea.toString());
        }
        Route route = new Route("63", "Чернігівська - Червоний Хутір");
        routeDAO.addRoute(route);
    }
    public static List<Route> getRoutes(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        RouteDAOImpl routeDAO = new RouteDAOImpl(session);
        return  (routeDAO.listRoutes());

    }
}
