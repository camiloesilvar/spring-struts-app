package org.csr.front.web.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.filter.GenericFilterBean;

public class CustomWebFilter extends GenericFilterBean {

    private Logger logger = LogManager.getLogger(CustomWebFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        ThreadContext.put("ID", "12345");
    }

    @Override
    public void destroy() {
    	logger.debug("Seek and destroy!!!!!");
    }

}
