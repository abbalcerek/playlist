package model.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Adam on 20/08/2015.
 */
@Entity
@Table(name = "user_vote")
@AssociationOverrides({
        @AssociationOverride(name = "user", joinColumns = @JoinColumn(name = "id")),
        @AssociationOverride(name = "song", joinColumns = @JoinColumn(name = "id"))
})
public class UserVote implements Serializable {

    private UserVoteId id;

    private Integer rating;

    public UserVote() {
    }

    @Min(0)
    @Max(10)
    public UserVote(UserVoteId id, Integer rating) {
        this.rating = rating;
    }

    @EmbeddedId
    public UserVoteId getId() {
        return id;
    }

    public void setId(UserVoteId id) {
        this.id = id;
    }

    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
