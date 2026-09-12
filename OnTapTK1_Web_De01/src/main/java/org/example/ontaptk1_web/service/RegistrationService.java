package org.example.ontaptk1_web.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ontaptk1_web.model.StudentRegistration;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class RegistrationService {

    public StudentRegistration createRegistration(String fullName, String email, String course, String[] skills, String mode){
        return new StudentRegistration(
                fullName,email,course,
                skills != null ? Arrays.asList(skills) : null,
                mode
        );
    }
}
