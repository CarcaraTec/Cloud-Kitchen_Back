package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.EnvioEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateEmailService {

    private final String url = "https://hook.us1.make.com/r63hqv4g54v923bcq44qm16vbbbtdh49";

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateEmailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> enviarPost(EnvioEmail envioEmail) {
        // Crie o corpo da solicitação
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crie a solicitação HTTP com o objeto EnvioEmail
        HttpEntity<EnvioEmail> request = new HttpEntity<>(envioEmail, headers);

        // Faça a solicitação POST
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response;
    }
}
