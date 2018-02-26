package ua.pp.avmelnyk.routeanalytics.dao;

import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto);
    void deleteUser(User user);
    User findUserByEmail(String email);
    User getUserByID(long id);
}
