package com.reedsolutions.authentication_system.service;

import com.reedsolutions.authentication_system.dto.LoginRequest;
import com.reedsolutions.authentication_system.dto.Request;
import com.reedsolutions.authentication_system.dto.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Response> signUp(Request request);
    ResponseEntity<Response> login(LoginRequest request);
    Response sendOtp();
    Response validateOtp();
    Response resetPassword();
    Response changePassword();
}
