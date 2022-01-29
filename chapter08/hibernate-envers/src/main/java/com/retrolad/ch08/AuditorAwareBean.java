package com.retrolad.ch08;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
// The type of AuditorAware should be User
public class AuditorAwareBean implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // This should be the current user
        return Optional.of("retrolad");
    }
}
