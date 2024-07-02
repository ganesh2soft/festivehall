package com.aynavil.festivehall.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.aynavil.festivehall.entity.Customer;
import com.aynavil.festivehall.repository.CustomerRepo;

@Component
public class CustomerAuthProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepo customerRepo;	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		System.out.println("dddddddddddddddddddddddddd"+username);

		Customer customer = customerRepo.findCustomerByEmail(username);
		
		/*
		 * @Column(nullable = false,unique=true) private String customer;
		 */
	
		if (customer == null) {
			throw new StackOverflowError("No user got registered");
		} else if (pwd.equals(customer.getPassword())) {
			
			 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, pwd);
			 System.out.println(authenticationToken);
			 return authenticationToken;
		//	List<GrantedAuthority> authorities = new ArrayList<>();
	//		authorities.add(new SimpleGrantedAuthority(customer.getRoles()));
		//	return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
		} else {
			System.out.println("I am a bad credentails");
			throw new StackOverflowError("Invalid Password");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}




