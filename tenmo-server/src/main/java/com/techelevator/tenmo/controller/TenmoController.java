package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TenmoController {

    @Autowired
    private UserDao dao;

//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public User getBalance(@PathVariable long id) throws UsernameNotFoundException{
//        return dao.get(id);
//    }
//    @RequestMapping(path ="/tenmo", method = RequestMethod.GET)
//    public String tenmoService



}
