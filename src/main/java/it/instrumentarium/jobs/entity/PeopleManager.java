package it.instrumentarium.jobs.entity;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import it.instrumentarium.jobs.IPasswordHasher;

@ApplicationScoped
public class PeopleManager implements IPeopleManager {

    @Inject
    IPasswordHasher passwordHasher;

    @Inject
    PeopleRepository peopleRepo;

    @Transactional
    public PersonOperationResult add(String login, String name, String password) {
        if (isLoginTaken(login)) {
            return PersonOperationResult.err("Login uniqueness violated.");
        }
        Person person = new Person();
        person.setLogin(login);
        person.setName(name);
        person.setPassword(passwordHasher.hashPass(password));
        try {
            peopleRepo.persist(person);
            return PersonOperationResult.ok(person);
        } catch (Exception e) {
            return PersonOperationResult.err(e);
        }

    }

    private boolean isLoginTaken(String login) {
        return peopleRepo.findByLogin(login) != null;
    }

    public List<Person> listAll() {
        return peopleRepo.listAll();
    }

    public Person getById(Long id) {
        return peopleRepo.findById(id);
    }

    @Override
    @Transactional
    public PersonOperationResult delete(Long id) {
        try {
            peopleRepo.deleteById(id);
            return PersonOperationResult.ok(null);
        } catch (Exception e) {
            return PersonOperationResult.err(e);
        }
        
    }


}
