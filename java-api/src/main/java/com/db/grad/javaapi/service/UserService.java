package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.exception.InvalidUserException;
import com.db.grad.javaapi.exception.UserAlreadyExistsException;
import com.db.grad.javaapi.exception.UserDoesNotExistException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isUserAlreadyRegistered(String email) {
        return userRepository.existsByUserEmail(email);
    }

    private boolean isUserDataInvalid(Credentials userToSave) {
        return userToSave == null || StringUtils.isNullOrEmpty(userToSave.getEmail())
                || StringUtils.isNullOrEmpty(userToSave.getPassword());
    }

    public User registerUser (Credentials userToSave) {
        // check if a user with that email already exists
        if (isUserAlreadyRegistered(userToSave.getEmail())) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }

        if (isUserDataInvalid(userToSave)) {
            throw new InvalidUserException("User email or/and password cannot be empty.");
        }

        User savedUser = new User(userToSave.getEmail(), userToSave.getPassword());
        userRepository.save(savedUser);

        return savedUser;
    }

    public User loginUser (Credentials credentials) {
        // check if a user with that email already exists
        if (!isUserAlreadyRegistered(credentials.getEmail())) {
            throw new UserDoesNotExistException("Register first.");
        }

        User existingUser = userRepository.getUserByUserEmail(credentials.getEmail());

        if (existingUser.getPassword().equals(credentials.getPassword())) {
            return existingUser;
        } else {
            throw new InvalidUserException("Password is incorrect.");
        }
    }
}
