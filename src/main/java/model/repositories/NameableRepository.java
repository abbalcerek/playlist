package model.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Adam on 27/08/2015.
 */
@NoRepositoryBean
public interface NameableRepository<T, ID extends Serializable> extends BaseRepository<T, ID> {

    public List<T> findByName(String wtf);
}
