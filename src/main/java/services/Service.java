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
package services;

import com.google.common.collect.Lists;
import model.Message;
import model.entity.User;
import model.repositories.GenericRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

/**
 * @author Adam Balcerek <abalcerek@opi.org.pl>
 */
@org.springframework.stereotype.Service
public class Service {

    @Inject
    private GenericRepository userRepository;

    public List<Message> messages() {
        return Lists.newArrayList(new Message("m1", "m1"), new Message("m2", "m2"));
    }

    @Transactional
    public void saveRandomUser() {
        Random random = new Random();
        userRepository.addUser(new User(Long.toString(random.nextLong()), "name"));
    }

    @Transactional
    public List<User> allUsers() {
        return userRepository.all(User.class);
    }

}
