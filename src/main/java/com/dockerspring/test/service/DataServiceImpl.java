package com.dockerspring.test.service;

import com.dockerspring.test.dao.DataDao;
import com.dockerspring.test.entity.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource
    private DataDao dataDao;

    @Override
    public Data finById(long id) {
        return dataDao.findDataById(id);
    }

    @Override
    public List<Data> findAll() {
        return dataDao.findAll();
    }

    @Override
    public void save(Data data) {
        dataDao.save(data);
    }
}
