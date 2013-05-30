package com.clrvynt.dao;

import java.util.List;

import com.clrvynt.domain.User;

public interface AppDao {

    public User login(String email, String password);

    public <T> T getById(Integer id, Class<T> clazz);

    public User findUserByEmail(String email);

    public <T> T save(T obj);

    public <T> List<T> findAll(Class<T> clazz);

}
