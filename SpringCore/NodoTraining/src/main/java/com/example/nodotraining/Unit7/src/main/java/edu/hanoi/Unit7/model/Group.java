package edu.hanoi.Unit7.model;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name="haint_student",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    public Group() {
    }
}

