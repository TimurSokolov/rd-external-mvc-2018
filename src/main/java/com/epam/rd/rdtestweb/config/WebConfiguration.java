package com.epam.rd.rdtestweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.epam.rd.rdtestweb.interceptor.AuthInterceptor;



/**
 * Конфигуратор интерсептеров. Настраивает защищаемые разделы.
 * 
 * @author Timur_Sokolov
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Бин общего интерсептера проверки наличия аутентификации
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/login", "/registration",
                "/logout", "/css/**", "/js/**", "/checkloginexist");
    }

}
