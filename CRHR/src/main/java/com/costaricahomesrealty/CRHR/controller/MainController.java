/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.costaricahomesrealty.CRHR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
