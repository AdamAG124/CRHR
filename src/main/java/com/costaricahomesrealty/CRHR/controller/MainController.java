/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.costaricahomesrealty.CRHR.controller;

import com.costaricahomesrealty.CRHR.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Adam Acuña
 */
@Controller
public class MainController {
    @GetMapping({"/index", "/", "/home"})
    public String hello() {
        return "index";
    }

    @GetMapping("/headerContact")
    public String headerContact() {
        return "headerContactInfo";
    }

    @GetMapping("/footerDerechos")
    public String footerDerechos() {
        return "footer";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contactForm";
    }

    @PostMapping("/sendContactForm")
    public ResponseEntity<?> sendContactForm(@RequestParam("name") String nombre, @RequestParam("phone") String telefono, @RequestParam("email") String correo, @RequestParam("subject") String asunto, @RequestParam("message") String mensaje) {
        //System.out.println("Nombre: " + nombre + " Telefono: " + telefono + " Correo: " + correo + " Mensaje: " + mensaje);
        return ResponseEntity.ok().body(new ContactService().enviarCorreo(asunto, mensaje, nombre, telefono, correo));
    }
}
