package ua.pp.avmelnyk.routeanalytics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.avmelnyk.routeanalytics.model.Route;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    private RouteDAO routeDAO;

    @Autowired
    public RouteServiceImpl(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @Transactional
    public void addRoute(Route route) {
        this.routeDAO.addRoute(route);
    }
    @Transactional
    public void updateRoute(Route route) {
        this.routeDAO.updateRoute(route);
    }
    @Transactional
    public List<Route> getAllRoutes() {
        return this.routeDAO.getAllRoutes();
    }
    @Transactional
    public Route getRouteById(int id) {
        return this.routeDAO.getRouteById(id);
    }
    @Transactional
    public void removeRoute(int id) {
        this.routeDAO.removeRoute(id);
    }
}