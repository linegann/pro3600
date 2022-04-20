package com.example.uberritz.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.uberritz.model.Plat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PlatProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all plats
     * @return An iterable of all plats
     */

    public Iterable<Plat> getPlats() {
        String baseApiUrl = props.getApiUrl();
        String getPlatsUrl = baseApiUrl + "/plats";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Plat>> response = restTemplate.exchange(
                getPlatsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Plat>>() {}
        );

        return response.getBody();
    }

    public Iterable<Plat> getPlat( final int id){
        String baseApiUrl = props.getApiUrl();
        String getPlatUrl = baseApiUrl + "/plat/{id}";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Plat>> response = restTemplate.exchange(
                getPlatUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Plat>>() {}
        );

        return response.getBody();
    }

    public Plat createPlat(Plat p) {
        String baseApiUrl = props.getApiUrl();
        String createPlatUrl = baseApiUrl + "/plat";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Plat> request = new HttpEntity<Plat>(p);
        ResponseEntity<Plat> response = restTemplate.exchange(
                createPlatUrl,
                HttpMethod.POST,
                request,
                Plat.class);

        return response.getBody();
    }

    public Iterable<Plat> deletePlat(final int id) {
        String baseApiUrl = props.getApiUrl();
        String deletePlatUrl = baseApiUrl + "/plat/{id}";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Plat>> response = restTemplate.exchange(
                deletePlatUrl,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<>() {}
                );

        return response.getBody();
    }

    public Plat updatePlat(Plat p) {
        String baseApiUrl = props.getApiUrl();
        String updatePlatUrl = baseApiUrl + p.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Plat> request = new HttpEntity<Plat>(p);
        ResponseEntity<Plat> response = restTemplate.exchange(
                updatePlatUrl,
                HttpMethod.PUT,
                request,
                Plat.class);

        return response.getBody();
    }

}