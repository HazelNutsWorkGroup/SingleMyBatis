package com.taiji.controller.manage;

import com.taiji.common.util.SnowflakeIdWorker;
import com.taiji.domain.manage.UserDomain;
import com.taiji.service.manage.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

/**
 * Created by Sleeb on 2017/4/7.
 */
@RestController
@RequestMapping("/api/")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "User", method = RequestMethod.POST)
    public ResponseEntity<UserDomain> addUser(@RequestBody UserDomain userDomain, UriComponentsBuilder ucBuilder) {
        userDomain.setUserId((new SnowflakeIdWorker(0, 0)).nextId());

        return new ResponseEntity<UserDomain>(userDomain, HttpStatus.OK);
    }

    @RequestMapping(value = "User/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDomain> GetUser(@PathVariable Long id) {
        logger.warn("UserId:"+id.toString());
        UserDomain userDomain = userService.getUser(id);

        return new ResponseEntity<UserDomain>(userDomain, HttpStatus.OK);
    }

    @RequestMapping(value = "User/{name}/{code}", method = RequestMethod.GET)
    public ResponseEntity<UserDomain> GetUser(@PathVariable String userNmae, @PathVariable String userCode) {

        UserDomain userDomain = new UserDomain();
        userDomain.setUserId((new SnowflakeIdWorker(0, 0)).nextId());
        userDomain.setUserName(userNmae);
        userDomain.setUserCode(userCode);
        userDomain.setLastVisited(new Date());

        return new ResponseEntity<UserDomain>(userDomain, HttpStatus.OK);
    }


    @RequestMapping(value = "Users", method = RequestMethod.POST)
    public ResponseEntity<List<UserDomain>> addUsers(@RequestBody List<UserDomain> userDomains) {
        for (UserDomain userDomain : userDomains) {
            userDomain.setUserId((new SnowflakeIdWorker(0, 0)).nextId());
            userDomain.setLastVisited(new Date());
        }

        return new ResponseEntity<List<UserDomain>>(userDomains, HttpStatus.OK);
    }
}
