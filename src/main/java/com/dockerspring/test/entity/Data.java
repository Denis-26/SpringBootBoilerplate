package com.dockerspring.test.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "datas")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dataName")
    private String dataName;

    @Column(name = "createInfo")
    private Date createInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
