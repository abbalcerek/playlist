/*
 * To oprogramowanie jest w�asno�ci�
 *
 * OPI - O�rodek Przetwarzania Informacji,
 * Al. Niepodleg�o�ci 188B, 00-608 Warszawa
 * Numer KRS: 0000127372
 * S�d Rejonowy dla m. st. Warszawy w Warszawie XII Wydzia�
 * Gospodarczy KRS
 * REGON: 006746090
 * NIP: 525-000-91-40
 * Wszystkie prawa zastrze�one. To oprogramowanie mo�e by� u�ywane tylko
 * zgodnie z przeznaczeniem. OPI nie odpowiada za ewentualne wadliwe
 * dzia�anie kodu.
 */
package model;

/**
 * @author Adam Balcerek <abalcerek@opi.org.pl>
 */
public class Message {

    String name;
    String text;
    Integer rating = 2;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Message(String name, String text, Integer rating) {
        this.name = name;
        this.text = text;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
