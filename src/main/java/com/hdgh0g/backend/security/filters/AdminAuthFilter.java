package com.hdgh0g.backend.security.filters;

import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.security.MyAuthentication;
import com.hdgh0g.backend.security.Roles;
import com.hdgh0g.backend.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AdminAuthFilter extends OncePerRequestFilter {

    private final AdminService adminService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String headerAuthorization = request.getHeader("Authorization");
        Authentication auth;
        if (StringUtils.isBlank(headerAuthorization)) {
            auth = new MyAuthentication(new SimpleGrantedAuthority(Roles.ANONYMOUS));
        } else {

            String password = headerAuthorization.replace("Bearer", "").trim();

            if (!isValid(password)) {
                request.getRequestDispatcher( "/error/badAdminPassword").forward(request, response);
            }

            auth = new MyAuthentication(new SimpleGrantedAuthority(Roles.ADMIN));
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    private boolean isValid(String password) {
        try {
            adminService.checkPassword(password);
            return true;
        } catch (ServiceException e) {
            return false;
        }
    }

}