package controllers;

import model.entity.User;
import model.repositories.GenericRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adam on 22/08/2015.
 */
@RestController
public class UserController {

    @Inject
    private GenericRepository repository;

    @RequestMapping(path = "/user/{ip}")
    private User userByIp(@PathVariable String ip) {
        if (StringUtils.isNotBlank(ip)) return null;
        return repository.findUserByIp(ip.trim());
    }

    @RequestMapping(path = "/currentUser")
    private User userByIp(HttpServletRequest request) {
        return repository.findUserByIp(request.getRemoteAddr());
    }

    @RequestMapping(path = "/addCurrentUser")
    private void userByIp(HttpServletRequest request, @RequestParam String name) {
        repository.addUserOptional(new User(request.getRemoteAddr(), name));
    }
}
