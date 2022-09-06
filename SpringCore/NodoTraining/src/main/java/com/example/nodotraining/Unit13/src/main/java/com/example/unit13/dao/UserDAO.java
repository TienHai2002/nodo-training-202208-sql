package com.example.unit13.dao;
import com.example.unit13.model.User;

import java.util.List;
public interface UserDAO {
    public String insert(User user);
    public void delete(String user);
    public List<User> list();
    public User get(String username);
    public void update(User user);
}
