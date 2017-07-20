package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;
import ua.pp.avmelnyk.routeanalytics.persistence.HibernateUtil;

import java.util.List;

@Service
public class RouteStopServiceImpl implements RouteStopService {
    private  RouteStopDAO routeStopDAO;

    public RouteStopServiceImpl() {
        setRouteDAO();
    }

    private void setRouteDAO() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.routeStopDAO  = new RouteStopDAOImpl(session);

    }
    public void addRouteStop(RouteStop routeStop) {
        routeStopDAO.addRouteStop(routeStop);
    }

    public void updateRouteStop(RouteStop routeStop) {
        routeStopDAO.updateRouteStop(routeStop);
    }

    public List<RouteStop> getAllRouteStops() {
         return  routeStopDAO.getAllRouteStops();
    }

    public RouteStop getRouteStopById(int id) {
       return routeStopDAO.getRouteStopById(id);
    }

    public void removeRouteStop(int id) {
        routeStopDAO.removeRouteStop(id);
    }
}
