package com.solusindo.id.service;

import com.solusindo.id.dto.datanilai.DataNilaiModusDto;
import com.solusindo.id.exception.ProcessException;
import com.solusindo.id.model.DataNilaiEntity;
import com.solusindo.id.repository.DataNilaiRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DataNilaiService {
    // TODO event logging (filter?, annotation?)

    @Autowired
    private DataNilaiRepository repository;
    public DataNilaiEntity create(DataNilaiEntity request, HttpServletRequest ignoredServletRequest){
        repository.save(request);
        return request;
    }

    public List<DataNilaiEntity> list(String name, HttpServletRequest ignoredServletRequest){
        List<DataNilaiEntity> listData;
        if (name == null || name.isEmpty()){
            listData = repository.findAll();
        }else {
            listData = repository.findAllByName(name);
        }
        return listData;
    }

    public void delete(Long id, HttpServletRequest ignoredServletRequest) {
        DataNilaiEntity entity = repository.findById(id).orElseThrow(
                () -> new ProcessException("data Not found")
        );
        repository.delete(entity);
    }

    public DataNilaiModusDto getModus() {
        List<Object[]> data = repository.findEmotionModus();
        if (data != null && !data.isEmpty()) {
            try {

                return new DataNilaiModusDto((String) data.get(0)[0], (Long) data.get(0)[1]);
            } catch (Exception e) {
                throw new ProcessException("something went wrong");
            }
        }else {
            throw new ProcessException("something went wrong");
        }
    }
}
