package model.repositories;

import com.google.common.collect.Lists;
import model.entity.Song;
import model.entity.Url;
import model.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 22/08/2015.
 */
@Deprecated
@Repository
public class GenericRepository {

    @PersistenceContext
    protected EntityManager em;

//    @PostConstruct
//    public void init() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        em =  entityManagerFactory.createEntityManager();
//    }

    @Transactional
    public User findUserByIp(String ip) {
        if (ip == null) return null;
        List<User> result = (List<User>) em.createQuery(
                "SELECT c FROM User c WHERE c.ip LIKE ?1")
                .setParameter(1, ip)
                .getResultList();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);
    }

    @Transactional
    public boolean addUserOptional(User user) {
        boolean result = false;
        if ((Long)em.createQuery(
                "SELECT count(c) FROM User c WHERE c.ip LIKE ?1")
                .setParameter(1, user.getIp()).getSingleResult() == 0L) {
            em.persist(user);
            result = true;
        }
        return result;
    }

    @Transactional
    public <T> List<T> all(Class clazz) {
        List<T> result = em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
        return result;
    }
}
