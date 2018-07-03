package ua.pp.avmelnyk.routeanalytics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.avmelnyk.routeanalytics.model.RouteStop;

import java.util.List;

@Service

public class RouteStopServiceImpl implements RouteStopService {

    private  RouteStopDAO routeStopDAO;

    @Autowired
    public RouteStopServiceImpl(RouteStopDAO routeStopDAO) {
        this.routeStopDAO = routeStopDAO;
    }

    @Transactional
    public void addRouteStop(RouteStop routeStop) {
        routeStopDAO.addRouteStop(routeStop);
    }
    @Transactional
    public void updateRouteStop(RouteStop routeStop) {
        routeStopDAO.updateRouteStop(routeStop);
    }
    @Transactional
    public List<RouteStop> getAllRouteStops() {
         return  routeStopDAO.getAllRouteStops();
    }
    @Transactional
    public RouteStop getRouteStopById(int id) {
       return routeStopDAO.getRouteStopById(id);
    }
    @Transactional
    public void removeRouteStop(RouteStop routeStop) {
        routeStopDAO.removeRouteStop(routeStop);
    }
}
