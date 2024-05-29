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

@Service
@Slf4j
public class UserLoginService {

    // TODO Password hashing, email and username validation
    // TODO Error handling if enough time
    // TODO event logging (filter?, annotation?)

    @Autowired
    private UserLoginRepository repository;

    public UserLoginDto create(SignUpRequest request, HttpServletRequest servletRequest){
        UserLoginEntity entity = request.mapToEntity();
        entity.setCreatedBy(Default.USER);
        entity.setCreatedDate(new Date());

        repository.save(entity);

        return new UserLoginDto(entity);
    }


    public UserLoginDto update(UserLoginDto request, HttpServletRequest servletRequest) {
        UserLoginEntity entity = repository.findByUsernameAndDeletedFalse(request.getUsername()).orElseThrow();

        entity.setEmail(request.getEmail());
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


}
