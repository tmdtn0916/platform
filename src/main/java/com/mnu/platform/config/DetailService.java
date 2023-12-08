package com.mnu.platform.config;


import com.mnu.platform.entity.UserData;
import com.mnu.platform.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailService implements UserDetailsService{
	private final UserService service;
	
	public DetailService(UserService service) {
		this.service = service;
	}
	
	
	@Override
	public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user = service.findByEmail(username);

		if(user == null) {
			throw new UsernameNotFoundException("User not found with email:" +username);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getAuth().toUpperCase()));

//		return User.builder()
//				.username(user.getEmail())
//				.password(user.getPasswd())
//				.authorities("ROLE_ADMIN")
//				.build();
		return new User(
				user.getEmail(),
				user.getPasswd(),
				authorities
		);
	}
}
