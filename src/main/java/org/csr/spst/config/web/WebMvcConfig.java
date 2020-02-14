package org.csr.spst.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.csr.spst.front.spring.controller" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
            new String[] { "/WEB-INF/tiles.xml", "/WEB-INF/tiles-spring.xml", "/WEB-INF/tiles-struts.xml" });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/static/");
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(0);
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(0);
        registry.addResourceHandler("/img/**").addResourceLocations("/static/img/");
        registry.addResourceHandler("/webfonts/**").addResourceLocations("/static/webfonts/").setCachePeriod(0);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/inicio.html");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	// Alternativa de configuracion
//    	registry.tiles();
//      registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
        
        // Enregistrement d'un resolver pour les Tiles.
        TilesViewResolver tileViewResolver = new TilesViewResolver();
        registry.viewResolver(tileViewResolver);

        // Enregistrement d'un resolver pour les JSPs.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
    
    
}
