package services;

import model.repositories.GenericRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Adam on 22/08/2015.
 */
@Service
public class SongService {

    @Inject
    private GenericRepository repository;



}
