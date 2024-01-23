package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    private RoleDao roleDao;
    private RoleDao roleRepo;

    @Override
    public Set<Role> indexRoles() {
        return (Set<Role>) entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String roleName) {
        return entityManager
                .createQuery("select r from Role r where r.name =: name", Role.class)
                .setParameter("name", roleName)
                .getResultList().stream().findFirst().orElse(null);
    }


    @Override
    public void save(Role role) {
        entityManager.persist(role);

    }

    @Override
    public Role getAllRoleByNames() {
        return null;
    }

    @Override
    public Set<Role> findAll() {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r", Role.class);
        return new HashSet<>(query.getResultList());
    }

    public Set<Role> getRoles() {
        Set<Role> roles = roleDao.findAll();
        if (roles != null) {
            return roles;
        } else {
            return new HashSet<>();
        }
    }


    @Override
    public Set<String> getAllRoleNames() {
        TypedQuery<String> query = entityManager.createQuery("SELECT r.name FROM Role r", String.class);
        return new HashSet<>(query.getResultList());
    }


    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Set<Role> getRolesByIds(Set<Integer> roleIds) {
        return (Set<Role>) entityManager
                .createQuery("select r from Role r where r.id in :ids", Role.class)
                .setParameter("ids", roleIds)
                .getResultList();
    }

    @Override
    public Role findByName(String roleName) {
        return entityManager.find(Role.class, roleName);
    }


}
