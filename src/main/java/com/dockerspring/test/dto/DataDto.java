package com.dockerspring.test.dto;

import java.util.Date;

public class DataDto {

    private long id;
    private String dataName;
    private Date createInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Date getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(Date createInfo) {
        this.createInfo = createInfo;
    }
}
