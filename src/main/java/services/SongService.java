package services;

import com.google.common.collect.Lists;
import model.entity.Song;
import model.entity.Url;
import model.repositories.GenericRepository;
import model.repositories.SongRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 22/08/2015.
 */
@Service
public class SongService {

    @Inject
    private GenericRepository repository;

    @Inject
    private SongRepository songRepository;

    @Transactional
    public List<Song> addSong(String name, String url) {
        addSongVoid(name, url);
        return repository.all(Song.class);
    }

    public void addSongVoid(String name, String urlString) {
        Song song = new Song(name, "author", new ArrayList<>());
        Url url = new Url(song, urlString);
        song.setUrls(Lists.newArrayList(url));
        repository.persist(song);
    }
}
