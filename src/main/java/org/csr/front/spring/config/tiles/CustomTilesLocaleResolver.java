package org.csr.front.spring.config.tiles;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.tiles.StrutsTilesLocaleResolver;
import org.apache.tiles.locale.LocaleResolver;
import org.apache.tiles.locale.impl.DefaultLocaleResolver;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.servlet.ServletUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.LocaleProviderFactory;

public class CustomTilesLocaleResolver implements LocaleResolver {

    private static Logger LOG = LogManager.getLogger(StrutsTilesLocaleResolver.class);

    @Override
    public Locale resolveLocale(Request request) {
        HttpServletRequest httpRequest = ServletUtil.getServletRequest(request).getRequest();
        ActionContext ctx = ServletActionContext.getActionContext(httpRequest);

        if (ctx != null) {
            LocaleProviderFactory localeProviderFactory = ctx.getInstance(LocaleProviderFactory.class);
            return localeProviderFactory.createLocaleProvider().getLocale();
        } else {
            DefaultLocaleResolver defaultLocaleResolver = new DefaultLocaleResolver();
            return defaultLocaleResolver.resolveLocale(request);
        }

    }

}
