package com.solusindo.id.repository;

import com.solusindo.id.model.DataNilaiEntity;
import com.solusindo.id.model.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataNilaiRepository extends JpaRepository<DataNilaiEntity, Long>{

}
