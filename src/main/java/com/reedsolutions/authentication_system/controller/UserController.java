package com.reedsolutions.authentication_system.controller;

import com.reedsolutions.authentication_system.dto.Request;
import com.reedsolutions.authentication_system.dto.Response;
import com.reedsolutions.authentication_system.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth/")
@AllArgsConstructor

public class UserController {
    private UserService userService;
    @PostMapping("signup")
    public ResponseEntity<Response> signUp(@RequestBody Request request){
        return userService.signUp(request);
    }

}
