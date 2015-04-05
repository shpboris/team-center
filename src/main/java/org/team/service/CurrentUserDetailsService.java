package org.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.team.repository.UserRepository;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		org.team.domain.User currentUser = userRepository.findOneByLogin(userName);	
		if(currentUser == null){
			throw new UsernameNotFoundException(userName);
		}
		User user = new User(currentUser.getLogin(), currentUser.getPassword(), AuthorityUtils.createAuthorityList("USER"));
		return user;
	}

}
