package com.douane.securite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douane.securite.dao.UserDao;
import com.douane.securite.model.DAOUser;

import springfox.documentation.annotations.ApiIgnore;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@ApiIgnore

public class Userconroller {
	
	@Autowired  
	private  UserDao  dao   ;  
	
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<DAOUser> listUser(){
    	List<DAOUser> list = new ArrayList<>(); 
    	dao.findAll().forEach((user) -> {
    		list.add(user); 
    	});
        return list  ; 
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping (value = "/users/{id}", method = RequestMethod.GET)
    public DAOUser getOne(@PathVariable(value = "id") Long id){
        return  dao.findById(id).get() ; 
    }

}
