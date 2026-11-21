
package com.inventory.smartinventory.serviceimpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.entity.User;
import com.inventory.smartinventory.repository.UserRepo;
import com.inventory.smartinventory.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            UserRepo userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        user.setRole("STAFF");
        user.setEnabled(true);

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                password, user.getPassword())) {

            throw new RuntimeException("Invalid password");
        }

        if (!user.isEnabled()) {
            throw new RuntimeException("Account is disabled");
        }

        return user;
    }
}
