package model.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Adam on 22/08/2015.
 */
@Entity
@Table(name = "song")
public class Song implements Serializable {

    private Long id;

    private String name;

    private String author;

    private List<Url> urls;


    public Song() {
    }

    public Song(String name, String author, List<Url> urls) {
        this.name = name;
        this.author = author;
        this.urls = urls;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "song", cascade = javax.persistence.CascadeType.ALL)
    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return id.equals(song.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
