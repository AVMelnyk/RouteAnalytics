package ua.pp.avmelnyk.routeanalytics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.validation.EmailExistsException;
import ua.pp.avmelnyk.routeanalytics.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address:" + accountDto.getEmail());
        }

        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setUsername(accountDto.getUserName());
        /*Set<UserProfile> userProfiles = new HashSet<UserProfile>();
        userProfiles.add(new UserProfile());
        user.setUserProfiles(userProfiles);*/
        return userDAO.save(user);
    }

    @Transactional
    public boolean emailExist(String email) {
        User user = userDAO.findByEmail(email);
        return user != null;
    }

    @Transactional
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Transactional
    public User save(User user) {
        return  userDAO.save(user);
    }
    
    @Transactional
    public User findByID(Long id) {
        return userDAO.findByID(id);
    }


}
