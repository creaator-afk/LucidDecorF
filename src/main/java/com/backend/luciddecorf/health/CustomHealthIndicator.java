package com.backend.luciddecorf.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //Custom logic to check health of a specific service or component
        boolean isHealthy = checkServiceHealth();
        if (isHealthy) {
            return Health.up().build();
        }else {
            return Health.up().withDetail("Error", "Lucid Decor F service is down").build();
        }
    }

    private boolean checkServiceHealth() {
        // Implement your custom health check logic here
        return true;
    }
}
