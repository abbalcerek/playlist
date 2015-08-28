package controllers;

import model.entity.Song;
import model.entity.Url;
import model.repositories.GenericRepository;
import model.repositories.SongRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.SongService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 22/08/2015.
 */
@RestController
public class SongController {

    @Inject
    private GenericRepository repository;

    @Inject
    private SongService songService;

    @Inject
    private SongRepository songRepository;

    @RequestMapping(path = "/addSong", headers="Accept=application/json")
    public List<Song> addSong(@RequestParam(required = false) Integer initRating,
                              @RequestParam(required = false) String url,
                              @RequestParam(required = false) String name) {
        return songService.addSong(name, url);
    }

    @RequestMapping(path = "/urls", headers = "Accept=application/json")
    public List<Url> urls() {
        return repository.all(Url.class);
    }

    @RequestMapping(path = "/songs", headers = "Accept=application/json")
    public List<Song> songs() {
        return songRepository.findAll();
    }

    @RequestMapping(path = "/nextSong", headers = "Accept=application/json")
    public String nextSong() {
        return "weRHyjj34ZE";
    }
}
