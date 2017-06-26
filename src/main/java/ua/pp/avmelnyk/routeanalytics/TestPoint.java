package ua.pp.avmelnyk.routeanalytics;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.pp.avmelnyk.routeanalytics.dao.RouteStopDAOImpl;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.dao.RouteServiceImpl;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;
import ua.pp.avmelnyk.routeanalytics.persistence.HibernateUtil;

import java.util.List;


public class TestPoint {

    public static void main(String[]  args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Route route = (Route)session.load(Route.class, new Integer(13));
        for (RouteStop routestop: route.getRouteStops()) {
            System.out.println(routestop.toString());
        }
        System.out.println(route.toString());
        /*List<RouteStop> routeStops =  session.createCriteria(RouteStop.class).list();
        for (RouteStop stop: routeStops) {
            System.out.println(stop.toString());
            System.out.println(stop.getRoute().toString());
        }*/
        tx.commit();
        session.close();
    }

}
