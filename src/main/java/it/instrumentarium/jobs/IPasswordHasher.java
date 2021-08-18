package it.instrumentarium.jobs;

/**
 * An abstraction of component that hashes passwords
 */
public interface IPasswordHasher {
    String hashPass(String pass);
}
