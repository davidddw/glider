package org.d05660.jbuilder.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("org.d05660.jbuilder.action");
        register(JacksonFeature.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}
