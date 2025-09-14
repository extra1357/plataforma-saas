package com.saas.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenant = request.getHeader("X-Tenant-ID"); // pega tenant do header
        if (tenant != null && !tenant.isEmpty()) {
            CurrentTenantIdentifierResolverImpl.setCurrentTenant(tenant);
        } else {
            CurrentTenantIdentifierResolverImpl.setCurrentTenant("public"); // default schema
        }
        return true;
    }
}
