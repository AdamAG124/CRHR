package com.costaricahomesrealty.CRHR.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class ContactService {

    @Value("${gmail.username}")
    private String username;

    @Value("${gmail.password}")
    private String password;

    public String enviarCorreo(String asunto, String mensaje, String nombreRemitente, String telefonoRemitente, String emailRemitente) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("costaricahomesrealty@gmail.com", "pqhq bxcu nrcm oosy");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("costaricahomesrealty@gmail.com")); // Tu dirección de correo electrónico
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("costaricahomesrealty@gmail.com")); // Tu propia dirección de correo electrónico
            message.setSubject(asunto);

            // Construir el cuerpo del mensaje con HTML y CSS en línea
            String contenidoMensaje = "<html><body style='font-family: Arial, sans-serif; line-height: 1.6; display: flex; justify-content: center;'>"
                    + "<div style='max-width: 1000px; width: 100%; margin: 20px auto; padding: 20px; border: 1px solid #e0e0e0; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);'>"
                    + "<h2 style='color: #f4d85a; background-color: #001701; padding: 10px;'>Nuevo mensaje recibido</h2>"
                    + "<div style='background-color: #f2f2f2; margin: 10px 0; padding: 5px;'><strong>Nombre:</strong></div><p>" + nombreRemitente + "</p>"
                    + "<div style='background-color: #f2f2f2; margin: 10px 0; padding: 5px;'><strong>Teléfono:</strong></div><p>" + telefonoRemitente + "</p>"
                    + "<div style='background-color: #f2f2f2; margin: 10px 0; padding: 5px;'><strong>Correo Electrónico:</strong></div><p>" + emailRemitente + "</p>"
                    + "<div style='background-color: #f2f2f2; margin: 10px 0; padding: 5px;'><strong>Mensaje:</strong></div>"
                    + "<div style='background-color: #f9f9f9; padding: 10px; border: 1px solid #e0e0e0; box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);'>" + mensaje + "</div>"
                    + "</div>"
                    + "</body></html>";



            message.setContent(contenidoMensaje, "text/html; charset=utf-8");

            Transport.send(message);

            enviarCorreoCliente(nombreRemitente, emailRemitente);
            return "{\"success\": true, \"message\": \"¡Mensaje enviado exitosamente! Le responderemos via correo electronico\"}";

        } catch (MessagingException e) {
            return "{\"success\": false, \"message\": \"Hubo un error enviando su mensaje: " + e.getMessage() + "\"}";
        }
    }

    public String enviarCorreoCliente(String nombreRemitente, String emailRemitente) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("costaricahomesrealty@gmail.com", "pqhq bxcu nrcm oosy");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("costaricahomesrealty@gmail.com")); // Tu dirección de correo electrónico
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRemitente));
            message.setSubject("¡Gracias por escribirnos!");

            // Construir el cuerpo del mensaje con HTML y CSS en línea
            String contenidoMensaje = "<html><body style='font-family: Arial, sans-serif; line-height: 1.6; display: flex; justify-content: center;'>"
                    + "<div style='max-width: 1000px; width: 100%; margin: 20px auto; padding: 20px; border: 1px solid #e0e0e0; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);'>"
                    + "<h2 style='color: #f4d85a; background-color: #001701; padding: 10px; text-align: center;'>¡Gracias por escribirnos, " + nombreRemitente + "!</h2>"
                    + "<p style='text-align: center;'>Hemos recibido tu mensaje y uno de nuestros colaboradores te responderá pronto.</p>"
                    + "<p style='text-align: center;'>Mientras tanto, puedes seguirnos en nuestras redes sociales:</p>"
                    + "<div style='text-align: center; margin: 20px 0;'>"
                    + "<a href='https://www.facebook.com/profile.php?id=61556631089453' style='text-decoration: none; margin: 0 10px; color: #f4d85a;'><i class='fab fa-facebook' style='font-size: 40px; margin-right: 10px;'></i> Facebook</a>"
                    + "<a href='https://www.instagram.com/crhomesrealty/' style='text-decoration: none; margin: 0 10px; color: #f4d85a;'><i class='fab fa-instagram' style='font-size: 40px; margin-right: 10px;'></i> Instagram</a>"
                    + "</div>"
                    + "<p style='text-align: center;'>O visita nuestro sitio web:</p>"
                    + "<p style='text-align: center;'><a href='https://www.costaricahomesrealty.com' style='color: #f4d85a; text-decoration: none;'>www.costaricahomesrealty.com</a></p>"
                    + "<p style='text-align: center;'><em>¡Gracias por confiar en nosotros!</em></p>"
                    + "</div>"
                    + "<script src='https://kit.fontawesome.com/51553d23ad.js' crossorigin='anonymous'></script>" // Incluir Font Awesome
                    + "</body></html>";






            message.setContent(contenidoMensaje, "text/html; charset=utf-8");

            Transport.send(message);

            return "{\"success\": true, \"message\": \"¡Mensaje enviado exitosamente! Le responderemos via correo electronico\"}";

        } catch (MessagingException e) {
            return "{\"success\": false, \"message\": \"Hubo un error enviando su mensaje: " + e.getMessage() + "\"}";
        }
    }


}
