package com.partola.security_jwt.security.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class JwtUser implements UserDetails {
	
	private final Long id;
	private final String username;
	private final String lastName;
	private final String firstName;
	private final String email;
	private final String password;
	private final boolean enabled;
	private final Date lastPasswordResetDate;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public JwtUser(Long id, String username, String lastName, String firstName, String email, String password,
				   boolean enabled, Date lastPasswordResetDate, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
