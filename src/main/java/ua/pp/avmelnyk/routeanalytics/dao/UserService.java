package ua.pp.avmelnyk.routeanalytics.dao;

import ua.pp.avmelnyk.routeanalytics.model.User;

public interface UserService {

    User findByEmail( String email );
    User save (User user);
    User findByID(Long id);

}
