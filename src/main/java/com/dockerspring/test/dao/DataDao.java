package com.dockerspring.test.dao;


import com.dockerspring.test.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataDao extends JpaRepository<Data, Long> {

    Data findDataById(long id);

}
