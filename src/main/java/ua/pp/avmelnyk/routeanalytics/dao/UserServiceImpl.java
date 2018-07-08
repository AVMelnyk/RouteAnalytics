package ua.pp.avmelnyk.routeanalytics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;
import ua.pp.avmelnyk.routeanalytics.validation.EmailExistsException;

public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  accountDto.getEmail());
        }
    }

    private boolean emailExist(String email) {
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
