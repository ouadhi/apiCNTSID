package com.douane.securite.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douane.securite.dao.RoleRepository;
import com.douane.securite.dao.UserDao;
import com.douane.securite.model.DAOUser;
import com.douane.securite.model.Role;
import com.douane.securite.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RoleRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				// this ArrayList is for ROLES Details
				getAuthority(user));
	}

	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		Set<Role> s = new HashSet<Role>();

		for (String role_name : user.getRoles()) {
			Role role = repository.getRoleByName(role_name);
			s.add(role);
		}

		newUser.setRoles(s);
		return userDao.save(newUser);
	}

	private Set<SimpleGrantedAuthority> getAuthority(DAOUser user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			// authorities.add(new SimpleGrantedAuthority(role.getName()));
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		// return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public void  initRole ()  {
		Role adminRole = new Role("admin", "admin role ") ; 
		Role dpworldRole = new Role("Dpworld", "Dpworld role ") ; 
		Role epalRole = new Role("epal", "epal role ") ; 
		Role douaneRole = new Role("douane", "douane role ") ; 
		
		List<Role>  roleList= new ArrayList<Role>() ;
		roleList.add(adminRole);
		roleList.add(dpworldRole);
		roleList.add(epalRole) ; 
		roleList.add(douaneRole) ; 
		
		for (Role role : roleList) {
			this.addRole(role);
		}
	 
	}

	private void addRole(Role role) {

		if (repository.getRoleByName(role.getName()) == null) {
			repository.save(role);
		}

	}

}