package edu.hanoi.Unit7.impl;

import edu.hanoi.Unit7.dao.GroupDAO;
import edu.hanoi.Unit7.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GroupDAOimpl implements GroupDAO {

    private LocalStatelessSessionProxyFactoryBean sessionProxyFactoryBean;
    @Override
    public void insert(Group group) {

    }

    @Override
    public List<Group> list() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Group group) {

    }

    @Override
    public Group get(Integer id) {
        return null;
    }
}
