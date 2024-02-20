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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer expId;
    public String companyName;
    public String role;
    public String description;
    public String startDate;
    public String endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
    
}
