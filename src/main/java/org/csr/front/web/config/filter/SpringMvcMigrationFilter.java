package org.csr.front.web.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;

public class SpringMvcMigrationFilter implements Filter {
    private static final Log LOGGER = LogFactory.getLog(SpringMvcMigrationFilter.class);

    /**
     * Le locale resolver utilisé par l'application.
     */
    private LocaleResolver localeResolver;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initLocaleResolver(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        // Initialise le locale resolver dans un attribut de la requête. On l'ajoute dans
        // cet attribut comme le dispatcher servlet de Spring MVC car la classe
        // org.springframework.web.servlet.support.RequestContextUtils le récupère à cet
        // endroit.
        request.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, this.localeResolver);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Rien à faire.
    }

    /**
     * Initialise le locale resolver avec celui récupérer dans le context Spring.
     * 
     * @param filterConfig le filter config.
     */
    private void initLocaleResolver(FilterConfig filterConfig) {
        try {
            this.localeResolver = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext())
                .getBean(DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME, LocaleResolver.class);
        } catch (NoSuchBeanDefinitionException ex) {
            LOGGER.error("Aucun bean Spring de type LocaleResolver n'a été défini avec le nom '"
                + DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME + "'");

            throw ex;
        }
    }
}
