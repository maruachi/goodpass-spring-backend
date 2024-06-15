package com.goodchalk.goodpass.jwt;

import com.goodchalk.goodpass.admin.domain.AdminRole;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTProvider jwtProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        int tokenIndex = authorization.indexOf(' ');
        if (tokenIndex == -1) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(tokenIndex+1);

        if (jwtProvider.isExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtProvider.getUsername(token);
        String role = jwtProvider.getRole(token);
        String roleValue = jwtProvider.getRoleValue(token);

        AdminUser adminUser = AdminUser.builder()
                .username(username)
                .adminRole(AdminRole.valueOf(role))
                .adminRoleValue(Long.parseLong(roleValue))
                .build();

        AdminUserDetails adminUserDetails = new AdminUserDetails(adminUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(adminUserDetails, null, adminUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
