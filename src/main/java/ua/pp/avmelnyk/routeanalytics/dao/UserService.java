package ua.pp.avmelnyk.routeanalytics.dao;

import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.validation.EmailExistsException;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

public interface UserService {

    User findByEmail( String email );
    User save (User user);
    User findByID(Long id);
    User registerNewUserAccount(UserDto userDto) throws EmailExistsException;

}
