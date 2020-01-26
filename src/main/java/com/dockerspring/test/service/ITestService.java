package com.dockerspring.test.service;

import com.dockerspring.test.entity.TestEntity;

import java.util.List;

public interface ITestService {

    List<TestEntity> getAll();

}
