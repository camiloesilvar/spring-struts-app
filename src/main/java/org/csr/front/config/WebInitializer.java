package org.csr.front.config;

import java.util.Collections;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.csr.front.web.config.tiles.CustomTilesListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	
	private static final Logger logger = LogManager.getLogger(WebInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	logger.debug(String.format("Debut config class %s", this.getClass().getName()));
    	logger.info(String.format("Démarrage de l'application %s. (Context path: %s)",
				servletContext.getServletContextName(), servletContext.getContextPath()));
        
        Collections.list(servletContext.getInitParameterNames()).forEach(logger::debug);
        
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        
        /*  Packages où se trouvent les classes "*ConfigurerAdapter". les trois configurations sont équivalentes:
		 * 	1 - webContext.register(ConfigurationClass1.class, ConfigurationClass2.class );
		 *  2 - webContext.setConfigLocations("paq.fich.conf.c1", "paq.fich.conf.c2");
		 *  3 - webContext.setConfigLocation("paq.fich.conf.c1 paq.fich.conf.c2");
		 */
        
        webContext.setConfigLocations("org.csr.front.web.config", "org.csr.back.config");
        //webContext.scan("org.csr.back.model");

        /* Listeners */
        logger.info("Initialization des Listeners ...");
        servletContext.addListener(new ContextLoaderListener(webContext));
        servletContext.addListener(new CustomTilesListener());

        /* Filters */
        logger.info("Initialization des Filters ...");
        // Filtre pour Struts
        FilterRegistration.Dynamic strutsFilter =
            servletContext.addFilter("struts2", new StrutsPrepareAndExecuteFilter());
        strutsFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST), false,
            "*.action");
        strutsFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ERROR), false, "/erreur/*");

        /* Servlets */
        logger.info("Initialization des Servlets ...");
        
        // Spring MVC sous le url /app/*
        ServletRegistration.Dynamic servletSpringMvc =
            servletContext.addServlet("spring-mvc", new DispatcherServlet(webContext));
        servletSpringMvc.setLoadOnStartup(1);
        servletSpringMvc.addMapping("/app/*");
    }

}
