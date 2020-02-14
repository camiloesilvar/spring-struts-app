package org.csr.spst.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.csr.spst.config.tiles.CustomTilesListener;
import org.csr.spst.config.web.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebMvcConfig.class);
        ctx.scan("org.csr.spst.config.data");

        /* Listeners */
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new CustomTilesListener());

        /* Filters */

        // Filtre pour Struts
        FilterRegistration.Dynamic strutsFilter =
            servletContext.addFilter("struts2", new StrutsPrepareAndExecuteFilter());
        strutsFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST), false,
            "*.action");
        strutsFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ERROR), false, "/erreur/*");

        /* Servlets */
        // Spring MVC sous le url /app/*
        ServletRegistration.Dynamic servletSpringMvc =
            servletContext.addServlet("spring-mvc", new DispatcherServlet(ctx));
        servletSpringMvc.setLoadOnStartup(1);
        servletSpringMvc.addMapping("/app/*");
    }

}
