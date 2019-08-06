package org.csr.front.spring.config.tiles;

import org.apache.struts2.tiles.StrutsTilesContainerFactory;
import org.apache.tiles.locale.LocaleResolver;
import org.apache.tiles.request.ApplicationContext;

public class CustomTilesContainerFactory extends StrutsTilesContainerFactory {

    protected LocaleResolver createLocaleResolver(ApplicationContext applicationContext) {
        return new CustomTilesLocaleResolver();
    }
}
