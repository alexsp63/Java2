package com.popovaproject.project.security;

import com.popovaproject.project.entity.Status_;
import com.popovaproject.project.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {

    private final String login;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;


    public SecurityUser(String login, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
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
        return login;
    }


    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }


    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }


    @Override
    public boolean isEnabled() {
        return isActive;
    }


    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPasswordHash(),
                user.getStatus().equals(Status_.ACTIVE),
                user.getStatus().equals(Status_.ACTIVE),
                user.getStatus().equals(Status_.ACTIVE),
                user.getStatus().equals(Status_.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}