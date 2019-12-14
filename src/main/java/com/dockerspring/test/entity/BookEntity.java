package com.dockerspring.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookEntity {

    @Id
    private Long id;

    private String title;
    private String author;

}
