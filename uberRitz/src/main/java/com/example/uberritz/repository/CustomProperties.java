package com.example.uberritz.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "com.example.uberritz")
@Data
public class CustomProperties {

    private String apiUrl;
    
    public String getApiUrl() {

        return this.apiUrl;
    }
}