package it.unitoma3.ferrarisucks.service;

import it.unitoma3.ferrarisucks.model.Credentials;
import it.unitoma3.ferrarisucks.repository.CredentialsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialsService {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected CredentialsRepository credentialsRepository;

    @Transactional
    public Credentials getCredentials(Long id) {
        Optional<Credentials> result = this.credentialsRepository.findById(id);
        return result.orElse(null);
    }

    @Transactional
    public Credentials getCredentials(String username) {
        Optional<Credentials> result = this.credentialsRepository.findByUsername(username);
        return result.orElse(null);
    }

    @Transactional
    public Credentials saveCredentials(Credentials credentials) {
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));

        // Check if the username is "troylion56" to assign the admin role
        if (credentials.getUsername().equals("troylion56")) {
            credentials.setRole(Credentials.ADMIN_ROLE);
        } else {
            credentials.setRole(Credentials.DEFAULT_ROLE);
        }

        return credentialsRepository.save(credentials);
    }

}
