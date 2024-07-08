package com.costaricahomesrealty.CRHR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alquileres")
public class AlquileresController {

    @GetMapping("/disponibles")
    public String listarAlquileres(){
        return "alquileres/alquileres_public";
    }
}
