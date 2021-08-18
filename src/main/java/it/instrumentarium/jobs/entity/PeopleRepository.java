package it.instrumentarium.jobs.entity;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PeopleRepository implements PanacheRepository<Person> {
    public Person findByLogin(String login){
        return find("login", login).firstResult();
    }
}
