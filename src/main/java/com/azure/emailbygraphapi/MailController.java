package com.azure.emailbygraphapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {
    private final MailService graphService;


    @PostMapping("/graph")
    public MailResponse sendMailGraph() {

        graphService.sendMail();
        return new MailResponse(HttpStatus.OK, "Mail sent successfully to the client ");

    }
}
