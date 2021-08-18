package it.instrumentarium.jobs.entity;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Syntactic sugar and abstraction over people respository.
 */
public interface IPeopleManager {
    PersonOperationResult add(String login, String name, String password);
    List<Person> listAll();
    Person getById(Long id);

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    public static class PersonOperationResult {
        private final boolean success;
        private final String error;
        private final Person entity;
        private final Exception exception;

        static PersonOperationResult ok(Person p) {
            return new PersonOperationResult(true, null, p, null);
        }

        static PersonOperationResult err(String msg) {
            return new PersonOperationResult(false, msg, null, null);
        }

        public static PersonOperationResult err(Exception e) {
            return new PersonOperationResult(false, null, null, e);
        }
    }

    PersonOperationResult delete(Long id);
}
