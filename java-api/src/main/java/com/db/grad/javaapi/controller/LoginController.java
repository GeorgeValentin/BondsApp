package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;

//    private final AuthenticationManager authenticationManager;
//

//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody Credentials credentials) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        credentials.getEmail(),
//                        credentials.getPassword()
//                )
//        );
//
//
//        //return ResponseEntity.ok().body(userService.registerUser(credentials));
//    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentials loginRequest) {
        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
//            );

            //authenticationManager.
            //authenticationManager.authenticate()
            userService.loginUser(loginRequest);
            //SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("Login successful!");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody Credentials credentials) {
//        return ResponseEntity.ok().body(userService.loginUser(credentials));
//    }

}
