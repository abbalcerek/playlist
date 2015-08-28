package model.repositories;

import model.repositories.UserRepositoryCustom;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Adam on 27/08/2015.
 */
class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserRepository userRepository;

    @Override
    public String hello() {
        System.out.println("nice, nice");
        return "nice";
    }
}