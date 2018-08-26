package ua.pp.avmelnyk.routeanalytics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.avmelnyk.routeanalytics.model.User;
import ua.pp.avmelnyk.routeanalytics.model.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    final UserDAO userDAO;

    @Autowired
    public MyUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ email);
        }

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
        return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);

    }
}
