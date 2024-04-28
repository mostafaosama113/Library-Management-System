package com.library.demo.Controllers;

import com.library.demo.Models.AuthenticationRequest;
import com.library.demo.Models.RegisterRequest;
import com.library.demo.Responses.GenaricResponse;
import com.library.demo.Services.AuthenticationService;
import com.library.demo.Services.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final ValidationService validationService;

    @PostMapping("register")
    public ResponseEntity<GenaricResponse> register(@RequestBody RegisterRequest request) {

//        if(validationService.existEmail(request.getEmail())){
//            return new ResponseEntity<>(new GenaricResponse(HttpStatus.BAD_REQUEST.value(), "Email is already exits."),HttpStatus.BAD_REQUEST);
//        }
        if(!validationService.validateRegisterRequest(request)){
            return new ResponseEntity<>(new GenaricResponse(HttpStatus.BAD_REQUEST.value(), "All fields must be at least 2 characters long"),HttpStatus.BAD_REQUEST);
        }
        if(!validationService.validateEmail(request.getEmail())){
            return new ResponseEntity<>(new GenaricResponse(HttpStatus.BAD_REQUEST.value(), "Email is not valid."),HttpStatus.BAD_REQUEST);
        }

        GenaricResponse response=authenticationService.register(request);
        if(response.getStatus()==HttpStatus.CONFLICT.value()){
            return new ResponseEntity<>(response,HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @PostMapping("login")
    public ResponseEntity<GenaricResponse> authenticate(@RequestBody AuthenticationRequest request) {
       GenaricResponse genaricResponse= authenticationService.authenticate(request);
       if(genaricResponse.getStatus()==HttpStatus.FORBIDDEN.value()){
           return new ResponseEntity<>(genaricResponse,HttpStatus.FORBIDDEN);
       }
       return new ResponseEntity<>(genaricResponse,HttpStatus.OK);

    }
}
