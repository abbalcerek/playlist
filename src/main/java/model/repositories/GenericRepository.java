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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 22/08/2015.
 */

@Repository
public class GenericRepository {

    protected EntityManager em;

    @PostConstruct
    public void init() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        em =  entityManagerFactory.createEntityManager();
    }

    public User findUserByIp(String ip) {
        if (ip == null) return null;
        em.getTransaction().begin();
        List<User> result = (List<User>) em.createQuery(
                "SELECT c FROM User c WHERE c.ip LIKE ?1")
                .setParameter(1, ip)
                .getResultList();
        em.getTransaction().commit();
        if (result.isEmpty()) return null;
        else return result.get(0);
    }

    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void add(Object object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public boolean addUserOptional(User user) {
        boolean result = false;
        em.getTransaction().begin();
        if ((Long)em.createQuery(
                "SELECT count(c) FROM User c WHERE c.ip LIKE ?1")
                .setParameter(1, user.getIp()).getSingleResult() == 0L) {
            em.persist(user);
            result = true;
        }
        em.getTransaction().commit();
        return result;
    }

    public <T> List<T> all(Class clazz) {
        em.getTransaction().begin();
        List<T> result = em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
        em.getTransaction().commit();
        return result;
    }

    public void addSong(String name, String urlString) {
        em.getTransaction().begin();
        Song song = new Song(name, "author", new ArrayList<>());
        Url url = new Url(song, urlString);
        song.setUrls(Lists.newArrayList(url));
        em.persist(song);
        em.getTransaction().commit();
    }
}
