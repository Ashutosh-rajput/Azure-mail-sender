package com.azure.emailbygraphapi;

public interface MailService {

    void sendMail();

    default String getReportHtml() {

        StringBuilder htmlReport = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border:1px solid black;\n" +
                "}\n" +
                "\n" +
                "p.note {\n" +
                "\tcolor:red;\n" +
                "    text-align: center;\n" +
                "font-size: 85%\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n" +
                "\n" +
                "<p>Hello Team,</p>\n");

        htmlReport.append("<p>Thanks & Regards, <br> Ashutosh Rajput</p>\n");
        htmlReport.append("<br>\n <p class=\"note\"><strong>This is an automated email. Please do not respond as the mailbox is not monitored.</p>\n");
        htmlReport.append("</body> </html>");
        return htmlReport.toString();
    }

}
