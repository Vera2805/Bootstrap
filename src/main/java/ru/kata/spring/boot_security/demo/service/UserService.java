package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.management.relation.Relation;
import java.util.List;
import java.util.Set;

@Service
public interface UserService extends UserDetailsService {

    void addUser(User user);

    void deleteUser(Long id);

    Set<User> getAllUsers();

    User findByUsername(String username);

    void updateUser(User user);


    User getUser(Long id);

    String getPassword(Long id);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void updateRole(String updateRoleForm);

    void updateRole(Role r);


    void save(User user);

    void save(Role role);


    void deleteById(Long id);

    void update(Long id, User user);

    void delete(Long id);

    void update(User user);

    User findUsername(String username);

}




