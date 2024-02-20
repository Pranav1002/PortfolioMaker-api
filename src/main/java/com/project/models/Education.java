package com.project.models;

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
    public Integer eduId;
    public String institute;
    public String degree;
    public String field;
    public float grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
    
}
