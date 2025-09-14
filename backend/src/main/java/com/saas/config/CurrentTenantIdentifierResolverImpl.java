package com.saas.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

// A anotação @Component foi removida para evitar conflitos de beans
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    // Aqui você pode obter o tenant do JWT ou Header
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = currentTenant.get();
        return tenant != null ? tenant : "public"; // Schema default
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}