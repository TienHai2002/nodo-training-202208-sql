package edu.hanoi.service.impl;

import edu.hanoi.service.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component("userDAO")
public class UserDAOimpl implements UserDAO {
    private final static Logger LOGGER = null;
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean  sessionFactory){
        this.sessionFactory= sessionFactory;
    }
}
