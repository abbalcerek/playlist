package model.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Adam on 20/08/2015.
 */
@Embeddable
public class UserVoteId implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;


    public UserVoteId() {
    }

    public UserVoteId(User user, Song song) {
        this.user = user;
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVoteId that = (UserVoteId) o;

        if (!user.equals(that.user)) return false;
        return song.equals(that.song);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + song.hashCode();
        return result;
    }
}