package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import ua.pp.avmelnyk.routeanalytics.persistence.HibernateUtil;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{
    private RouteDAO routeDAO;

    public RouteServiceImpl() {
        setRouteDAO();
    }
    private void setRouteDAO() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.routeDAO  = new RouteDAOImpl(session);
    }

    public void addRoute(Route route) {
        this.routeDAO.addRoute(route);
    }

    public void updateRoute(Route route) {
        this.routeDAO.updateRoute(route);
    }

    public List<Route> getAllRoutes() {
        return this.routeDAO.getAllRoutes();
    }

    public Route getRouteById(int id) {
        return this.routeDAO.getRouteById(id);
    }

    public void removeRoute(int id) {
        this.routeDAO.removeRoute(id);
    }
}