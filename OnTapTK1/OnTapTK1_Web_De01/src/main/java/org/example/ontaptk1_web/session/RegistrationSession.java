package org.example.ontaptk1_web.session;

import jakarta.enterprise.context.SessionScoped;
import org.example.ontaptk1_web.model.StudentRegistration;

import java.io.Serializable;

@SessionScoped
public class RegistrationSession implements Serializable {
    private StudentRegistration registration;

    public void save(StudentRegistration registration){
        this.registration = registration;
    }

    public StudentRegistration get(){
        return registration;
    }

    public void clear(){
        registration = null;
    }
}
