package com.maketshirt.api.config.api;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maketshirt.api.model.ERole;
import com.maketshirt.api.model.Role;
import com.maketshirt.api.repository.RoleRepository;

@Configuration
public class ApiConfiguration {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	roleRepository.save(new Role(1,ERole.ROLE_ADMIN));
	    	roleRepository.save(new Role(2,ERole.ROLE_MODERATOR));
	    	roleRepository.save(new Role(3,ERole.ROLE_USER));
	      };
	 }
	
	
}
