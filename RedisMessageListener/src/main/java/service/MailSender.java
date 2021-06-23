package service;

import entity.SimpleMessage;

import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {

    private Session session;

    public MailSender(Session session) {
        this.session = session;
    }

    public void Send(SimpleMessage simpleMessage) throws MessagingException {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("rizkyysa@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("rizkysaputra000@gmail.com"));
        message.setSubject("Redis pub/sub");

        String msg = "Email send from redis publisher\n " + simpleMessage.toString();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
