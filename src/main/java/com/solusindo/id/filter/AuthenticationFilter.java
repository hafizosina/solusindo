package com.solusindo.id.filter;

import com.solusindo.id.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

import static com.solusindo.id.constant.Default.AUTH_WHITELIST;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Filter");
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI().replace(contextPath,"");

        if (Arrays.stream(AUTH_WHITELIST).anyMatch(uri -> requestURI.startsWith(uri.replace("/**", "")))) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = jwtUtil.getToken(request);
        UsernamePasswordAuthenticationToken auth = jwtUtil.getAuthentication(token);
        if (auth != null) {
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
