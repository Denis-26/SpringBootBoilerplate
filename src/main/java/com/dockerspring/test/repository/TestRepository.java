package com.dockerspring.test.repository;

import com.dockerspring.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, String> {

    List<TestEntity> findAll();

}
