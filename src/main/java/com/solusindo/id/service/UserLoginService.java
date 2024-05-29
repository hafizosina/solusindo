package com.solusindo.id.service;

import com.solusindo.id.constant.Default;
import com.solusindo.id.dto.ChangePasswordRequest;
import com.solusindo.id.dto.SignUpRequest;
import com.solusindo.id.dto.UserLoginDto;
import com.solusindo.id.model.UserLoginEntity;
import com.solusindo.id.repository.UserLoginRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UserLoginService {

    // TODO Password hashing, email and username validation
    // TODO Error handling if enough time
    // TODO event logging (filter?, annotation?)

    @Autowired
    private UserLoginRepository repository;

//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserLoginDto create(SignUpRequest request, HttpServletRequest servletRequest){
        UserLoginEntity entity = request.mapToEntity();
        signUpValidation(entity);
//        entity.setPassword(passwordEncoder.encode(entity.getPassword()));


        entity.setCreatedBy(Default.USER);
        entity.setCreatedDate(new Date());

        repository.save(entity);

        return new UserLoginDto(entity);
    }


    public UserLoginDto update(UserLoginDto request, HttpServletRequest servletRequest) {
        UserLoginEntity entity = repository.findByUsernameAndDeletedFalse(request.getUsername()).orElseThrow();

        entity.setAge(request.getAge());

        entity.setModifiedBy(request.getUsername());
        entity.setModifiedDate(new Date());

        repository.save(entity);

        return new UserLoginDto(entity);
    }

    public UserLoginDto changepassword(ChangePasswordRequest request, HttpServletRequest servletRequest) {
        UserLoginEntity entity = repository.findByUsernameAndDeletedFalse(request.getUsername()).orElseThrow();
        if( ! Objects.equals(entity.getPassword(), request.getOldpassword())){
            throw new IllegalStateException("Old Password not match");
        }

        entity.setPassword(request.getNewpassword());

        entity.setModifiedBy(request.getUsername());
        entity.setModifiedDate(new Date());

        repository.save(entity);

        return new UserLoginDto(entity);
    }

    public UserLoginDto delete(String username, HttpServletRequest servletRequest) {
        UserLoginEntity entity = repository.findByUsernameAndDeletedFalse(username).orElseThrow();

        entity.setModifiedBy(username);
        entity.setModifiedDate(new Date());
        entity.setDeleted(false);

        repository.save(entity);

        return new UserLoginDto(entity);
    }

    public void signUpValidation(UserLoginEntity entity) throws IllegalArgumentException {
        if (!isValidEmail(entity.getUsername())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!isValidPassword(entity.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 6 characters long, contain at least one digit, one lowercase letter, one uppercase letter, and one special character.");
        }

        if (entity.getAge() < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        return pattern.matcher(password).matches();
    }


}
