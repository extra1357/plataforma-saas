package com.saas.config;

import java.util.UUID;

public class TenantContext {

    // ThreadLocal garante que cada requisição tenha seu tenantId isolado
    private static final ThreadLocal<UUID> currentTenant = new ThreadLocal<>();

    public static UUID getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(UUID tenantId) {
        currentTenant.set(tenantId);
    }

    public static void clear() {
        currentTenant.remove();
    }
}
