package model.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by Adam on 27/08/2015.
 */
@NoRepositoryBean
public interface UserRepositoryCustom {

    public String hello();

}
