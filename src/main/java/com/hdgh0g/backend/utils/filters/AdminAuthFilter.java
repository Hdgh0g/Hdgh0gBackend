package com.hdgh0g.backend.utils.filters;

import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.AdminManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@RequiredArgsConstructor
public class AdminAuthFilter extends OncePerRequestFilter {

    private final AdminManager adminManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String headerAuthorization = request.getHeader("Authorization");
        Authentication auth;
        if (StringUtils.isBlank(headerAuthorization)) {
            auth = new MyAuthentication(new SimpleGrantedAuthority("ROLE_ANON"));
        } else {

            String password = headerAuthorization.replace("Bearer", "").trim();

            if (!isValid(password)) {
                request.getRequestDispatcher( "/error/badAdminPassword").forward(request, response);
            }

            auth = new MyAuthentication(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    private boolean isValid(String password) {
        try {
            adminManager.checkPassword(password);
            return true;
        } catch (ServiceException e) {
            return false;
        }
    }

}