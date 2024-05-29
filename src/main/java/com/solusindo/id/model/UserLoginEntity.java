package com.solusindo.id.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@Entity
@SuperBuilder
@Table(name = "USER_LOGIN")
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Min(value = 18)
    @Column(name = "age", nullable = false)
    private int age;
}
