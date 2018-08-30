package ua.pp.avmelnyk.routeanalytics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.avmelnyk.routeanalytics.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    private  SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public User findByEmail( String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
        query.setParameter("email", email);
        if (query.list().size()>0){
            return (User) query.list().get(0);
        }
        return null;

    }

    public User save(User user) {

      Long id = (Long)getCurrentSession().save(user);
       return  findByID(id);

    }

    public User findByID(Long id){

        return (User) getCurrentSession().load(User.class, id);
    }
}
