package com.dockerspring.test.service;

import com.dockerspring.test.entity.Data;

import java.util.List;

public interface DataService {

    Data finById(long id);

    List<Data> findAll();

    void save(Data data);

}
