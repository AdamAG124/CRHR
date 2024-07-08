package com.costaricahomesrealty.CRHR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentasController {
    @GetMapping("/disponibles")
    public String listarAlquileres(){
        return "ventas/ventas_public";
    }
}
