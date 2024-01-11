package com.reedsolutions.authentication_system.service.impl;

import com.reedsolutions.authentication_system.dto.LoginRequest;
import com.reedsolutions.authentication_system.dto.Request;
import com.reedsolutions.authentication_system.dto.Response;
import com.reedsolutions.authentication_system.dto.UserInfo;
import com.reedsolutions.authentication_system.entity.User;
import com.reedsolutions.authentication_system.repository.UserRepository;
import com.reedsolutions.authentication_system.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<Response> signUp(Request request) {
        //if the user exists, then return error
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            return  ResponseEntity.badRequest().body(
                    Response.builder()
                            .statusCode(400)
                            .responseMessage("Attempt to save duplicate user record")
                            .build()
            );
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        User savedUser = userRepository.save((user));
        return ResponseEntity.ok().body(Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS!")
                .userInfo(modelMapper.map(savedUser, UserInfo.class))
                .build());



    }


    public ResponseEntity<Response> login(LoginRequest request) {
        return null;
    }

    @Override
    public Response sendOtp() {
        return null;
    }

    @Override
    public Response validateOtp() {
        return null;
    }

    @Override
    public Response resetPassword() {
        return null;
    }

    @Override
    public Response changePassword() {
        return null;
    }
}
