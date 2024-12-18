

package com.nsa.ano.service;

import com.nsa.ano.dto.LoginRequest;
import com.nsa.ano.dto.RegisterRequest;
import com.nsa.ano.model.User;
import com.nsa.ano.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {
        // Check if passwords match
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Passwords do not match.";
        }

        // Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            return "Email is already in use.";
        }

        // Create and save the new user
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Storing plain-text password (Not secure)

        userRepository.save(user);
        return "Registration successful.";
    }

    public boolean login(LoginRequest request) {
        // Find user by email
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            return false;
        }

        // Compare the provided password with the stored password
        return request.getPassword().equals(user.get().getPassword());
    }
}
