package com.rda.example.jwt;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jay.rao on 2015/12/15.
 */
@Component
public class ContainerConfig implements EmbeddedServletContainerCustomizer {

    private static List<String> allowedHeaders = Arrays.asList(new String[]{"X-Requested-With","Origin",
            "Access-Control-Request-Method", "Access-Control-Request-Headers",
            "X-User-Mobile", "X-User-Token", "X-Product-Info", "X-Product", "X-App-Version", "X-Source-Id", "X-Agent-Mobile", "X-Agent-Token"});
    private static List<String> allowedOrigins = Arrays.asList(CorsConfiguration.ALL);
    private static List<String> allowedMethods = Arrays.asList(CorsConfiguration.ALL);

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
       configurableEmbeddedServletContainer.setPort(9080);
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        UrlBasedCorsConfigurationSource corsConfig = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(allowedHeaders);
        config.setMaxAge(30l);
        config.setAllowedOrigins(allowedOrigins);
        config.setAllowedMethods(allowedMethods);
        corsConfig.registerCorsConfiguration("/rest/*", config);
        CorsFilter corsFilter = new CorsFilter(corsConfig);
        registration.setFilter(corsFilter);
        registration.setUrlPatterns(Arrays.asList("/rest/*"));
        return registration;
    }
}
