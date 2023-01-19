package com.lms.lms.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(nullable = false, length = 50)
    private String bookName;
//    @Column(nullable = false, length = 50)
    private int quantity;
//    @Column(nullable = false, length = 50)
    private Long isbn;
    private String yearPublished;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();
    @CreationTimestamp
    private Instant createdDate = Instant.now();
    @UpdateTimestamp
    private Instant modifiedDate = Instant.now();


}
