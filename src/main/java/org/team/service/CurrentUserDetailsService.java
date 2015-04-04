package org.team.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = null;
		if(userName.equals("boriss")){
			user = new User(userName, new BCryptPasswordEncoder().encode("111"), AuthorityUtils.createAuthorityList("USER"));
		}
		if(userName.equals("dimal")){
			user = new User(userName, new BCryptPasswordEncoder().encode("222"), AuthorityUtils.createAuthorityList("USER"));
		}
		
		if(user == null){
			throw new UsernameNotFoundException(userName);
		}
		
		return user;
	}

}
