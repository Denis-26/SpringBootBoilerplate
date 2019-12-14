package com.dockerspring.test.service;

import com.dockerspring.test.entity.BookEntity;
import com.dockerspring.test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RestService {
    private BookRepository bookRepository;

    @Autowired
    public RestService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity getBookStats(Long id){
        return bookRepository.findById(id);
    }
}
