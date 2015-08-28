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
package controllers;

import com.google.common.collect.Lists;
import model.Message;
import model.entity.User;
import model.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Balcerek <abalcerek@opi.org.pl>
 */
@RestController
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Inject
    private Service service;

    @Inject
    UserRepository userRepository;


    @RequestMapping(path = "/d/{name}/{text}", method = RequestMethod.GET, headers="Accept=application/json")
    public Message myMessage(@PathVariable String name, @PathVariable String text) {
        return new Message(name, text);
    }

    @RequestMapping(path = "/d/{name}/{text}/{rate}", method = RequestMethod.GET, headers="Accept=application/json")
    public Message myMessageRate(@PathVariable String name, @PathVariable String text, @PathVariable Integer rate) {
        return new Message(name, text, rate);
    }

    @RequestMapping(path = "/rb", method = RequestMethod.POST, headers="Accept=application/json")
    public Message myMessage(@RequestBody Message message) {
        message.setRating(10);
        return message;
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.PUT, headers="Accept=application/json")
    public List<User> addUser() {
        service.saveRandomUser();
        return service.allUsers();
//        List<User> result = new ArrayList<>();
//        result.add(new User("1", "1"));
//        return result;
    }

    @RequestMapping(path = "/rep/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    public User user(@PathVariable Long id) {
        User result = userRepository.findOne(id);
        List<User> users = userRepository.findByName(result.getName());
        logger.debug("users: {}", users);
        return result;
    }

}
