package com.lms.lms.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String password;
    //    @Column(nullable = false, length = 50)
    private String phoneNumber;
}
