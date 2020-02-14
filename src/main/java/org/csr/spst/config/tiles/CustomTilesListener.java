package org.csr.front.spring.config.tiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.tiles.StrutsTilesListener;
import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;

public class CustomTilesListener extends AbstractTilesListener {

    private static final Logger LOG = LogManager.getLogger(StrutsTilesListener.class);

    @Override
    protected TilesInitializer createTilesInitializer() {
        LOG.info("Starting Struts Tiles 3 integration ...");
        return new CustomTilesInitializer();
    }
}