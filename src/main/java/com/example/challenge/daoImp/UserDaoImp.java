package com.example.challenge.daoImp;

import com.example.challenge.dao.UserDao;
import com.example.challenge.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;


@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }
}
