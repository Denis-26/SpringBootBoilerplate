package com.dockerspring.test.repository;

import com.dockerspring.test.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {

    BookEntity findById(Long id);

}
