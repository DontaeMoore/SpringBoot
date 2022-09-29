package com.TB_Challenge.config;

import com.TB_Challenge.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public DataSource getDataSource() {


        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://www.thompsonprojects.com:3306/thompson_challenge?reconnect=true");
        dataSource.setUsername("thompson_dontaedb");
        dataSource.setPassword("Progamer102345678");



        return dataSource;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public TrackDAO getCOntactDAO() {
        return new TrackDAOImpl(getDataSource());
    }

    @Bean
    public UserDAO getUserDAO() { return new UserDAOImpl(getDataSource());

    }

    @Bean
    public RaceDAO getRaceDAO() { return new RaceDAOImpl(getDataSource());

    }

    @Bean
    public ChallengeDAO getChallengeDAO() { return new ChallengeDAOImpl(getDataSource());

    }

    @Bean
    public RaceHorseDAO getRaceHorseDAO() { return new RaceHorseDAOImpl(getDataSource());

    }

}