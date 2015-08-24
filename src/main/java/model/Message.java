/*
 * To oprogramowanie jest w³asnoœci¹
 *
 * OPI - Oœrodek Przetwarzania Informacji,
 * Al. Niepodleg³oœci 188B, 00-608 Warszawa
 * Numer KRS: 0000127372
 * S¹d Rejonowy dla m. st. Warszawy w Warszawie XII Wydzia³
 * Gospodarczy KRS
 * REGON: 006746090
 * NIP: 525-000-91-40
 * Wszystkie prawa zastrze¿one. To oprogramowanie mo¿e byæ u¿ywane tylko
 * zgodnie z przeznaczeniem. OPI nie odpowiada za ewentualne wadliwe
 * dzia³anie kodu.
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
