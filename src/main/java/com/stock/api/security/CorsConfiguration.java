package com.stock.api.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
//
//@Configuration
//public class CorsConfiguration implements Filter {
//
//    @Bean
//    public CorsConfiguration corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000"); // Replace with your React app's URL
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsConfiguration();
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        String origin = httpServletRequest.getHeader("Origin");
//        if(origin != null && origin.equals("http://localhost:3000/")){
//            chain.doFilter(request, response);
//        }else{
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setStatus(403);
//            httpResponse.getWriter().write("Forbidden");
//        }
//    }
//}
