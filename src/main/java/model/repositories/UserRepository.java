package model.repositories;

import model.entity.User;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Adam on 27/08/2015.
 */
@Transactional
public interface UserRepository extends NameableRepository<User, Long>, UserRepositoryCustom {

    public Optional<User> findByIp(Long ip);

}
