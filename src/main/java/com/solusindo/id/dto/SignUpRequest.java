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
public class SignUpRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = -4419529611761094688L;

    private String username;
    private String password;
    private int age;

    public UserLoginEntity mapToEntity(){
        return UserLoginEntity.builder()
                .username(this.username)
                .password(this.password)
                .age(this.age)
                .build();
    }
}
