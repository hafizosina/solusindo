package com.solusindo.id.repository;

import com.solusindo.id.model.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long>, JpaSpecificationExecutor<UserLoginEntity> {
    Optional<UserLoginEntity> findByUsernameAndDeletedFalse(String username);


    boolean existsByUsernameAndDeletedFalse(String username);
}
