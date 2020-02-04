package crudSecurity.dao;

import crudSecurity.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRoleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

}
