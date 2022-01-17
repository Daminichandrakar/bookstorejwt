package com.bookstore.bookstore.service;

import com.bookstore.bookstore.payload.request.LoginRequest;
import com.bookstore.bookstore.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthenticateUserService {

    ResponseEntity logInUser(LoginRequest loginRequest);
    ResponseEntity registerUser(SignupRequest signUpRequest);
//    String forgotPassword(String email);
//    String resetPassword(String newPassword, String token);

    Boolean isTokenValid(String token);
}

