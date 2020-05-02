package com.dockerspring.test.controller;

import com.dockerspring.test.dto.DataDto;
import com.dockerspring.test.entity.Data;
import com.dockerspring.test.service.DataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class DataRestMethod {

    @Resource
    private DataService dataService;

    @PostMapping("/data/create")
    void createData(@RequestParam String dataName) {
        Data data = new Data();
        data.setCreateInfo(new Date());
        data.setDataName(dataName);

        dataService.save(data);
    }

    @GetMapping("/data")
    DataDto getData(@RequestParam long id) {
        Data data = dataService.finById(id);

        if (data != null) {
            DataDto dataDto = new DataDto();
            dataDto.setCreateInfo(data.getCreateInfo());
            dataDto.setDataName(data.getDataName());
            dataDto.setId(data.getId());
            return dataDto;
        }

        return new DataDto();
    }

    @GetMapping("/datas")
    List<DataDto> getDatas() {
        List<Data> dataEntities = dataService.findAll();
        List<DataDto> dataDtos = new ArrayList<>();
        for (Data data : dataEntities) {
            DataDto dataDto = new DataDto();
            dataDto.setDataName(data.getDataName());
            dataDto.setCreateInfo(data.getCreateInfo());
            dataDtos.add(dataDto);
        }

        return dataDtos;
    }

}
