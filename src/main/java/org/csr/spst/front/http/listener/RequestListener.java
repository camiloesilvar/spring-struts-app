package org.csr.spst.front.http.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestListener implements ServletRequestListener {

	private static final Logger LOG = LogManager.getLogger(SessionListener.class);
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		LOG.debug(String.format("SID : %s", sre.getSource().getClass().getName()));
	}

}
