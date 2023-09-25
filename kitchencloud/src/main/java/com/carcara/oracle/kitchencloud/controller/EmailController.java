package com.carcara.oracle.kitchencloud.controller;


import com.carcara.oracle.kitchencloud.model.EnvioEmail;
import com.carcara.oracle.kitchencloud.service.EmailService;
import com.carcara.oracle.kitchencloud.service.RestTemplateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("rank-pratos-diarios")
    public void rankPratosDiarios (@RequestBody EnvioEmail envioEmail) throws IOException {
        emailService.rankPratosDiarios(envioEmail);
    }
}
