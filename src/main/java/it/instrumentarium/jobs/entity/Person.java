package it.instrumentarium.jobs.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
    @Id @GeneratedValue private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String name;
    @CreationTimestamp
    private LocalDate creationDate;
}
