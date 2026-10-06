package org.example.www_tuan06_bai05_rest;


import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RestApplicationConfig extends ResourceConfig {

    public RestApplicationConfig() {
        packages("org.example.www_tuan06_bai05_rest.resource");
    }
}

