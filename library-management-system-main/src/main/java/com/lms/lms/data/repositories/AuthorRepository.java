package com.lms.lms.data.repositories;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//    Optional<Author> findAuthorByEmail(String email);
    Author findAuthorByEmail(String email);
    void deleteAuthorByEmail(String email);

    Author findAuthorById(Long id);

}
