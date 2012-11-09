

/*
 * Copyright (c) CMG Ltd All rights reserved.

 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
 package com.bp.pensionline.automation.util; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/** 
 * DOCME * 
 * 
 * @author Long Nguyen *
 * @version .Revision: # .Date:Sep 5, 2012*
 */
public class MailUtil {
    public void sendMailPL(String body, int status) throws javax.mail.MessagingException {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
	
	Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "long.nguyen@c-mg.com", "long1123581321");
                    }
                });
        
       //staus = 1 mean Test Pass
        if (status == 1) {
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("huong.vu@c-mg.com"));
            message.setSubject("Pensionline Daily Test - "+ dateFormat.format(date));
            message.setContent(body, "text/html");

            Transport.send(message);
            
            MimeMessage message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("my.vu@c-mg.com"));
            message1.setSubject("Pensionline Daily Test - "+ dateFormat.format(date));
            message1.setContent(body, "text/html");
            
            Transport.send(message1);
            
            MimeMessage message2 = new MimeMessage(session);
            message2.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message2.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("anh.nguyen@c-mg.com"));
            message2.setSubject("Pensionline Daily Test - "+ dateFormat.format(date));
            message2.setContent(body, "text/html");
            
            Transport.send(message2);
            
            MimeMessage message3 = new MimeMessage(session);
            message3.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message3.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("tuan.nguyen@c-mg.com"));
            message3.setSubject("Pensionline Daily Test - "+ dateFormat.format(date));
            message3.setContent(body, "text/html");
            
            Transport.send(message3);
        }

        //status = 2 mean Test Failed
        if (status == 2) {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("huong.vu@c-mg.com"));
            message.setSubject("Failed Pensionline Daily Test - "+ dateFormat.format(date));
            message.setContent(body, "text/html");

            Transport.send(message);
            
            MimeMessage message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("my.vu@c-mg.com"));
            message1.setSubject("Failed Pensionline Daily Test - "+ dateFormat.format(date));
            message1.setContent(body, "text/html");
            
            Transport.send(message1);
            
            MimeMessage message2 = new MimeMessage(session);
            message2.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message2.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("anh.nguyen@c-mg.com"));
            message2.setSubject("Failed Pensionline Daily Test - "+ dateFormat.format(date));
            message2.setContent(body, "text/html");
            
            Transport.send(message2);
            
            MimeMessage message3 = new MimeMessage(session);
            message3.setFrom(new InternetAddress("long.nguyen@c-mg.com"));
            message3.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("tuan.nguyen@c-mg.com"));
            message3.setSubject("Failed Pensionline Daily Test - "+ dateFormat.format(date));
            message3.setContent(body, "text/html");
            
            Transport.send(message3);
        }
    }
}

