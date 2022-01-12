package com.portfolio.maven.portfoliomaven;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailService {
    public void sendMail(String address,String name ,String content) throws Exception{
        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        
        Session session = Session.getInstance(props,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("subhankarbiswas1480@gmail.com", "08022001");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("subhankarbiswas1480@gmail.com",false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("subhankarbiswas1480@gmail.com"));
        msg.setSubject("Hiring Mail From : "+name);
        msg.setContent(content,"text/html");
        msg.setSentDate(new Date());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content,"text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);

    }
    
}
