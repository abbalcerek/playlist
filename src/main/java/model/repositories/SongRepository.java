package model.repositories;

import model.entity.Song;

import javax.transaction.Transactional;

/**
 * Created by Adam on 27/08/2015.
 */
@Transactional
public interface SongRepository extends NameableRepository<Song, Long> {
}
