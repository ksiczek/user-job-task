package it.instrumentarium.jobs.entity;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class JobOfferRepository implements PanacheRepository<JobOffer> {
    
}
