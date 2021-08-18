package it.instrumentarium.jobs;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class DefaultPasswordHasher implements IPasswordHasher {

    @Override
    public String hashPass(String pass) {
        return BcryptUtil.bcryptHash(pass);
    }
    
}
