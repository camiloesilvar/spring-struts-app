package org.csr.front.http.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {
	private static final Logger LOG = LogManager.getLogger(SessionListener.class);
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOG.debug(String.format("SID : %s", se.getSession().getId()));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
