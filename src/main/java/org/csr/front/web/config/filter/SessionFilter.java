package org.csr.front.web.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SessionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			//makeAction();
			chain.doFilter(request, response);
		}catch (Exception e) {
			throw new ServletException("Excepción controlada por el filtro");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	private void makeAction() throws IndexOutOfBoundsException{
		throw new IndexOutOfBoundsException("Error Controlado...");
	}

}
