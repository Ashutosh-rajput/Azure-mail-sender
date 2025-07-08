package com.azure.emailbygraphapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {


    private final MailService graphService;



    @PostMapping("/graph/{client}")
    public MailResponse sendMailGraph(@PathVariable String client) {

        graphService.sendMail();
        return new MailResponse(HttpStatus.OK, "Mail sent successfully to the client " + client);

    }
}
