package com.azure.emailbygraphapi;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.*;
import com.microsoft.graph.requests.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmailService implements MailService {
    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${tenantId}")
    private String tenantId;
    public void sendMail() {
        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId)
                .build();

        List<String> scopes = new ArrayList<>();
        scopes.add("https://graph.microsoft.com/.default");

        final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(scopes, clientSecretCredential);

        final GraphServiceClient graphClient =
                GraphServiceClient
                        .builder()
                        .authenticationProvider(tokenCredentialAuthProvider)
                        .buildClient();

        Message message = new Message();
        message.subject = "Sample Subject";
        ItemBody body = new ItemBody();
        body.contentType = BodyType.HTML;

        body.content = getReportHtml(); //getReportHtml method returns html string
        message.body = body;

        LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
        Recipient toRecipients = new Recipient();
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = "abc@outlook.com";
        toRecipients.emailAddress = emailAddress;
        toRecipientsList.add(toRecipients);
        message.toRecipients = toRecipientsList;

        LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
        Recipient ccRecipients = new Recipient();
        EmailAddress emailAddress1 = new EmailAddress();
        emailAddress1.address = "def@outlook.com";
        ccRecipients.emailAddress = emailAddress1;
        ccRecipientsList.add(ccRecipients);
        message.ccRecipients = ccRecipientsList;

        graphClient.users("fromEmailId")
                .sendMail(UserSendMailParameterSet
                        .newBuilder()
                        .withMessage(message)
                        .withSaveToSentItems(true)
                        .build())
                .buildRequest()
                .post();
    }


}
