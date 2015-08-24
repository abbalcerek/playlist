import junit.framework.TestCase;
import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Adam on 20/08/2015.
 */
public class Test extends TestCase {

    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    @Override
    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }


    public void testBasicUsage() {
        // create a couple of events...
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new User("asd", "asd"));
        entityManager.persist(new User("asdf", "asdfa"));
        entityManager.getTransaction().commit();
        entityManager.close();

        // now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> result = entityManager.createQuery( "from User", User.class ).getResultList();
        for ( User user : result ) {
            System.out.println( "Event (" + user );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
