package controllers;

import model.entity.Song;
import model.entity.Url;
import model.repositories.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Adam on 22/08/2015.
 */
@RestController
public class SongController {

    @Inject
    private GenericRepository repository;

    @RequestMapping(path = "/addSong", headers="Accept=application/json")
    public List<Song> addSong(@RequestParam(required = false) Integer initRating,
                              @RequestParam(required = false) String url,
                              @RequestParam(required = false) String name) {
        repository.addSong(name, url);
        return repository.all(Song.class);
    }

    @RequestMapping(path = "/urls", headers = "Accept=application/json")
    public List<Url> urls() {
        return repository.all(Url.class);
    }

    @RequestMapping(path = "/songs", headers = "Accept=application/json")
    public List<Song> songs() {
        return repository.all(Song.class);
    }
}
