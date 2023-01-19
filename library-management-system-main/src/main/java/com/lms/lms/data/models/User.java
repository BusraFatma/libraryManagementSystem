package com.lms.lms.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@Table(name = "baseUser")
public class User {
//    @Column(nullable = false, length = 50)
    private String firstName;
//    @Column(nullable = false, length = 50)
    private String lastName;
//    @Column(nullable = false, length = 50, unique = true)
    @Email
    private String email;
//    @Column(nullable = false, length = 50)

    @CreationTimestamp
    private Instant createdDate = Instant.now();
    @UpdateTimestamp
    private Instant modifiedDate = Instant.now();

}
