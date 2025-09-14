package com.saas.config.data;

import com.saas.model.Tenant;
import com.saas.repository.TenantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TenantRepository tenantRepository;

    public DataLoader(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (tenantRepository.count() == 0) {
            Tenant tenant = new Tenant();
            tenant.setId("public");
            tenant.setName("Public Tenant");
            tenantRepository.save(tenant);
        }
    }
}