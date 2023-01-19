package com.lms.lms.data.repositories;

import com.lms.lms.data.models.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {
}
