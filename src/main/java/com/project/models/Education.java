package com.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eduId;
    private String institute;
    private String degree;
    private String field;
    private Float grade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
    
}
