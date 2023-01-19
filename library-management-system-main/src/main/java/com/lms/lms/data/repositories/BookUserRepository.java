package com.lms.lms.data.repositories;

import com.lms.lms.data.models.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUserRepository extends JpaRepository<BookUser, Long> {
}
