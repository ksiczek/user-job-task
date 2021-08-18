package it.instrumentarium.jobs.control;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import it.instrumentarium.jobs.entity.IPeopleManager;
import it.instrumentarium.jobs.entity.IPeopleManager.PersonOperationResult;

/**
 * REST endpoint implementing CRUD on {@link it.instrumentarium.jobs.entity.Person} entity.
 */
public class PeopleResource implements PeopleApi {

    @Inject
    IPeopleManager peopleManager;

    @Inject
    Validator validator;

    @Inject
    Logger logger;

    @Override
    public List<Person> peopleGet(Integer page, Integer size, List<String> sort) {
        return peopleManager.listAll().stream().map(this::mapPerson).collect(Collectors.toList());
    }

    @Override
    public Response peopleIdDelete(Long id) {
        PersonOperationResult deleteResult = peopleManager.delete(id);
        if (deleteResult.isSuccess()) {
            return Response.status(Status.NO_CONTENT).build();
        }
        logger.warnf(deleteResult.getException(), "Cound not remove user %d.", id);
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response peopleIdGet(Long id) {
        Person userById = Optional.ofNullable(peopleManager.getById(id)).map(this::mapPerson).orElse(null);
        if (userById == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(userById).build();
    }

    @Override
    public void peopleIdPut(Long id, @Valid PersonUpdate personUpdate) {
        throw new RuntimeException("Not Implemented yet!");
        
    }

    @Override
    public Response peoplePost(@Valid PersonRegistration personRegistration) {
        Set<ConstraintViolation<@Valid PersonRegistration>> validationResult = validator.validate(personRegistration);
        logger.debugf("Validation result is: %s", validationResult);
        if (validationResult.isEmpty()) {
            PersonOperationResult result = peopleManager.add(personRegistration.getLogin(), personRegistration.getName(), personRegistration.getPassword());
            logger.debugf("User creation result is %s.", result);
            return makeResponseFromResult(result);
        } 
        
        return Response.status(Status.BAD_REQUEST).entity(
            new OperationError(validationResult
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining())
            )
            ).build();

    }
    
    private Response makeResponseFromResult(PersonOperationResult result) {
        if (result.isSuccess()) {
            InlineResponse2011 inlineResponse2011 = new InlineResponse2011();
            inlineResponse2011.id(result.getEntity().getId());
            return Response.status(Status.CREATED).entity(inlineResponse2011).build();
        } else if (result.getException() == null) {
            return Response.status(Status.BAD_REQUEST).entity(
                new OperationError(result.getError())
            ).build();
        } 
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }

    private Person mapPerson(it.instrumentarium.jobs.entity.Person person) {
        return new Person().id(person.getId()).creationDate(person.getCreationDate()).login(person.getLogin()).name(person.getName());
    }
    
}
