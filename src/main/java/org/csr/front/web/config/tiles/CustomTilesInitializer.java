package org.csr.front.web.config.tiles;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.tiles.StrutsTilesInitializer;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.apache.tiles.startup.AbstractTilesInitializer;

public class CustomTilesInitializer extends AbstractTilesInitializer {
    private static final Logger LOG = LogManager.getLogger(StrutsTilesInitializer.class);

    @Override
    protected ApplicationContext createTilesApplicationContext(ApplicationContext preliminaryContext) {
        ServletContext servletContext = (ServletContext) preliminaryContext.getContext();

        if (servletContext.getInitParameter(DefinitionsFactory.DEFINITIONS_CONFIG) != null) {
            LOG.trace("Found definitions config in web.xml, using standard Servlet support ....");
            return new ServletApplicationContext(servletContext);
        } else {
            LOG.trace("Initializing Tiles wildcard support ...");
            return new CustomStrutsWildcardServletApplicationContext(servletContext);
        }
    }

    @Override
    protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext context) {
        LOG.trace("Creating dedicated Struts factory to create Tiles container");
        return new CustomTilesContainerFactory();
    }
}
