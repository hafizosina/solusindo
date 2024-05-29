package com.solusindo.id.dto;

import com.solusindo.id.model.UserLoginEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -4419539611761094688L;

    private Long id;
    private String username;
    private String email;
    private int age;

    public UserLoginDto(UserLoginEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.age = entity.getAge();
    }
}
