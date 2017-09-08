package com.hdgh0g.backend.utils.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class MyAuthentication implements Authentication {

    private boolean isAuthenticated = true;

    private List<GrantedAuthority> authorities;

    MyAuthentication(GrantedAuthority... authority) {
        this.authorities = Arrays.asList(authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {return null;}

    @Override
    public Object getDetails() {return null;}

    @Override
    public Object getPrincipal() {return null;}

    @Override
    public boolean isAuthenticated() {return isAuthenticated;}

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {return null;}
}
