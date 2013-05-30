package com.clrvynt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.clrvynt.domain.User;

public class AppDaoImpl implements AppDao {

    @Autowired
    private EntityManager em;

    @Override
    public User login(String email, String password) {
	TypedQuery<User> query =
	        em.createQuery("select d from User d where d.email = :email and d.password = :password", User.class);
	query.setParameter("email", email);
	query.setParameter("password", password);

	List<User> users = query.getResultList();
	if (users == null || users.size() == 0)
	    return null;

	return users.get(0);
    }

    @Override
    public <T> T getById(Integer id, Class<T> clazz) {
	return em.find(clazz, id);
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
	TypedQuery<T> query = em.createQuery("select d from " + clazz.getSimpleName(), clazz);

	return query.getResultList();
    }

    @Override
    public User findUserByEmail(String email) {
	TypedQuery<User> query = em.createQuery("select d from User d where d.email = :email", User.class);
	query.setParameter("email", email);

	List<User> users = query.getResultList();
	if (users == null || users.size() == 0)
	    return null;

	return users.get(0);
    }

    @Override
    public <T> T save(T obj) {
	em.persist(obj);
	return obj;
    }

}
