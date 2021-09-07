package com.example.challenge.serviceImp;


import com.example.challenge.service.UserService;
import com.example.challenge.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserServiceImp implements UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll(){
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verifyUser(User user){

        String query = "FROM User WHERE email = :email";
        List<User> list = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (list.isEmpty()){ return false; }

        String password = list.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);

        return argon2.verify(password, user.getPassword());
    }

}
