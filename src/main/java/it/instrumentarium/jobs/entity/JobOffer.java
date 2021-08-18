package it.instrumentarium.jobs.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobOffer {
    @Id @GeneratedValue private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employerId;
    private String category;    
}
