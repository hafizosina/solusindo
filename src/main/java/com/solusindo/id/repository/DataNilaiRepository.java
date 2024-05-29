package com.solusindo.id.repository;

import com.solusindo.id.dto.datanilai.DataNilaiModusDto;
import com.solusindo.id.model.DataNilaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataNilaiRepository extends JpaRepository<DataNilaiEntity, Long>{

    @Query(value = "SELECT d.emotion AS emotion, COUNT(d.emotion) AS count " +
            "FROM data_nilai d " +
            "GROUP BY d.emotion " +
            "ORDER BY count DESC " +
            "LIMIT 1", nativeQuery = true)
    List<Object[]> findEmotionModus();

    List<DataNilaiEntity> findAllByName(String name);
}
