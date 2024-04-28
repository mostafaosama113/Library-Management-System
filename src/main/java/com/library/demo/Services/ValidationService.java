package com.library.demo.Services;

import com.library.demo.Models.RegisterRequest;
import com.library.demo.Repositories.UserReposirtory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ValidationService {
    // Regex to validate email
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final UserReposirtory userRepository;
    // Pre-compiled Pattern instance
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);



    public  boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    public  boolean existEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean validateRegisterRequest(RegisterRequest request) {
        if(request==null ||request.getPassword()==null ||request.getPassword().length()<2||
                request.getFirstName()==null||request.getFirstName().length()<2||
                request.getLastName()==null||request.getLastName().length()<2){
            return false;
        }
        return true;
    }
}
