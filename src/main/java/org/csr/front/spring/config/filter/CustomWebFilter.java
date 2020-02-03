package org.csr.front.spring.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.web.filter.GenericFilterBean;

public class CustomWebFilter extends GenericFilterBean {

    private Logger LOGGER = Logger.getLogger(CustomWebFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        MDC.put("ID", "12345");
    }

    @Override
    public void destroy() {
        LOGGER.debug("Seek and destroy!!!!!");
    }

}
